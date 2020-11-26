public class Result {
    private int min;
    private int sec;
    private int milli;
    private int dist;

    Discipline disp;

    public Result(Discipline disp, int min, int sec, int milli, int dist) {
        this.disp = disp;
        this.min = min;
        this.sec = sec;
        this.milli = milli;
        this.dist = dist;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public int getMilli() {
        return milli;
    }

    public int getDist() {
        return dist;
    }

    public Discipline getDisp() {
        return disp;
    }
}
