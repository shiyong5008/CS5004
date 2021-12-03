/*

import java.util.*;

class Solution {

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();


    public List<List<Integer>> combine(int n, int k) {

        helper(1, n, k);
        return lists;

    }

    public void helper(int start, int n, int k) {

        /*
        //improve to cut, as left element can not make total k.
        if (list.size() + n - start + 1 < k) {
            return;
        }
         *//*

        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }

        // also can improve for i cap = n-(k-list.size())+1
        for (int i = start; i <= n; ++i) {

            list.add(i);
            helper(i+1, n, k);
            list.remove(list.size()-1);
        }

    }
}

*/

import java.util.*;

class Solution {

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        helper(1, n, k);
        return lists;

    }

    public void helper(int start, int n, int k) {

        if (n - start + 1 + list.size() < k) return;
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }

        list.add(start);
        helper(start+1, n, k);
        list.remove(list.size()-1);

        helper(start+1, n, k);

    }

}


