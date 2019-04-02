package matcher.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacadeMatcherTest {

    private FacadeMatcher underTest = new FacadeMatcher();

    @Test
    public void shouldMatchFacadeInString(){

        // Given
        String exampleText = "This is a string and the word facade is in it";

        // When
        boolean output = underTest.containsFacade(exampleText);

        // Then
        assertTrue(output);

    }

    @Test
    public void shouldNotMatchFacadeInString(){

        // Given
        String exampleText = "This wont match the test";

        // When
        boolean output = underTest.containsFacade(exampleText);

        // Then
        assertFalse(output);

    }

    @Test
    public void shouldMatchFacadeWhenInCode(){

        // Given
        String exampleText = "String string = facade.call()";

        // When
        boolean output = underTest.containsFacade(exampleText);

        // Then
        assertTrue(output);

    }

    @Test
    public void shouldMatchWhenFacadeIsCaps(){

        // Given
        String exampleString = "public class AddressServiceEJB implements AddressServiceLocal, AddressFacade {";

        // When
        boolean output = underTest.containsFacade(exampleString);

        // Then
        assertTrue(output);
    }

    @Test
    public void shouldMatchWhenNewLineInString(){

        // Given
        String exampleText = "this is the newline\n and also the word facade";

        // When
        boolean output = underTest.containsFacade(exampleText);

        // Then
        assertTrue(output);

    }
}
