public class PetRock {
    private String name;
    private boolean happy = false;

    public PetRock(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHappy() {
        return happy;
    }

    public void playWithRock() {
        happy = true;
    }

    public String getHappyMessage() {
        // if (!happy) {
        //    throw new IllegalStateException();
        //}
        return "I'm happy!";
    }

    public int getFavNumber() {
        return 42;
    }

    public void  waitTillHappy() {
        while (!happy) {
            // do nothing!
        }
    }

    //3 Add to the Pet Rock an example of a test not covered in the first 2 parts of the lab.
    private String weight = "90kg";
    public String getWeight() {
        return weight;
    }

    //4 Add a toString method to the Pet Rock and JUnit testing for it.
    public String toString() {
        return ("Jerry");

    }

}