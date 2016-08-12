package methods;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

import javax.swing.JOptionPane;

public class FCCalculations {
	
	public static String surnameCalc (String input) {
		String error = "0";
		input = replaceSpecialChars(input);
		if (allLetters(input)) {
			String result = "";
			int cont = 1;
			input = input.toUpperCase();			
			Pattern p;
			Matcher m;
			if (input.length() < 3)  {
				result = input;
				while (result.length() < 3)
					result += "X";
			}
			else
				switch (howManyConsonants(input)) {
				case 0: {//if there are no consonants, it picks the first 3 vowels
					p = Pattern.compile("[AEIOU]");
					m = p.matcher(input);
					while (cont <=3) {
						result += m.group(cont);
						cont++;
					}
				} break;
				case 1: { //1 consonant case: pick the first consonant and first 2 vowels
					p = Pattern.compile("[B-DF-HJ-NP-TV-Z]");
					m = p.matcher(input);
					while (m.find() && cont <= 1) {
						result += m.group();
						cont++;
					}
					p = Pattern.compile("[AEIOU]");
					m = p.matcher(input);
					cont = 1;
					while (m.find() && cont <= 2) {
						result += m.group();
						cont++;
					}
				}	break;
				case 2:{ //2 consonants case: pick the first 2 consonants and first vowel
					p = Pattern.compile("[B-DF-HJ-NP-TV-Z]");
					m = p.matcher(input);
					while (m.find() && cont <= 2) {
						result += m.group();
						cont++;
					}
					p = Pattern.compile("[AEIOU]");
					m = p.matcher(input);
					cont = 1;
					while (m.find() && cont <= 1) {
						result += m.group();
						cont++;
					}
				}	break;
				default: { //default case: pick the first 3 consonants
					p = Pattern.compile("[B-DF-HJ-NP-TV-Z]");
					m = p.matcher(input);
					while (m.find() && cont <= 3) {
						result += m.group();
						cont++;
					}
				}
			}
			return result;
		}
		else {
			JOptionPane.showMessageDialog(null, "Please insert a valid input in \"Surname\" field.", "Error", JOptionPane.WARNING_MESSAGE);
			return error;
		}
	}
	
	public static String nameCalc(String inputName) {
		String error = "0";
		inputName = replaceSpecialChars(inputName);
		if (allLetters(inputName)) {
			String result = "";
			int cont = 1;
			inputName = inputName.toUpperCase();			
			Pattern pattern;
	        Matcher matcher;
			
			//Case name length less than 3
			if (inputName.length() < 3)  {
				result = inputName;
				while (result.length() < 3)
					result += "X";
			}	
			else 
				switch (howManyConsonants(inputName)) {
				case 0: { //if there are no consonants, it picks the first 3 vowels
					pattern = Pattern.compile("[AEIOU]");
					matcher = pattern.matcher(inputName);
					while (cont <=3) {
						result += matcher.group(cont);
						cont++;
					}
				} break;
				case 1: { //1 consonant case: pick the first consonant and first 2 vowels
					pattern = Pattern.compile("[B-DF-HJ-NP-TV-Z]");
					matcher = pattern.matcher(inputName);
					while (matcher.find() && cont <= 1) {
						result += matcher.group();
						cont++;
					}
					pattern = Pattern.compile("[AEIOU]");
					matcher = pattern.matcher(inputName);
					cont = 1;
					while (matcher.find() && cont <= 2) {
						result += matcher.group();
						cont++;
					}
				} break;					
				case 2:{ //2 consonants case: pick the first 2 consonants and first vowel
					pattern = Pattern.compile("[B-DF-HJ-NP-TV-Z]");
					matcher = pattern.matcher(inputName);
					while (matcher.find() && cont <= 2) {
						result += matcher.group();
						cont++;
					}
					pattern = Pattern.compile("[AEIOU]");
					matcher = pattern.matcher(inputName);
					cont = 1;
					while (matcher.find() && cont <= 1) {
						result += matcher.group();
						cont++;
					}
				} break;
				case 3: { //3 consonant case pick all 3 consonants
					pattern = Pattern.compile("[B-DF-HJ-NP-TV-Z]");
					matcher = pattern.matcher(inputName);
					while (matcher.find() && cont <= 3) {
						result += matcher.group();
						cont++;
					}
				} break;
				default: { //default case: pick 1st, 3rd and 4th consonant;
					pattern = Pattern.compile("[B-DF-HJ-NP-TV-Z]");
					matcher = pattern.matcher(inputName);
					while (matcher.find() && cont <= 4) {
						if (cont != 2) result += matcher.group();
						cont++;
					}
				} 
			}
			return result;
		
		}
		else {
			JOptionPane.showMessageDialog(null, "Please insert a valid input in \"Name\" field.", "Error", JOptionPane.WARNING_MESSAGE);
			return error;}
	}
	
	public static String dateCalc(String dayStr, String monthStr, String yearStr, String fm) {
		String yearError = "0", dateError = "0";
		if (isYearValid(yearStr)) {
			if (isDateValid(dayStr, monthStr, yearStr)) {
				String result = "";
				try {
					int day = Integer.parseInt(dayStr);
					int month = Integer.parseInt(monthStr);
					int year = Integer.parseInt(yearStr);
					if (year % 100 >= 10) //get the last 2 digits of the year
						result += (year % 100);
					else result = result + 0 + (year % 100);
					
					switch (month) { //get the letter corresponding to the month
						case 1: {result += "A"; break;}
						case 2: {result += "B"; break;}
						case 3: {result += "C"; break;}
						case 4: {result += "D"; break;}
						case 5: {result += "E"; break;}
						case 6: {result += "H"; break;}
						case 7: {result += "L"; break;}
						case 8: {result += "M"; break;}
						case 9: {result += "P"; break;}
						case 10: {result += "R"; break;}
						case 11: {result += "S"; break;}
						case 12: {result += "T"; break;}
					}	
					switch (fm) { //add 40 in female case, and add 0 in case the date has only one digit (only in male case)
					case "f": {result += (day + 40); break;}
					case "m": {result += (day <= 10 ? "0" + day : day); break;}
					}
				}
				catch (NumberFormatException e) { System.out.println(e); }
				return result;
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid date", "Error", JOptionPane.WARNING_MESSAGE);
				return dateError;
			}
		}
		else {
			String message = "Please insert a numeric value between 1900 and " + Calendar.getInstance().get(Calendar.YEAR) + " in \"Year\" field.";
			JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
			return yearError;
		}		
	}
	
	public static String townCalc(String townStr) throws IOException {
		List<Town> townList = new ArrayList<Town>();
		String townCode = "0";
		townStr = townStr.toUpperCase();
		//try (BufferedReader read = new BufferedReader(new FileReader("/home/marta/workspace/ItalianFiscalCodeCalculator/FiscalCodeCalculator/TownCodeList.txt"))) {
		try (BufferedReader read = new BufferedReader(new InputStreamReader(FCCalculations.class.getResourceAsStream("/TownCodeList.txt")))) {
			String line = read.readLine();
            String town[];
            while (line != null ) {
            	town = line.split(";");
            	townList.add(new Town(town[0], town[1]));
            	line = read.readLine();
            }
            int i = 0;
            while (i < townList.size()) {
            	if (townStr.equals(townList.get(i).getTownName())) {
            		townCode = townList.get(i).getTownCode();
            		break;
            	}
            	i++;
            }
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File was not found", "Error", JOptionPane.WARNING_MESSAGE);
		} 
		
	if (townCode.equals("0")) 
		JOptionPane.showMessageDialog(null, "Town was not found", "Error", JOptionPane.WARNING_MESSAGE);	
	return townCode;	
	}

	public static String controlCalc(String fisCode) throws InterruptedException {
		String control = "";
		int evenSum = 0, oddSum = 0;
		fisCode = fisCode.toUpperCase();
		if (fisCode.length() == 15) {
			OddThread ot = new OddThread(fisCode, oddSum);
			Thread t1 = new Thread(ot);
			t1.start();
			t1.join();
			oddSum = ot.getOddSum();
			
			EvenThread et = new EvenThread(fisCode, evenSum);
			Thread t2 = new Thread(et);
			t2.start();
			t2.join();
			evenSum = et.getEvenSum();
			
			//The remainder of the division is the control character
			int sum = (oddSum + evenSum) % 26;
			switch (sum) {
					case 0:{control = "A"; break;}
					case 1:{control = "B"; break;}
					case 2:{control = "C"; break;}
					case 3:{control = "D"; break;}
					case 4:{control = "E"; break;}
					case 5:{control = "F"; break;}
					case 6:{control = "G"; break;}
					case 7:{control = "H"; break;}
					case 8:{control = "I"; break;}
					case 9:{control = "J"; break;}
					case 10:{control = "K"; break;}
					case 11:{control = "L"; break;}
					case 12:{control = "M"; break;}
					case 13:{control = "N"; break;}
					case 14:{control = "O"; break;}
					case 15:{control = "P"; break;}
					case 16:{control = "Q"; break;}
					case 17:{control = "R"; break;}
					case 18:{control = "S"; break;}
					case 19:{control = "T"; break;}
					case 20:{control = "U"; break;}
					case 21:{control = "V"; break;}
					case 22:{control = "W"; break;}
					case 23:{control = "X"; break;}
					case 24:{control = "Y"; break;}
					case 25:{control = "Z"; break;}
			}
		}
		return control;		
	}
	
	public static boolean allLetters(String str) {
		if (Pattern.matches("[a-zA-Z]+", str)) return true;
        else return false;
	}
	
	public static boolean allDigits(String str) {
		if (Pattern.matches("[0-9]+", str)) return true;
		else return false;
	}
	
	public static int howManyConsonants(String str) {
		String match = "";
		if (allLetters(str)) {
			str = str.toUpperCase();
			Pattern pattern = Pattern.compile("[B-DF-HJ-NP-TV-Z]+");
	        Matcher matcher = pattern.matcher(str);
			while (matcher.find())
				match += matcher.group();
		}
		return match.length();
	}
	
	public static int howManyVowels(String str) {
		String match = "";
		if (allLetters(str)) {
			str = str.toUpperCase();
			Pattern pattern = Pattern.compile("[AEIOU]+");
	        Matcher matcher = pattern.matcher(str);
			while (matcher.find())
				match += matcher.group();
		}
		return match.length();
	}

	public static boolean isYearValid(String yearStr) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int year;
		if (allDigits(yearStr)) {
			year = Integer.parseInt(yearStr);
			if (year >= 1900 && year <= currentYear)
				return true;
			else return false;
		}
		else return false;
	}
	
	public static boolean isDateValid(String day, String month, String year) {
	//Check whether a date is valid or not (e.g. 29/02/2001)	
		if (isYearValid(year)) {
			String dateToCheck = day + "-" + month + "-" + year;
			Calendar.getInstance();		
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
			sdf.setLenient(false);
			try {
				sdf.parse(dateToCheck); 
				Date date = sdf.parse(dateToCheck);
				Date current = Calendar.getInstance().getTime();
				if (date.after(current)) //You cannot calculate a fiscal code if the birthday is after the current day
					return false;			
			}
			catch (ParseException e) {return false;}
			
			return true;
	    }
		else return false;
	}
	
	public static String replaceSpecialChars(String input) {
	//If the name or surname include stressed letters (à,è,ì...) or other special characters (ä,ç,ß,...), it replaces them with corresponding letter (e.g. à = a)
		input = input.toUpperCase();
		input = input.replaceAll("[ÀÁÂÃÅĀ]", "A");
		input = input.replaceAll("[ÄÆ]", "AE");
		input = input.replaceAll("[ÈÉÊËĘĖĒ]", "E");
		input = input.replaceAll("[ÌÍÎÏĮĪ]", "I");
		input = input.replaceAll("[ÒÓÔÕOŌ]", "O");
		input = input.replaceAll("[ÖŒØ]", "OE");
		input = input.replaceAll("[ÙÚÛŪ]", "U");
		input = input.replaceAll("[Ü]", "UE");
		input = input.replaceAll("[ŚŠ]", "S");
		input = input.replaceAll("ß", "SS");
		input = input.replaceAll("[ÇĆČ]", "C");
		input = input.replaceAll(" ", "");
		input = input.replaceAll("-", "");
		input = input.replaceAll("'", "");
		return input;
	}
}
