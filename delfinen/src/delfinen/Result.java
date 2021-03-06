package delfinen;

import java.io.Serializable;

/**
 * @author Joachim
 */
public class Result implements Comparable<Result>, Serializable {
    private CompetitiveMember cm;
    private int milli;

    public static final int MIN_TO_MILLI = 60000;
    public static final int SEC_TO_MILLI = 1000;
    private final Discipline disp;

    /**
     * @author Joachim
     */
    public Result(Discipline disp, int min, int sec, int milli, CompetitiveMember cm) {
        this.disp = disp;
        this.milli += min*MIN_TO_MILLI;
        this.milli += sec*SEC_TO_MILLI;
        this.milli += milli;
        this.cm = cm;
    }

    /**
     * @author Joachim
     */
    public Result(Discipline disp, int milli, CompetitiveMember cm){
        this.disp = disp;
        this.milli = milli;
        this.cm = cm;
    }

    public int getMin() {
        return milli/MIN_TO_MILLI;
    }

    public CompetitiveMember getCm() {
        return cm;
    }

    public int getSec() {
        return (milli % MIN_TO_MILLI)/SEC_TO_MILLI;
    }

    public int getMilli() {
        return milli % SEC_TO_MILLI;
    }


    /**
     * @author Joachim
     */
    public String getTime() {
        int min = milli/MIN_TO_MILLI;
        int sec = (milli % MIN_TO_MILLI)/SEC_TO_MILLI;

        String s = " %02d" + ":" + "%02d" + ":" + "%04d";
        return String.format(s, min, sec, milli % SEC_TO_MILLI);
    }

    public Discipline getDisp() {
        return disp;
    }

    /**
     * @author Joachim
     */
    @Override
    public int compareTo(Result o) {
        return Integer.compare(milli, o.milli);
    }

    @Override
    public String toString() {
        return "Discipline: " + getDisp() + " time: " + getTime();
    }
}
