/**
 * enum with different disciplines, with a little spice added from a certain member of the group
 * Authors Sverri og Joachim
 */

public enum Discipline {
    FREESTYLE("Freestyle"),
    BUTTERFLY("Butterfly"),
    BACKSTROKE("Backstroke"),
    BREASTSTROKE("Breaststroke"),
    DROWNING("Drowning"),
    SPLASHING("Splashing");

    private String desc;

    Discipline(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
