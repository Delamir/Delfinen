import java.text.Format;

public class Result implements Comparable<Result> {
    private CompetitiveMember cm;
    private int min;
    private int sec;
    private int milli;
    private int dist;

    private Discipline disp;

    public Result(Discipline disp, int min, int sec, int milli, int dist, CompetitiveMember cm) {
        this.disp = disp;
        this.min = min;
        this.sec = sec;
        this.milli = milli;
        this.dist = dist;
        this.cm = cm;
    }

    public int getMin() {
        return min;
    }

    public CompetitiveMember getCm() {
        return cm;
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

    public String getTime() {
        String s = " %02d" + ":" + "%02d" + ":" + "%04d";
        return String.format(s, min, sec, milli);
    }

    public Discipline getDisp() {
        return disp;
    }

    @Override
    public int compareTo(Result o) {
        return Integer.compare(min * 60 * 1000+ sec* 1000 + milli,o.min * 60 * 1000+ o.sec* 1000 + o.milli);
    }
}
