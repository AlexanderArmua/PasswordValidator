import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    // TODO: CHANGE BLACK LIST PASSWORD IMPLEMENTATION
    private static List<String> blackListPasswords = new ArrayList<>();

    public PasswordValidator() {
        blackListPasswords.add("/Qwerty123");
    }

    public Integer GetSecurityPercentage(String password) {
        Integer securityLvl = 0;

        securityLvl += getBoolAsNum(hasNumbers(password));
        securityLvl += getBoolAsNum(hasCharacters(password));
        securityLvl += getBoolAsNum(hasLowercase(password));
        securityLvl += getBoolAsNum(hasUpperCase(password));
        securityLvl += getBoolAsNum(hasSymbols(password));
        securityLvl += getBoolAsNum(hasGoodMinLength(password));
        securityLvl += getBoolAsNum(hasGoodMaxLength(password));
        securityLvl += getBoolAsNum(isNotOnOfBlackList(password));

        return securityLvl;
    }

    public boolean hasNumbers(final String password) {
        return password.matches(".+[0-9].*");
    }

    public boolean hasCharacters(final String password) {
        return password.matches(".+[A-z].*");
    }

    public boolean hasLowercase(final String password) {
        return password.matches(".+[a-z].*");
    }

    public boolean hasUpperCase(final String password) {
        return password.matches(".+[A-Z].*");
    }

    public boolean hasSymbols(final String password) {
        return password.matches("[^\\w\\s].*");
    }

    public boolean hasGoodMinLength(final String password) {
        return password.length() >= 8;
    }

    public boolean hasGoodMaxLength(final String password) {
        return password.length() <= 128;
    }

    public boolean isNotOnOfBlackList(final String password) {
        return !blackListPasswords.contains(password);
    }

    private Integer getBoolAsNum(boolean value) {
        if (value) {
            return 1;
        }
        return 0;
    }
}
