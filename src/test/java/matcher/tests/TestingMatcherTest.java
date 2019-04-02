package matcher.tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestingMatcherTest {

    private TestingMatcher underTest = new TestingMatcher();

    @Test
    public void shouldMatchJunitFourTest(){

        // Given
        String exampleText = "@RunWith(SpringJUnit4ClassRunner.class)\n" +
                "@ContextConfiguration(\n" +
                "  {\"/app-config.xml\", \"/test-data-access-config.xml\"})\n" +
                "public class SpringExtensionTest {\n" +
                "    /*...*/\n" +
                "}";

        // When
        boolean output = underTest.hasJunitFourTest(exampleText);

        // Then
        assertTrue(output);

    }

    @Test
    public void shouldMatchJunitFourExpectedException(){

        // Given
        String exampleText = "@Test(expected = Exception.class)\n" +
                "public void shouldRaiseAnException() throws Exception {\n" +
                "    // ...\n" +
                "}";

        // When
        boolean output = underTest.hasJunitFourTest(exampleText);

        // Then
        assertTrue(output);

    }

    @Test
    public void shouldMatchIfTestContainsLegacyAnnotationsBeforeClassAnnotation(){

        // Given
        String exampleText = "@BeforeClass\n";

        // When
        boolean output = underTest.hasJunitFourTest(exampleText);

        // Given
        assertTrue(output);

    }

    @Test
    public void shouldMatchIfTestContainsLegacyAnnotationsAfterClassAnnotation(){

        // Given
        String exampleText = "@AfterClass\n";

        // When
        boolean output = underTest.hasJunitFourTest(exampleText);

        // Then
        assertTrue(output);

    }

    @Test
    public void shouldMatchIfTestContainsLegacyAnnotationsBeforeAnnotation(){

        // Given
        String exampleText = "@Before\n";

        // When
        boolean output = underTest.hasJunitFourTest(exampleText);

        // Then
        assertTrue(output);

    }

    @Test
    public void shouldMatchIfTestContainsLegacyAnnotationsAfterAnnotation(){

        // Given
        String exampleText = "@After\n";

        // When
        boolean output = underTest.hasJunitFourTest(exampleText);

        // Then
        assertTrue(output);

    }

    @Test
    public void shouldMatchIfTestContainsLegacyAnnotationsIgnoreAnnotation(){

        // Given
        String exampleText = "@Ignore\n";

        // When
        boolean output = underTest.hasJunitFourTest(exampleText);

        // Then
        assertTrue(output);

    }

    @Test
    public void shouldMatchIfTestContainsLegacyAnnotationsCategoryAnnotation(){

        // Given
        String exampleText = "@Category\n";

        // When
        boolean output = underTest.hasJunitFourTest(exampleText);

        // Then
        assertTrue(output);

    }

}
