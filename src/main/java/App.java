import jgit.commits.LoadDiffs;
import jgit.repository.creator.RepositoryCreator;
import matcher.facade.FacadeMatcher;
import matcher.tests.TestingMatcher;

public class App {

    public static void main(String[] args){

        try{
            String uri = "https://github.com/ben-williamson-1999/JGitApp2.git";

            RepositoryCreator repositoryCreator = RepositoryCreator.getInstance().createRepository(uri);
            LoadDiffs loadDiffs = new LoadDiffs(repositoryCreator.getGit());

            String differences = loadDiffs.getDifferences();

            System.out.println("facade: " + new FacadeMatcher().containsFacade(differences));
            System.out.println("tests: " + new TestingMatcher().hasJunitFourTest(differences));

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
