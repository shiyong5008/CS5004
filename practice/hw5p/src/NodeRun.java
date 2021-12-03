public class NodeRun {
    /**
     *
     */
    public Run run;
    public NodeRun next;
    int[] val;

    public void setIdNode() {
        int id = run.getId();
        this.val[0] = id;
    }

    public void setScoreNode() {
        int score = run.getScore();
        this.val[1]= score;
    }

    public NodeRun(Run run, NodeRun next) {
        this.run = run;
        this.next = next;
    }

    public String toString() {
        return "("+val[0]+", "+val[1]+")";
    }
}
