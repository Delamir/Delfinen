package delfinen;

import java.util.ArrayList;


public class CompetitiveMember extends Member {
    private ArrayList<Discipline> disciplines;

    private ArrayList<Result> results = new ArrayList<>();

    /**
     * Method that determines the price for a member based on age.
     *
     * @param age         determines if the member is senior, junior or hella old
     * @param name        checks the name of the competitive member
     * @param disciplines checks the disciplines that the competitive member is a part of
     * @author Sverri & Joachim
     */

    public CompetitiveMember(int age, String name, ArrayList<Discipline> disciplines) {
        super(age, name);
        if (age > 60) {
            setMembershipFee(SENIOR_PRICE * SENIOR_DISCOUNT);
        } else if (age > 18) {
            setMembershipFee(SENIOR_PRICE);
        } else {
            setMembershipFee(JUNIOR_PRICE);
        }
        this.disciplines = disciplines;
    }

    public void ResultsFromDisciplines() {

    }

    /**
     * Method that the user can enter a time in.
     *
     * @param disp  confirms the discipline
     * @param min   the minutes it took the swim the lap
     * @param sec   the seconds
     * @param milli the milliseconds
     * @author Sverri og Joachim
     */
    public void addResults(Discipline disp, int min, int sec, int milli) {
        Result newResult = new Result(disp, min, sec, milli, this);
        if (disciplines.contains(disp)) {
            for (Result r : results) {
                if (r.getDisp().equals(disp)) {
                    if (newResult.compareTo(r) < 0) {
                        System.out.println("\nWOW!!!!!!!!!! You beat your best result");
                        results.remove(r);
                        results.add(newResult);
                    }else if (newResult.compareTo(r) == 0){
                        System.out.println("\nSame time as your record, that is amazing the exact same millisecond");
                    }else{
                        System.out.println("\nPrevious result was better!");
                    }
                    return;
                }
            }
            results.add(newResult);
        } else
            System.out.println("this swimmer is not registered for " + disp);
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

}