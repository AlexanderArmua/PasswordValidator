import java.util.ArrayList;
import java.util.List;

public class PasswordResult {

    private Integer securityLevel;
    private List<String> securityFails = new ArrayList<>();

    public void addFail(String fail) {
        this.securityFails.add(fail);
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public List<String> getSecurityFails() {
        return securityFails;
    }

    public void setSecurityFails(List<String> securityFails) {
        this.securityFails = securityFails;
    }
}
