package jgit.commits;

import jgit.outputstream.JGitOutputStream;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import java.io.OutputStream;
import java.util.List;

public class LoadDiffs {

    private Git git;

    public LoadDiffs(Git git){
        this.git = git;
    }

    public String getDifferences(){
        String strings = "";
        OutputStream output = new JGitOutputStream();

        try{
            RevCommit headCommit = getHeadCommit(git.getRepository());
            RevCommit diffWith = headCommit.getParent(0);
            try (DiffFormatter diffFormatter = new DiffFormatter(output)) {
                diffFormatter.setRepository(git.getRepository());
                List<DiffEntry> list = diffFormatter.scan(diffWith, headCommit);
                for (DiffEntry entry : list) {
                    diffFormatter.format(diffFormatter.toFileHeader(entry));
                }
                strings = output.toString();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return strings;
    }

    private static RevCommit getHeadCommit(Repository repository) throws Exception {
        try (Git git = new Git(repository)) {
            Iterable<RevCommit> history = git.log().setMaxCount(1).call();
            return history.iterator().next();
        }
    }

}
