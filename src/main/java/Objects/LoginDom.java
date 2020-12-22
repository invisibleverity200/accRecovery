package Objects;

public class LoginDom {
    public String usernameXPath;
    public String passwordXPath;
    public String loginXPath;
    public String checkForXPath;
    public String url;
    public String message;

    public LoginDom(String usernameXPath, String passwordXPath, String loginXPath, String checkForXPath, String url, String message) {
        this.usernameXPath = usernameXPath;
        this.passwordXPath = passwordXPath;
        this.loginXPath = loginXPath;
        this.checkForXPath = checkForXPath;
        this.url = url;
        this.message = message;
    }
}
