package methods;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static methods.FunctionChecks.*;
import static methods.NameAndSurnameComputations.*;

public class ComputeFiscalCode {

    public static String computeSurname(String input) {
        String error = "0";
        input = replaceSpecialChars(input);
        if (isAllLetters (input)) {
            String result = "";
            input = input.toUpperCase();

            if (input.length() < 3) {
                result = input;
                while (result.length() < 3) {
                    result += "X";
                }
            } else {
                switch (howManyConsonants(input)) {
                    case 0:
                    { // if there are no consonants, it picks the first 3 vowels
                        result = pickFirstThreeVowels ( input, result);
                    }
                    break;
                    case 1:
                    { // 1 consonant case: pick the first consonant and first 2 vowels
                        result = pickFirstConsonantAndFirstTwoVowels ( input, result);
                    }
                    break;
                    case 2:
                    { // 2 consonants case: pick the first 2 consonants and first vowel
                        result = pickFirstTwoConsonantsAndFirstVowel ( input, result);
                    }
                    break;
                    default:
                    { // default case: pick the first 3 consonants
                        result = pickFirstThreeConsonants ( input, result);
                    }
                }
            }
            return result;
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Please insert a valid input in \"Surname\" field.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return error;
        }
    }

    public static String computeName(String inputName) {
        String error = "0";
        inputName = replaceSpecialChars(inputName);
        if (isAllLetters (inputName)) {
            String result = "";
            inputName = inputName.toUpperCase();
            Pattern pattern;
            Matcher matcher;

            // Case name length less than 3
            if (inputName.length() < 3) {
                result = inputName;
                while (result.length() < 3) result += "X";
            } else {
                switch (howManyConsonants(inputName)) {
                    case 0:
                    { // if there are no consonants, it picks the first 3 vowels
                        result = pickFirstThreeVowels ( inputName, result);
                    }
                    break;
                    case 1:
                    { // 1 consonant case: pick the first consonant and first 2 vowels
                        result = pickFirstConsonantAndFirstTwoVowels ( inputName, result);
                    }
                    break;
                    case 2:
                    { // 2 consonants case: pick the first 2 consonants and first vowel
                        result = pickFirstTwoConsonantsAndFirstVowel ( inputName, result);
                    }
                    break;
                    case 3:
                    { // 3 consonant case pick all 3 consonants
                        result = pickFirstThreeConsonants ( inputName, result);
                    }
                    break;
                    default:
                    { // default case: pick 1st, 3rd and 4th consonant;
                        result = pickFirstThirdAndFourthConsonant ( inputName, result );
                    }
                }
            }
            return result;

        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Please insert a valid input in \"Name\" field.",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
            return error;
        }
    }

    public static String computeDateOfBirth(String dayString, String monthString, String yearString, String gender) {
        String yearError = "0", dateError = "0";

        if (isYearValid(yearString)) {
            if (isDateValid(dayString, monthString, yearString)) {
                String result = "";
                try {
                    int day = Integer.parseInt(dayString);
                    int month = Integer.parseInt(monthString);
                    int year = Integer.parseInt(yearString);

                    if (year % 100 >= 10) { // get the last 2 digits of the year
                        result += (year % 100);
                    } else {
                        result = result + 0 + (year % 100);
                    }

                    switch (month) { // get the letter corresponding to the month
                        case 1:
                        {
                            result += "A";
                            break;
                        }
                        case 2:
                        {
                            result += "B";
                            break;
                        }
                        case 3:
                        {
                            result += "C";
                            break;
                        }
                        case 4:
                        {
                            result += "D";
                            break;
                        }
                        case 5:
                        {
                            result += "E";
                            break;
                        }
                        case 6:
                        {
                            result += "H";
                            break;
                        }
                        case 7:
                        {
                            result += "L";
                            break;
                        }
                        case 8:
                        {
                            result += "M";
                            break;
                        }
                        case 9:
                        {
                            result += "P";
                            break;
                        }
                        case 10:
                        {
                            result += "R";
                            break;
                        }
                        case 11:
                        {
                            result += "S";
                            break;
                        }
                        case 12:
                        {
                            result += "T";
                            break;
                        }
                    }
                    switch (gender) { // add 40 in female case, and add 0 in case the date has only one digit
                        // (possible only in male case)
                        case "f":
                        {
                            result += (day + 40);
                            break;
                        }
                        case "m":
                        {
                            result += (day <= 10 ? "0" + day : day);
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Check numeric input.");
                }
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid date", "Error", JOptionPane.WARNING_MESSAGE);
                return dateError;
            }
        } else {
            String message =
                    "Please insert a numeric value between 1900 and "
                            + Calendar.getInstance().get(Calendar.YEAR)
                            + " in \"Year\" field.";
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.WARNING_MESSAGE);
            return yearError;
        }
    }

    public static String computeTownOfBirth(String townString) throws IOException {
        List<Town> townList = new ArrayList<>();
        String townCode = "0";
        townString = townString.toUpperCase();
        try (BufferedReader read =
                     new BufferedReader(
                             new InputStreamReader( ComputeFiscalCode.class.getResourceAsStream("/TownCodeList.txt")))) {
            String line = read.readLine();
            String[] town;
            while (line != null) {
                town = line.split(";");
                townList.add(new Town(town[0], town[1]));
                line = read.readLine();
            }
            int i = 0;
            while (i < townList.size()) {
                if (townString.equals(townList.get(i).getTownName())) {
                    townCode = townList.get(i).getTownCode();
                    break;
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(
                    null, "File was not found", "Error", JOptionPane.WARNING_MESSAGE);
        }

        if (townCode.equals("0")) {
            JOptionPane.showMessageDialog(
                    null, "Town was not found", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return townCode;
    }

    public static String computeControlChar(String incompleteFiscalCode) throws InterruptedException {
        String control = "";
        int evenSum = 0, oddSum = 0;
        incompleteFiscalCode = incompleteFiscalCode.toUpperCase();
        if (incompleteFiscalCode.length() == 15) {
            OddThread ot = new OddThread(incompleteFiscalCode, oddSum);
            Thread t1 = new Thread(ot);
            t1.start();
            t1.join();
            oddSum = ot.getOddSum();

            EvenThread et = new EvenThread(incompleteFiscalCode, evenSum);
            Thread t2 = new Thread(et);
            t2.start();
            t2.join();
            evenSum = et.getEvenSum();

            // The remainder of the division is the control character
            int sum = (oddSum + evenSum) % 26;
            switch (sum) {
                case 0:
                {
                    control = "A";
                    break;
                }
                case 1:
                {
                    control = "B";
                    break;
                }
                case 2:
                {
                    control = "C";
                    break;
                }
                case 3:
                {
                    control = "D";
                    break;
                }
                case 4:
                {
                    control = "E";
                    break;
                }
                case 5:
                {
                    control = "F";
                    break;
                }
                case 6:
                {
                    control = "G";
                    break;
                }
                case 7:
                {
                    control = "H";
                    break;
                }
                case 8:
                {
                    control = "I";
                    break;
                }
                case 9:
                {
                    control = "J";
                    break;
                }
                case 10:
                {
                    control = "K";
                    break;
                }
                case 11:
                {
                    control = "L";
                    break;
                }
                case 12:
                {
                    control = "M";
                    break;
                }
                case 13:
                {
                    control = "N";
                    break;
                }
                case 14:
                {
                    control = "O";
                    break;
                }
                case 15:
                {
                    control = "P";
                    break;
                }
                case 16:
                {
                    control = "Q";
                    break;
                }
                case 17:
                {
                    control = "R";
                    break;
                }
                case 18:
                {
                    control = "S";
                    break;
                }
                case 19:
                {
                    control = "T";
                    break;
                }
                case 20:
                {
                    control = "U";
                    break;
                }
                case 21:
                {
                    control = "V";
                    break;
                }
                case 22:
                {
                    control = "W";
                    break;
                }
                case 23:
                {
                    control = "X";
                    break;
                }
                case 24:
                {
                    control = "Y";
                    break;
                }
                case 25:
                {
                    control = "Z";
                    break;
                }
            }
        }
        return control;
    }
}
