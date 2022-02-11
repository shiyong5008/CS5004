package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuchen Liu
 */
public class RecommendService {

  private List<List<Integer>> sccs;
  private List<Integer>[] graph;
  private List<List<Integer>> distanceMatrix;
  private int vertexNum;
  private Map<Integer, Integer> vertexMap;

  public RecommendService(List<Integer>[] graph, List<List<Integer>> sccs, List<List<Integer>> distanceMatrix) {
    this.graph = graph;
    this.sccs = sccs;
    this.distanceMatrix = distanceMatrix;
    this.vertexNum = graph.length;
    this.vertexMap = this.getVertexSCCMap();
  }

  /**
   * Recommend the 1st level candidates to each vertice
   * The candidates can't be within the same SCC as the current vertice
   */
  public List<List<Integer>> recommendFirstCandidate() {
    List<List<Integer>> firstCandidateList = new ArrayList<>();

    for (int i = 0; i < vertexNum; i++) {
      List<Integer> distanceList = this.distanceMatrix.get(i);
      int currentSCCIdx = this.vertexMap.get(i);
      List<Integer> currentSCC = this.sccs.get(currentSCCIdx);
      List<Integer> candidates = new ArrayList<>();

      // iterate through the distance list, find the vertex with distance 2 and not in the current SCC
      for (int j = 0; j < distanceList.size(); j++) {
        if (!currentSCC.contains(j) && distanceList.get(j) == 2) {
          candidates.add(j);
        }
      }
      firstCandidateList.add(candidates);
    }
    return firstCandidateList;
  }

  /**
   * Create a mapping relation between each vertex and the SCC it belongs to
   */
  private Map<Integer, Integer> getVertexSCCMap() {
    Map<Integer, Integer> vertexMap = new HashMap<>();

    for (int i = 0; i < this.sccs.size(); i++) {
      for (int vertex : this.sccs.get(i)) {
        vertexMap.put(vertex, i);
      }
    }

    return vertexMap;
  }

}
