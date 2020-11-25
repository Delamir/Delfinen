public class Result {
    int min, sec, milli, dist;
    Discipline disp;


    public Result(Discipline disp, int min, int sec, int milli, int dist) {
        this.disp = disp;
        this.min = min;
        this.sec = sec;
        this.milli = milli;
        this.dist = dist;
    }
}
