package assistant.genuinecoder.s_assistant.data;

import assistant.genuinecoder.s_assistant.data.Result;
import assistant.genuinecoder.s_assistant.data.model.LoggedInUser;
import java.io.IOException;
import java.util.UUID;

public class LoginDataSource {
    public Result<LoggedInUser> login(String username, String password) {
        try {
            return new Result.Success(new LoggedInUser(UUID.randomUUID().toString(), "Jane Doe"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
    }
}
