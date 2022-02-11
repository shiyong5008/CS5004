package main.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yuchen Liu
 */
public class FloydWarshall {

  public List<List<Integer>> executeFloydWarshall(int vertexNum, List<Integer[]> edgeInfos) {
    int[][] matrix = initializeMatrix(vertexNum, edgeInfos);
    for (int k = 1; k <= vertexNum; k++) {
      for (int i = 1; i <= vertexNum; i++) {
        for (int j = 1; j <= vertexNum; j++) {
          if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) {
            continue;
          }
          if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
            matrix[i][j] = matrix[i][k] + matrix[k][j];
          }
        }
      }
    }
    return convertArrayToList(matrix);
  }

  private int[][] initializeMatrix(int vertexNum, List<Integer[]> edgeInfos) {
    // initialize the matrix
    int[][] matrix = new int[vertexNum + 1][vertexNum + 1];

    // the weight of one vertex to itself is 0
    // the weight from one vertex to another will be Integer.MAX_VALUE before calculation
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == j) {
          matrix[i][j] = 0;
        } else {
          matrix[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    // make the first row and first col as the vertex number
    for (int i = 0; i <= vertexNum; i++) {
      matrix[0][i] = i - 1;
      matrix[i][0] = i - 1;
    }

    // add known edge information into matrix
    for (Integer[] edgeInfo : edgeInfos) {
      int row = edgeInfo[0];
      int col = edgeInfo[1];
      int weight = edgeInfo[2];

      matrix[row][col] = weight;
    }
    return matrix;
  }

  private List<List<Integer>> convertArrayToList(int[][] matrix) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 1; i < matrix.length; i++) {
      // convert int[] to List<Integer>
      List<Integer> list = Arrays.stream(matrix[i]).boxed().collect(Collectors.toList());
      // remove the index element
      list.remove(0);
      result.add(list);
    }

    return result;
  }
}
