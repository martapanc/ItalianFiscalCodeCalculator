package methods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NameAndSurnameComputationsTest {

    @Test
    void pickFirstThreeConsonants() {
        assertEquals("MRT", NameAndSurnameComputations.pickFirstThreeConsonants("MARTA"));
        assertEquals("PNC", NameAndSurnameComputations.pickFirstThreeConsonants("PANCALDI"));
    }

    @Test
    void pickFirstTwoConsonantsAndFirstVowel() {
        assertEquals("RTI", NameAndSurnameComputations.pickFirstTwoConsonantsAndFirstVowel("RITA"));
        assertEquals("MRA", NameAndSurnameComputations.pickFirstTwoConsonantsAndFirstVowel("MARIA"));
    }

    @Test
    void pickFirstConsonantAndFirstTwoVowels() {
        assertEquals("LOI", NameAndSurnameComputations.pickFirstConsonantAndFirstTwoVowels("OLI"));
        assertEquals("PAA", NameAndSurnameComputations.pickFirstConsonantAndFirstTwoVowels("PANCALDI"));
    }

    @Test
    void pickFirstThreeVowels() {
        assertEquals ( "AOI", NameAndSurnameComputations.pickFirstThreeVowels ( "PAOLINI" ) );
        assertEquals ( "AAI", NameAndSurnameComputations.pickFirstThreeVowels ( "PANCALDI" ) );
    }

    @Test
    void pickFirstThirdAndFourthConsonant() {
        assertEquals("LBT", NameAndSurnameComputations.pickFirstThirdAndFourthConsonant("ELISABETTA"));
        assertEquals("MRT", NameAndSurnameComputations.pickFirstThirdAndFourthConsonant("UMBERTO"));
    }
}