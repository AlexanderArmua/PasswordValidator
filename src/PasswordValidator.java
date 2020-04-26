import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PasswordValidator {
    // TODO: CHANGE BLACK LIST PASSWORD IMPLEMENTATION
    private static List<String> blackListPasswords = new ArrayList<>(Arrays.asList("/Qwerty123", "password", "contraseña", "123456789"));

    private static List<PasswordValidation> validationsToExecute =
            new ArrayList<>(
                    Arrays.asList(
                            new PasswordValidationRegex("La contrasena debe contener números.", ".*\\d.*"),
                            new PasswordValidationRegex("La contrasena debe contener caracteres alfabéticos.", ".*[A-z].*"),
                            new PasswordValidationRegex("La contrasena debe contener caracteres en minúscula.", ".*[a-z].*"),
                            new PasswordValidationRegex("La contrasena debe contener caracteres en mayúscula.", ".*[A-Z].*"),
                            new PasswordValidationRegex("La contrasena debe contener símbolos.", ".*[^\\w\\s].*"),
                            new PasswordValidationFunc("La contrasena debe ser mínimo de 8 caracteres.", pass -> pass.length() >= 8),
                            new PasswordValidationFunc("La contrasena debe ser mínimo de 128 caracteres.", pass -> pass.length() <= 128),
                            new PasswordValidationFunc("La contrasena es muy común, por favor, elija otra.", pass -> !blackListPasswords.contains(pass))
                    )
            );

    public PasswordValidator() {
    }

    public PasswordResult getSecurityPercentage(final String password) {
        final PasswordResult result = new PasswordResult();
        Integer securityLvl = 0;

        for (PasswordValidation validation : validationsToExecute) {
            boolean match = validation.passwordMatches(password);

            securityLvl += getBoolAsNum(match);

            addFail(match, result, validation.getFailText());
        }

        result.setSecurityLevel(securityLvl);

        return result;
    }

    private Integer getBoolAsNum(boolean value) {
        return (value) ? 1 : 0;
    }

    private void addFail(boolean match, PasswordResult result, String fail) {
        if(!match) {
            result.addFail(fail);
        }
    }

    public static List<PasswordValidation> getValidationsToExecute() {
        return validationsToExecute;
    }

    public static void setValidationsToExecute(List<PasswordValidation> validationsToExecute) {
        PasswordValidator.validationsToExecute = validationsToExecute;
    }

    public static List<String> getBlackListPasswords() {
        return blackListPasswords;
    }

    public static void setBlackListPasswords(List<String> blackListPasswords) {
        PasswordValidator.blackListPasswords = blackListPasswords;
    }
}
