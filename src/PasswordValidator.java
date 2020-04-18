import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    // TODO: CHANGE BLACK LIST PASSWORD IMPLEMENTATION
    private static List<String> blackListPasswords = new ArrayList<>();

    public PasswordValidator() {
        blackListPasswords.add("/Qwerty123");
    }

    public PasswordResult getSecurityPercentage(String password) {
        PasswordResult result = new PasswordResult();
        Integer securityLvl = 0;
        boolean match = false;

        match = hasNumbers(password);
        securityLvl += getBoolAsNum(match);
        addFail(match, result, "La contrasena debe contener números.");

        match = hasCharacters(password);
        securityLvl += getBoolAsNum(match);
        addFail(match, result, "La contrasena debe contener caracteres alfabéticos.");

        match = hasLowercase(password);
        securityLvl += getBoolAsNum(match);
        addFail(match, result, "La contrasena debe contener caracteres en minúscula.");

        match = hasUpperCase(password);
        securityLvl += getBoolAsNum(match);
        addFail(match, result, "La contrasena debe contener caracteres en mayúscula.");

        match = hasSymbols(password);
        securityLvl += getBoolAsNum(match);
        addFail(match, result, "La contrasena debe contener símbolos.");

        match = hasGoodMinLength(password);
        securityLvl += getBoolAsNum(match);
        addFail(match, result, "La contrasena debe ser mínimo de 8 caracteres.");

        match = hasGoodMaxLength(password);
        securityLvl += getBoolAsNum(match);
        addFail(match, result, "La contrasena debe ser mínimo de 128 caracteres.");

        match = isNotOnOfBlackList(password);
        securityLvl += getBoolAsNum(match);
        addFail(match, result, "La contrasena es muy común, por favor, elija otra.");

        result.setSecurityLevel(securityLvl);

        return result;
    }

    public boolean hasNumbers(final String password) {
        return password.matches(".*\\d.*");
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

    private void addFail(boolean match, PasswordResult result, String fail) {
        if(!match) {
            result.addFail(fail);
        }
    }
}
