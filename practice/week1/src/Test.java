public class Test {
  public static void main(String[] args) {
    int a = 1;
    // float b = 1.1f;
    double c = 1.1;
    int d = -1;
    boolean bo = true;
    boolean bo1 = false;
    System.out.println("Hello World!");
    System.out.println(c);
    System.out.println(bo);

    //////// declare/define new variable

    double cc = 1.2;
    double cd;
    // int cc = 1;

    cc = 1.3;
    cc = 1.0;

    /////////////////////////////


    String str = "Hello World2!";
    System.out.println(str);

    char ch = 'H';
    System.out.println(ch);

    // ch = c;
    int[] intArray = {2, 5, 3, 9, 10};
    String[] strA = {"Hello", "World", "!"};

    //for (int arrayIndex = 0; arrayIndex < strA.length; arrayIndex = arrayIndex + 1) {
    //  System.out.println(strA[arrayIndex]);
    //}

    //for (;;) {
    //  System.out.println("111");
    //}

    int myArrayIndex = 0;
    while(myArrayIndex < strA.length) { // condition
      System.out.println(strA[myArrayIndex]);
      myArrayIndex++;
    }


    // python code
    if (ch == 'L') {
      a = 1;
    }
    c = 1.2;


    if ( 1 == 2 ) {
      // ...
    } else if (ch == 'L') {
      // ...
    } else {
      // ...
    }

    // while(...)
    // switch(...)

    //....


    String s = "ajcodekcnodlsmcdcdkowecmsldmcdmc";

    /*
    // define a freqMap of length 26. Each element is a counter for each letter.
    int[] freqMap = new int[26];
    // Init each counter to 0.
    for (int i = 0; i < freqMap.length; i++) {
      freqMap[i] = 0;
    }

    for (int i = 0; i < s.length(); i++) {
      // extracting character at index i from string s
      char myC = s.charAt(i); // s[i]

      // increment the corresponding counter of 'myC'
      // myC 'd' -> 100
      // myC - 'a' -> 'd' - 'a' -> 100 - 97 = 3
      int index = myC - 'a';
      freqMap[index]++;
    }

    for (int i = 0; i < freqMap.length; i++) {
      // format: 'a' -- 3
      System.out.println(freqMap[i]);
    }

     */

    int myIntArray[] = {1, 4, 6, 8, 9, 10, 18, 20};

    int target = 12;
    int l = 0, r = myIntArray.length - 1;
    boolean found = false;

    while(l <= r) {
      //System.out.println(l + " " + r);
      // check the element in the middle
      int m_index = (l + r) / 2; // putting 2 here yields a integer result
      int m_value = myIntArray[m_index];

      if (m_value == target) {
        // found it! Set the flag to true
        found = true;
        break;
      } else if (m_value < target) {
        // middle value is less than target,
        // that means target must be on the right-hand side of the middle value
        // cut off the entire left-hand side search space by moving the left
        // boundary to the right of the middle value
        l = m_index + 1;
      } else {
        // m_value > target
        // similar to above, move the right boundary to the left of the middle value
        r = m_index - 1;
      }
    }

    if (found == true) {
      System.out.println("Found it!");
    } else {
      System.out.println("Target not found");
    }

    // (l + r ) / 2
  }

















}
