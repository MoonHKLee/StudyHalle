package issue4.chapter1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static final int NUM_OF_ISSUES = 18;
    static final String oauthToken = "myToken";
    static final String repoURL = "whiteship/live-study";

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Repository repository = new Repository(oauthToken, repoURL);

        List<String> allParticipants = getAllParticipants(repository);

        List<UserBoard> dashBoard = makeEmptyDashBoard(allParticipants);

        repository.checkUserParticipation(dashBoard);

        createBoard(bw, dashBoard);
        bw.flush();
        bw.close();
    }

    private static List<String> getAllParticipants(Repository repository) throws IOException {
        return repository.getAllParticipantsName()
            .stream()
            .sorted()
            .collect(Collectors.toList());
    }


    private static List<UserBoard> makeEmptyDashBoard(List<String> allParticipants) {
        return allParticipants.stream()
            .map(v -> new UserBoard(v, new boolean[NUM_OF_ISSUES]))
            .collect(Collectors.toList());
    }

    private static void createBoard(BufferedWriter bw, List<UserBoard> dashBoard)
        throws IOException {
        bw.write("| 참여자 |");
        for (int i = 1; i <= NUM_OF_ISSUES; i++) {
            bw.write(" " + i + "주차 |");
        }
        bw.write(" 참석율 |\n");

        bw.write("| --- |");
        for (int i = 1; i <= NUM_OF_ISSUES; i++) {
            bw.write(" --- |");
        }
        bw.write(" --- |\n");

        for (UserBoard userBoard : dashBoard) {
            bw.write("| " + userBoard.name + " |");
            boolean[] check = userBoard.participationCheck;
            for (boolean b : check) {
                if (b) {
                    bw.write(":white_check_mark:|");
                } else {
                    bw.write("|");
                }
            }
            bw.write(" " + userBoard.getRate() + " |\n");
        }
    }
}
