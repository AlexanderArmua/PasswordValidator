public interface PasswordValidation {
    Boolean passwordMatches(String password);
    String getFailText();
}
