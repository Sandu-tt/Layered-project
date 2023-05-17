package lk.ijse.daycare.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern emailPattern = Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)");
    private static final Pattern numberPattern = Pattern.compile("[0-9]+");
    private static final Pattern stringPattern = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
    private static final Pattern phoneNumberPattern = Pattern.compile("^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$");

    public static boolean isEmailMatch(String text) {
        Matcher emailMatcher = emailPattern.matcher(text);
        return emailMatcher.matches();
    }

    public static boolean isNumberMatch(String text) {
        Matcher emailMatcher = phoneNumberPattern.matcher(text);
        return emailMatcher.matches();
    }

    public static boolean isSalaryMatch(String text) {
        Matcher salaryMatcher = numberPattern.matcher(text);
        return salaryMatcher.matches();
    }

    public static boolean isNameMatch(String text) {
        Matcher nameMatcher = stringPattern.matcher(text);
        return nameMatcher.matches();
    }

    public static boolean isAgeMatch(String text) {
        Matcher ageMatcher = numberPattern.matcher(text);
        return ageMatcher.matches();

    }
}
