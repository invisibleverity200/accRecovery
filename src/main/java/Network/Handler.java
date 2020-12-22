package Network;

import Objects.LoginData;
import Objects.LoginDom;

import java.io.IOException;

public interface Handler {
    boolean getResponse(LoginData person, LoginDom domModel) throws IOException, InterruptedException;
}
