package matcher.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TestingMatcher {

    public boolean hasJunitFourTest(String exampleText) {

        // Establish the list of regex's to compare against
        List<Pattern> listOfRegex = loadRegex();

        // Clean the String so that regex's can be performed on it
        String newString = cleanString(exampleText);

        // Create the return which will be true if one of the regex's matches
        boolean result = compareToRegex(listOfRegex, newString);

        return result;
    }

    private List<Pattern> loadRegex(){
        List<Pattern> listOfRegex = new ArrayList<>();

        listOfRegex.add(Pattern.compile("(?i)(.*)junit4(.*)"));
        listOfRegex.add(Pattern.compile("(?i)(.*)@Test\\(expected = Exception.class\\)(.*)"));
        listOfRegex.add(Pattern.compile("(?i)(.*)@BeforeClass(.*)"));
        listOfRegex.add(Pattern.compile("(?i)(.*)@AfterClass(.*)"));
        listOfRegex.add(Pattern.compile("(?i)(.*)@Before(.*)"));
        listOfRegex.add(Pattern.compile("(?i)(.*)@After(.*)"));
        listOfRegex.add(Pattern.compile("(?i)(.*)@Ignore(.*)"));
        listOfRegex.add(Pattern.compile("(?i)(.*)@Category(.*)"));

        return listOfRegex;
    }

    private boolean compareToRegex(List<Pattern> patternList, String input){
        for(Pattern rx: patternList){
            if(rx.matcher(input).matches()){
                return true;
            }
        }

        return false;
    }

    private String cleanString(String input){
        return input.replaceAll("\n", "");
    }
}