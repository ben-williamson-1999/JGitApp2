package matcher.facade;

public class FacadeMatcher {

    public boolean containsFacade(String stringToTest){
        // Clean the String
        String newInput = stringToTest.replaceAll("\n", "");

        // If the commit contains facade, then return true
        return newInput.matches("(?i)(.*)facade(.*)");
    }
}
