/*
class Solution {
    public boolean isAnagram(String s, String t) {

        int[] counts = new int[26];
        int ns = s.length();
        for (int i=0; i<ns; i++) {
            char chs = s.charAt(i);
            counts[chs - 'a']++;
        }

        int[] countt = new int[26];
        int nt = t.length();
        for (int j=0; j<nt; j++) {
            char cht = t.charAt(j);
            countt[cht - 'a']++;
        }

        for (int k=0; k<26; k++) {
            if (counts[k] != countt[k]) {
                return false;
            }
        }

        return true;
    }
}

 */


import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {

        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();

        Arrays.sort(chS);
        Arrays.sort(chT);

        return Arrays.equals(chS, chT);

    }
}


/*
class Solution {
    public boolean isAnagram(String s, String t) {
        //边界
        if(s.length()!=t.length()) return false;
        int len=s.length();
        //哈希
        int [] hash=new int[26];
        //一次遍历抵消
        for(int i=0;i<len;i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }
        //判断次数
        for(int tmp:hash){
            if(tmp!=0) return false;
        }
        return true;
    }
}

 */
