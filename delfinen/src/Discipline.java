import java.util.ArrayList;
import java.util.Arrays;

/**
 * enum with different disciplines, with a little spice added from a certain member of the group
 *
 * @author Sverri og Joachim
 */

public enum Discipline {
    FREESTYLE("Freestyle"),
    BUTTERFLY("Butterfly"),
    BACKSTROKE("Backstroke"),
    BREASTSTROKE("Breaststroke"),
    DROWNING("Drowning"),
    SPLASHING("Splashing");

    private final String desc;

    Discipline(String desc) {
        this.desc = desc;
    }

    public static ArrayList<Discipline> asList() {
        ArrayList<Discipline> list = new ArrayList<>();
        list.addAll(Arrays.asList(Discipline.values()));
        return list;
    }

    @Override
    public String toString() {
        return desc;
    }
}
