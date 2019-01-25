package methods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameAndSurnameComputations {

    static final String CONSONANT_PATTERN = "[B-DF-HJ-NP-TV-Z]";
    public static final String VOWEL_PATTERN = "[AEIOU]";

    static String pickFirstThreeConsonants(String input) {
        Pattern p = Pattern.compile ( CONSONANT_PATTERN );
        Matcher m = p.matcher ( input );
        String result = "";
        int cont = 1;
        while (m.find() && cont <= 3) {
            result += m.group();
            cont++;
        }
        return result;
    }

    static String pickFirstTwoConsonantsAndFirstVowel(String input) {
        Pattern p = Pattern.compile ( CONSONANT_PATTERN );
        Matcher m = p.matcher ( input );
        String result = "";
        int cont = 1;
        while (m.find() && cont <= 2) {
            result += m.group();
            cont++;
        }
        p = Pattern.compile( VOWEL_PATTERN );
        m = p.matcher(input);
        cont = 1;
        while (m.find() && cont <= 1) {
            result += m.group();
            cont++;
        }
        return result;
    }

    static String pickFirstConsonantAndFirstTwoVowels(String input) {
        Pattern p = Pattern.compile ( CONSONANT_PATTERN );
        Matcher m = p.matcher ( input );
        String result = "";
        int cont = 1;
        while (m.find() && cont <= 1) {
            result += m.group();
            cont++;
        }
        p = Pattern.compile( VOWEL_PATTERN );
        m = p.matcher(input);
        cont = 1;
        while (m.find() && cont <= 2) {
            result += m.group();
            cont++;
        }
        return result;
    }

    static String pickFirstThreeVowels(String input) {
        Pattern p = Pattern.compile ( VOWEL_PATTERN );
        Matcher m = p.matcher ( input );
        String result = "";
        int cont = 1;
        while (cont <= 3) {
            result += m.group(cont);
            cont++;
        }
        return result;
    }

    static String pickFirstThirdAndFourthConsonant(String inputName) {
        Pattern p = Pattern.compile ( CONSONANT_PATTERN );
        Matcher m = p.matcher ( inputName );
        String result = "";
        int cont = 1;
        while (m.find() && cont <= 4) {
            if (cont != 2) {
                result += m.group();
            }
            cont++;
        }
        return result;
    }
}
