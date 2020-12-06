package issue4.chapter1;

public class UserBoard {

    String name;
    boolean[] participationCheck;

    public UserBoard(String name, boolean[] participationCheck) {
        this.name = name;
        this.participationCheck = participationCheck;
    }

    public String getRate() {
        return
            String.format("%.2f", (float) getTotalParticipation() / participationCheck.length * 100)
                + "%";
    }

    private int getTotalParticipation() {
        int count = 0;
        for (boolean b : participationCheck) {
            if (b) {
                count++;
            }
        }
        return count;
    }
}
