package assistant.genuinecoder.s_assistant.p004ui.login;

import android.support.annotation.Nullable;

/* renamed from: assistant.genuinecoder.s_assistant.ui.login.LoginResult */
class LoginResult {
    @Nullable
    private Integer error;
    @Nullable
    private LoggedInUserView success;

    LoginResult(@Nullable Integer error2) {
        this.error = error2;
    }

    LoginResult(@Nullable LoggedInUserView success2) {
        this.success = success2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public LoggedInUserView getSuccess() {
        return this.success;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Integer getError() {
        return this.error;
    }
}
