package hu.bme.soft.arch.colleaguestore.client.place;

public class NameTokens {
    public static final String HOME = "/home";

    public static final String PERSON = "/person";

    public static final String TEAM = "/team";

    private NameTokens() {
    }

    public static String getHome() {
        return HOME;
    }

    public static String getPerson() {
        return PERSON;
    }

    public static String getTeam() {
        return TEAM;
    }
}