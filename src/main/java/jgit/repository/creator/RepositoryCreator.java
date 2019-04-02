package jgit.repository.creator;

import org.eclipse.jgit.api.Git;

import java.io.File;
import java.nio.file.Files;

public class RepositoryCreator {

    private Git git;

    private static RepositoryCreator repositoryCreator = new RepositoryCreator();

    private RepositoryCreator(){}

    public static RepositoryCreator getInstance() {
        return repositoryCreator;
    }

    public RepositoryCreator createRepository(String url){
        try{
            File file = new File("./newRepo");
            deleteCurrentRepository(file);

            this.git = Git.cloneRepository()
                    .setURI(url)
                    .setDirectory(file)
                    .call();

        } catch (Exception e){
            e.printStackTrace();
        }

        return this;

    }

    public Git getGit() {
        return git;
    }

    private void deleteCurrentRepository(File file){
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                if (! Files.isSymbolicLink(f.toPath())) {
                    deleteCurrentRepository(f);
                }
            }
        }
        file.delete();
    }
}
