import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> mapp = new HashMap<>();

        int j = 0;
        int i;
        for (i = 0; i < pattern.length(); ++i) {
            char p = pattern.charAt(i);
            int k = j;
            if (k >= s.length()) return false;

            while (j < s.length()) {
                if (s.charAt(j) != ' ') {
                    ++j;
                } else {
                    break;
                }
            }
            String temp = s.substring(k, j);

            if (map.containsKey(p) && !map.get(p).equals(temp)) {
                return false;
            }
            if (mapp.containsKey(temp) && !mapp.get(temp).equals(p)) {
                return false;
            }
            map.put(p, temp);
            mapp.put(temp, p);
            ++j;
        }
        if (j < s.length()) {
            return false;
        }
        return true;
    }
}

/*

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        //字符和单词是互相映射，数量必须相等
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            /*
                如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

                以pattern = "abba", str = "dog cat cat dog"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
                结果为 true。

                以pattern = "abba", str = "dog cat cat fish"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
                结果为 false。
            */
/*
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                    return false;
                    }
                    }
                    return true;
                    }
                    }

 */
