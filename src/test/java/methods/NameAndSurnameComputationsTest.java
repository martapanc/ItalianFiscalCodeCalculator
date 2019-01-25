package methods;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameAndSurnameComputationsTest {

  @Test
  void pickFirstThreeConsonants() {
    assertEquals("MRT", NameAndSurnameComputations.pickFirstThreeConsonants ( "MARTA" ));
    assertEquals("PNC", NameAndSurnameComputations.pickFirstThreeConsonants ( "PANCALDI" ));
  }

  @Test
  void pickFirstTwoConsonantsAndFirstVowel() {
    assertEquals ( "RTI", NameAndSurnameComputations.pickFirstTwoConsonantsAndFirstVowel ( "RITA" ) );
    assertEquals ( "MRA", NameAndSurnameComputations.pickFirstTwoConsonantsAndFirstVowel ( "MARIA" ) );
  }

  @Test
  void pickFirstConsonantAndFirstTwoVowels() {
    assertEquals ( "LOI", NameAndSurnameComputations.pickFirstConsonantAndFirstTwoVowels ( "OLI" ) );
  }

  @Test
  void pickFirstThreeVowels() {
    //assertEquals ( "OEI", NameAndSurnameComputations.pickFirstThreeVowels ( "OEIL" ) );
  }

  @Test
  void pickFirstThirdAndFourthConsonant() {
    assertEquals ( "LBT", NameAndSurnameComputations.pickFirstThirdAndFourthConsonant ( "ELISABETTA" ) );
    assertEquals ( "MRT", NameAndSurnameComputations.pickFirstThirdAndFourthConsonant ( "UMBERTO" ) );
  }
}