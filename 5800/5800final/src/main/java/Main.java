package main.java;

import java.util.ArrayList;
import java.util.List;
import main.Java.FloydWarshall;

/**
 * @author Yuchen Liu
 */
public class Main {

  private List<Integer>[] buildGraph(int vertexNum) {
    List<Integer>[] graph = new List[vertexNum];
    for (int i = 0; i < vertexNum; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(1);
    graph[1].add(2);
    graph[2].add(0);
    graph[2].add(3);
    graph[3].add(4);
    graph[4].add(5);
    graph[4].add(7);
    graph[5].add(6);
    graph[6].add(7);
    graph[6].add(4);

    return graph;
  }

  private List<List<Integer>> buildDistanceMatrix(int vertexNum, List<Integer[]> edgeInfos) {
    FloydWarshall floydWarshall = new FloydWarshall();

    edgeInfos.add(new Integer[]{1, 2, 1});
    edgeInfos.add(new Integer[]{2, 3, 1});
    edgeInfos.add(new Integer[]{3, 1, 1});
    edgeInfos.add(new Integer[]{3, 4, 1});
    edgeInfos.add(new Integer[]{4, 5, 1});
    edgeInfos.add(new Integer[]{5, 6, 1});
    edgeInfos.add(new Integer[]{5, 8, 1});
    edgeInfos.add(new Integer[]{6, 7, 1});
    edgeInfos.add(new Integer[]{7, 5, 1});
    edgeInfos.add(new Integer[]{7, 8, 1});

    List<List<Integer>> distanceMatrix = floydWarshall.executeFloydWarshall(vertexNum, edgeInfos);

    return distanceMatrix;
  }

  private List<List<Integer>> getSCCs(List<Integer>[] graph) {
    Kosaraju kosaraju = new Kosaraju();
    List<List<Integer>> sccs = kosaraju.executeKosaraju(graph);

    return sccs;
  }

  private void displayList(List<List<Integer>> lists) {
    for (int i = 0; i < lists.size(); i++) {
      List<Integer> list = lists.get(i);
      if (list.size() == 0) {
        System.out.println("Sorry, no recommendation for vertex " + i);
        continue;
      }

      System.out.print("Recommendations for vertex " + i + ": ");
      for (Integer vertex : list) {
        System.out.print(vertex + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Main main = new Main();
    int vertexNum = 8;
    List<Integer>[] graph = main.buildGraph(vertexNum);
    List<List<Integer>> distanceMatrix = main.buildDistanceMatrix(vertexNum, new ArrayList<>());
    List<List<Integer>> sccs = main.getSCCs(graph);

    RecommendService recommendService = new RecommendService(graph, sccs, distanceMatrix);
    List<List<Integer>> firstCandidateList = recommendService.recommendFirstCandidate();

    main.displayList(firstCandidateList);
  }
}
