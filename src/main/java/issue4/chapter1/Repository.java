package issue4.chapter1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

public class Repository {

    final int NUM_OF_ISSUES = 18;
    GitHub gitHub;
    GHRepository repository;

    public Repository(String token, String repoURL) throws IOException {
        gitHub = generateGitHubConnection(token);
        repository = gitHub.getRepository(repoURL);
    }

    private GitHub generateGitHubConnection(String oAuthAccessToken) throws IOException {
        return new GitHubBuilder()
            .withOAuthToken(oAuthAccessToken)
            .build();
    }

    public List<String> getAllParticipantsName() throws IOException {
        List<String> participants = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_ISSUES; i++) {
            List<GHIssueComment> comments = repository.getIssue(i).getComments();
            for (GHIssueComment comment : comments) {
                String name = comment.getUser().getLogin();
                if (!participants.contains(name)) {
                    participants.add(name);
                }
            }
        }
        return participants;
    }

    public void checkUserParticipation(List<UserBoard> dashBoard) throws IOException {
        for (int i = 1; i <= NUM_OF_ISSUES; i++) {
            List<GHIssueComment> comments = repository.getIssue(i).getComments();
            if (comments.size() == 0) {
                return;
            }
            for (GHIssueComment comment : comments) {
                String name = comment.getUser().getLogin();
                for (UserBoard userBoard : dashBoard) {
                    if (userBoard.name.equals(name)) {
                        userBoard.participationCheck[i - 1] = true;
                    }
                }
            }
        }
    }
}
