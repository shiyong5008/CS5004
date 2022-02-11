package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Yuchen Liu
 */
public class Kosaraju {

  public List<List<Integer>> executeKosaraju(List<Integer>[] graph) {
    List<List<Integer>> result = new ArrayList<>();
    int vertexNum = graph.length;
    boolean[] visited = new boolean[vertexNum];

    // step 1
    List<Integer> graphOrder = getOrderOfTheGraph(graph, visited);
    Collections.reverse(graphOrder);

    // step 2
    List<Integer>[] reversedGraph = reverseGraph(graph);
    Arrays.fill(visited, false);

    // step 3
    for (int v : graphOrder) {
      if (!visited[v]) {
        List<Integer> scc = new ArrayList<>();
        dfs(reversedGraph, v, visited, scc);
        result.add(scc);
      }
    }

    return result;
  }

  /**
   * Step 1: get the order of the original graph with first DFS. This order will be used in the
   * second DFS
   */
  private List<Integer> getOrderOfTheGraph(List<Integer>[] graph, boolean[] visited) {
    List<Integer> graphOrder = new ArrayList<>();
    int vertexNum = graph.length;

    for (int i = 0; i < vertexNum; i++) {
      if (!visited[i]) {
        dfs(graph, i, visited, graphOrder);
      }
    }

    return graphOrder;
  }

  /**
   * Step 2: reverse the graph
   */
  private List<Integer>[] reverseGraph(List<Integer>[] graph) {
    int vertexNum = graph.length;
    List<Integer>[] reversedGraph = new List[vertexNum];

    for (int i = 0; i < vertexNum; i++) {
      reversedGraph[i] = new ArrayList<>();
    }

    for (int v = 0; v < vertexNum; v++) {
      for (int i = 0; i < graph[v].size(); i++) {
        reversedGraph[graph[v].get(i)].add(v);
      }
    }

    return reversedGraph;
  }

  private void dfs(List<Integer>[] graph, int vertex, boolean[] visited,
      List<Integer> component) {
    visited[vertex] = true;

    for (int i = 0; i < graph[vertex].size(); i++) {
      if (!visited[graph[vertex].get(i)]) {
        dfs(graph, graph[vertex].get(i), visited, component);
      }
    }
    component.add(vertex);
  }
}
