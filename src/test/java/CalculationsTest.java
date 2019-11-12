import methods.ComputeFiscalCode;
import methods.FunctionChecks;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationsTest {

    @Test
    public final void testSurname() {
        assertEquals(ComputeFiscalCode.computeSurname("Pancaldi"), "PNC");
        assertEquals(ComputeFiscalCode.computeSurname("abatantuomo"), "BTN");
        assertEquals(ComputeFiscalCode.computeSurname("a"), "AXX");
        assertEquals(ComputeFiscalCode.computeSurname("Re"), "REX");
        assertEquals(ComputeFiscalCode.computeSurname("R0ss1"), "0");
        assertEquals(ComputeFiscalCode.computeSurname(""), "0");
    }

    @Test
    public final void testName() {
        assertEquals(ComputeFiscalCode.computeName("Marta"), "MRT");
        assertEquals(ComputeFiscalCode.computeName("Li"), "LIX");
        assertEquals(ComputeFiscalCode.computeName("M@rio"), "0");
        assertEquals(ComputeFiscalCode.computeName(""), "0");
    }

    @Test
    public final void testDate() {
        assertEquals(ComputeFiscalCode.computeDateOfBirth("12", "7", "1995", "f"), "95L52");
        assertEquals(ComputeFiscalCode.computeDateOfBirth("12", "3", "1959", "f"), "59C52");
        assertEquals(ComputeFiscalCode.computeDateOfBirth("31", "12", "1940", "m"), "40T31");
        assertEquals(ComputeFiscalCode.computeDateOfBirth("12", "11", "1859", "m"), "0");
        assertEquals(ComputeFiscalCode.computeDateOfBirth("30", "02", "2014", "m"), "0");
    }

    @Test
    public final void testTown() throws IOException {
        assertEquals(ComputeFiscalCode.computeTownOfBirth("Guastalla"), "E253");
        assertEquals(ComputeFiscalCode.computeTownOfBirth("Reggio Emilia"), "H223");
        assertEquals(ComputeFiscalCode.computeTownOfBirth("Milanoo"), "0");
        assertEquals(ComputeFiscalCode.computeTownOfBirth(""), "0");
    }

    @Test
    public final void testControl() throws InterruptedException {
        assertEquals(ComputeFiscalCode.computeControlChar("PNCMRT95L52E253"), "R");
        assertEquals(ComputeFiscalCode.computeControlChar("MRNLBT59C52H223"), "N");
        assertEquals(ComputeFiscalCode.computeControlChar("MRNLBT59C52H22"), "");
    }

    @Test
    public final void testAllDigits() {
        assertTrue(FunctionChecks.isAllDigits("13425804"));
        assertFalse(FunctionChecks.isAllDigits("157893l"));
    }

    @Test
    public final void testAllLetters() {
        assertTrue(FunctionChecks.isAllLetters("helloworld"));
        assertFalse(FunctionChecks.isAllLetters("h3llow0r1d"));
    }

    @Test
    public final void testHowManyCons() {
        assertEquals(FunctionChecks.howManyConsonants("helloworld"), 7);
        assertEquals(FunctionChecks.howManyConsonants("sUpErCaliFragIlisTIceXpiAlidOCioUs"), 18);
        assertEquals(FunctionChecks.howManyConsonants("he11o"), 0);
    }

    @Test
    public final void testHowManyVowels() {
        assertEquals(FunctionChecks.howManyVowels("helloworld"), 3);
        assertEquals(FunctionChecks.howManyVowels("sUpErCaliFragIlisTIceXpiAlidOCioUs"), 16);
        assertEquals(FunctionChecks.howManyVowels("he110"), 0);
    }

    @Test
    public final void testYearValid() {
        assertFalse(FunctionChecks.isYearValid("1899"));
        assertTrue(FunctionChecks.isYearValid("1900"));
        assertTrue(FunctionChecks.isYearValid("1947"));
        assertTrue(FunctionChecks.isYearValid(Calendar.getInstance().get(Calendar.YEAR) + "")); //current year is valid
        assertFalse(FunctionChecks.isYearValid((Calendar.getInstance().get(Calendar.YEAR) + 1) + "")); //next year is not valid
        assertFalse(FunctionChecks.isYearValid("19o0"));
    }

    @Test
    public final void testDateValid() {
        assertFalse(FunctionChecks.isDateValid("29", "2", "2014"));
        assertFalse(FunctionChecks.isDateValid("31", "4", "2014"));
        assertFalse(FunctionChecks.isDateValid("29", "13", "2014"));
        assertTrue(FunctionChecks.isDateValid("1", "1", "2015"));
        assertTrue(FunctionChecks.isDateValid("13", "3", "2015"));

        Calendar c = Calendar.getInstance();
        c.setTime(Calendar.getInstance().getTime());
        c.add(Calendar.DAY_OF_MONTH, 1); //tomorrow date as value is not a valid input
        String day = c.get(Calendar.DAY_OF_MONTH) + "";
        String month = (c.get(Calendar.MONTH) + 1) + ""; //Java months counter is 0-11, whereas the method receives 1-12
        String year = c.get(Calendar.YEAR) + "";
        assertFalse(FunctionChecks.isDateValid(day, month, year)); //Birthday cannot be after current day
    }

    @Test
    public final void testReplaceSpecChars() {
        assertEquals(FunctionChecks.replaceSpecialChars("nicolò"), "NICOLO");
        assertEquals(FunctionChecks.replaceSpecialChars("de' medici"), "DEMEDICI");
        assertEquals(FunctionChecks.replaceSpecialChars("françois"), "FRANCOIS");
        assertEquals(FunctionChecks.replaceSpecialChars("müllerstraße"), "MUELLERSTRASSE");
    }
}

//TODO - Name or surname composed of vowels only