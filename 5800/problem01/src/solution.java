import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solution {
    int[][] scoreMatrix;
    int n;
    List<List<Integer>> list;
    int weight;

    // input for the 27 students result.
    public solution(int weight) {
        int[][] newMatrix = new int[][] {
                {0,2,2,0,1,10,1,1,1,1,1,2,0,1,7,1,0,0,8,10,0,1,3,0,4,2,4},
                {2,0,4,0,0,2,2,1,0,2,1,0,6,2,4,4,0,1,2,0,6,0,0,4,3,2,2},
                {2,4,0,7,0,1,0,2,2,6,2,2,2,0,4,2,1,8,1,1,2,4,1,3,4,0,4},
                {0,0,7,0,0,2,2,6,0,5,1,0,2,0,2,1,0,8,0,0,6,4,4,1,10,2,3},
                {1,0,0,0,0,1,1,0,1,1,2,2,2,1,1,2,1,2,0,0,1,0,2,2,4,1,4},
                {10,2,1,2,1,0,0,1,2,2,0,2,1,0,7,0,2,1,9,6,0,1,4,2,4,1,3},
                {1,2,0,2,1,0,0,1,2,2,1,1,2,2,0,0,2,0,1,1,1,5,1,4,3,2,4},
                {1,1,2,6,0,1,1,0,2,5,2,0,1,1,1,1,2,2,0,2,2,1,1,1,2,2,3},
                {1,0,2,0,1,2,2,2,0,2,1,2,2,2,2,1,1,1,1,1,2,2,0,4,0,0,4},
                {1,2,6,5,1,2,2,5,2,0,0,2,1,2,1,2,1,6,2,1,0,2,3,2,0,1,2},
                {1,1,2,1,2,0,1,2,1,0,0,3,0,0,2,0,2,2,2,4,0,1,1,6,5,4,1},
                {2,0,2,0,2,2,1,0,2,2,3,0,2,1,2,2,1,2,2,1,1,2,1,1,2,2,4},
                {0,6,2,2,2,1,2,1,2,1,0,2,0,1,2,10,1,0,1,2,0,0,1,2,6,1,4},
                {1,2,0,0,1,0,2,1,2,2,0,1,1,0,1,2,2,0,2,1,2,1,0,0,2,0,2},
                {7,4,4,2,1,7,0,1,2,1,2,2,2,1,0,2,0,0,8,8,2,1,4,1,6,2,3},
                {1,4,2,1,2,0,0,1,1,2,0,2,10,2,2,0,0,1,2,0,1,2,0,2,2,2,2},
                {0,0,1,0,1,2,2,2,1,1,2,1,1,2,0,0,0,0,0,1,0,2,2,2,2,2,3},
                {0,1,8,8,2,1,0,2,1,6,2,2,0,0,0,1,0,0,0,2,5,0,7,2,4,2,0},
                {8,2,1,0,0,9,1,0,1,2,2,2,1,2,8,2,0,0,0,8,1,0,8,6,7,1,3},
                {10,0,1,0,0,6,1,2,1,1,4,1,2,1,8,0,1,2,8,0,0,0,2,0,2,1,2},
                {0,6,2,6,1,0,1,2,2,0,0,1,0,2,2,1,0,5,1,0,0,1,0,1,9,2,3},
                {1,0,4,4,0,1,5,1,2,2,1,2,0,1,1,2,2,0,0,0,1,0,1,6,6,6,4},
                {3,0,1,4,2,4,1,1,0,3,1,1,1,0,4,0,2,7,8,2,0,1,0,1,4,0,3},
                {0,4,3,1,2,2,4,1,4,2,6,1,2,0,1,2,2,2,6,0,1,6,1,0,6,2,4},
                {4,3,4,10,4,4,3,2,0,0,5,2,6,2,6,2,2,4,7,2,9,6,4,6,0,2,6},
                {2,2,0,2,1,1,2,2,0,1,4,2,1,0,2,2,2,2,1,1,2,6,0,2,2,0,2},
                {4,2,4,3,4,3,4,3,4,2,1,4,4,2,3,2,3,0,3,2,3,4,3,4,6,2,0}
        };
        this.scoreMatrix = newMatrix;
        this.n = 27;
        this.weight = weight;
    }

    // helper method to check the score of the group for student i, j, k.
    public int groupScore(int i, int j, int k) {
        int groupScore = scoreMatrix[i][j] + scoreMatrix[j][k] + scoreMatrix[k][i];
        return groupScore;
    }

    // this is the main algorithm for looking for the group score < weight, weight can be 1-31.
    public void groupList() {
        List<List<Integer>> groupList = new ArrayList<>();
        groupList.add(new ArrayList<>());
        int m=0;

        for(int i=0; i<n-2; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; k<n; k++) {
                    if(groupScore(i,j,k)<weight) {
                        List<Integer> group = new ArrayList<>();
                        group.add(i);
                        group.add(j);
                        group.add(k);
                        boolean checkResult = true;

                        // here is the important part, to skip the student already picked up.
                        for(int check=0; check<=m; check++) {
                            boolean R = Collections.disjoint(group, groupList.get(check));
                            if(R == false) {
                                checkResult = false;
                                break;
                            }else {
                                checkResult = true;
                            }
                        }
                        // as above skip the student already picked up, only add new ones the the list.
                        if(checkResult == true) {
                            groupList.add(group);
                            // System.out.println(group); --debug use.
                            // System.out.println(groupList); --debug use.
                            m++;
                        }
                    }
                }
            }
        }
        this.list = groupList;
    }

    // the toString method.
    public String toString() {
        String out = "";
        for (int i=0; i< list.size()-1; i++) {
            out = out + list.get(i+1) + ",";
        }
        return out;
    }


    // the main for print out groups for weight from 1-31, that's group score 0-30.
    public static void main(String[] args) {
        for(int weight=0; weight<31; weight++) {
            solution s = new solution(weight);
            s.groupList();
            System.out.println(s);
        }
    }

}
