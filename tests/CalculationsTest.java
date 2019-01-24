//package tests;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.Calendar;
//
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//import methods.FCCalculations;
//
//public class CalculationsTest extends TestCase{
//
//	protected void setUp() throws Exception {
//		super.setUp();
//	}
//
//	protected void tearDown() throws Exception {
//		super.tearDown();
//	}
//
//	public CalculationsTest(String arg0) {
//		super(arg0);
//	}
//
//	public final void testSurname() {
//		assertEquals (FCCalculations.surnameCalc("Pancaldi"), "PNC");
//		assertEquals (FCCalculations.surnameCalc("abatantuomo"), "BTN");
//		assertEquals (FCCalculations.surnameCalc("a"), "AXX");
//		assertEquals (FCCalculations.surnameCalc("Re"), "REX");
//		assertEquals (FCCalculations.surnameCalc("R0ss1"), "0");
//		assertEquals (FCCalculations.surnameCalc(""), "0");
//	}
//
//	public final void testName() {
//		assertEquals (FCCalculations.nameCalc("Marta"), "MRT");
//		assertEquals (FCCalculations.nameCalc("Li"), "LIX");
//		assertEquals (FCCalculations.nameCalc("M@rio"), "0");
//		assertEquals (FCCalculations.nameCalc(""), "0");
//	}
//
//	public final void testDate() {
//		assertEquals (FCCalculations.dateCalc("12", "7", "1995", "f"), "95L52");
//		assertEquals (FCCalculations.dateCalc("12", "3", "1959", "f"), "59C52");
//		assertEquals (FCCalculations.dateCalc("31", "12", "1940", "m"), "40T31");
//		assertEquals (FCCalculations.dateCalc("12", "11", "1859", "m"), "0");
//		assertEquals (FCCalculations.dateCalc("30", "02", "2014", "m"), "0");
//	}
//
//	public final void testTown() throws IOException {
//		assertEquals (FCCalculations.townCalc("Guastalla"), "E253");
//		assertEquals (FCCalculations.townCalc("Reggio Emilia"), "H223");
//		assertEquals (FCCalculations.townCalc("Milanoo"), "0");
//		assertEquals (FCCalculations.townCalc(""), "0");
//	}
//
//	public final void testControl() throws InterruptedException {
//		assertEquals (FCCalculations.controlCalc("PNCMRT95L52E253"), "R");
//		assertEquals (FCCalculations.controlCalc("MRNLBT59C52H223"), "N");
//		assertEquals (FCCalculations.controlCalc("MRNLBT59C52H22"), "");
//	}
//
//	public final void testAllDigits() {
//		assertTrue (FCCalculations.allDigits("13425804"));
//		assertFalse (FCCalculations.allDigits("157893l"));
//	}
//
//	public final void testAllLetters() {
//		assertTrue (FCCalculations.allLetters("helloworld"));
//		assertFalse (FCCalculations.allLetters("h3llow0r1d"));
//	}
//
//	public final void testHowManyCons() {
//		assertEquals (FCCalculations.howManyConsonants("helloworld"), 7);
//		assertEquals (FCCalculations.howManyConsonants("sUpErCaliFragIlisTIceXpiAlidOCioUs"), 18);
//		assertEquals (FCCalculations.howManyConsonants("he11o"), 0);
//	}
//
//	public final void testHowManyVowels() {
//		assertEquals (FCCalculations.howManyVowels("helloworld"), 3);
//		assertEquals (FCCalculations.howManyVowels("sUpErCaliFragIlisTIceXpiAlidOCioUs"), 16);
//		assertEquals (FCCalculations.howManyVowels("he110"), 0);
//	}
//
//	public final void testYearValid() {
//		assertFalse (FCCalculations.isYearValid("1899"));
//		assertTrue (FCCalculations.isYearValid("1900"));
//		assertTrue (FCCalculations.isYearValid("1947"));
//		assertTrue (FCCalculations.isYearValid(Calendar.getInstance().get(Calendar.YEAR) + "")); //current year is valid
//		assertFalse (FCCalculations.isYearValid((Calendar.getInstance().get(Calendar.YEAR) + 1) + "")); //next year is not valid
//		assertFalse (FCCalculations.isYearValid("19o0"));
//	}
//
//	public final void testDateValid() {
//		assertFalse (FCCalculations.isDateValid("29", "2", "2014"));
//		assertFalse (FCCalculations.isDateValid("31", "4", "2014"));
//		assertFalse (FCCalculations.isDateValid("29", "13", "2014"));
//		assertTrue (FCCalculations.isDateValid("1", "1", "2015"));
//		assertTrue (FCCalculations.isDateValid("13", "3", "2015"));
//
//		Calendar c = Calendar.getInstance();
//		c.setTime(Calendar.getInstance().getTime());
//		c.add(Calendar.DAY_OF_MONTH, 1); //tomorrow date as value is not a valid input
//		String day = c.get(Calendar.DAY_OF_MONTH) + "";
//		String month = (c.get(Calendar.MONTH) + 1) + ""; //Java months counter is 0-11, whereas the method receives 1-12
//		String year = c.get(Calendar.YEAR) + "";
//		assertFalse (FCCalculations.isDateValid(day, month, year)); //Birthday cannot be after current day
//	}
//
//	public final void testReplaceSpecChars() {
//		assertEquals (FCCalculations.replaceSpecialChars("nicolò"), "NICOLO");
//		assertEquals (FCCalculations.replaceSpecialChars("de' medici"), "DEMEDICI");
//		assertEquals (FCCalculations.replaceSpecialChars("françois"), "FRANCOIS");
//		assertEquals (FCCalculations.replaceSpecialChars("müllerstraße"), "MUELLERSTRASSE");
//	}
//
//	public static TestSuite suite() {
//		TestSuite suite = new TestSuite ("Testing FCCalculations.java methods");
//		suite.addTestSuite(CalculationsTest.class);
//		return suite;
//	}
//
//	public static void main (String args[]) throws ParseException {
//		junit.textui.TestRunner.run(CalculationsTest.class);
//	}
//}
