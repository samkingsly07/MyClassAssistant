package assistant.genuinecoder.s_assistant.p004ui.login;

import android.support.annotation.Nullable;

/* renamed from: assistant.genuinecoder.s_assistant.ui.login.LoginFormState */
class LoginFormState {
    private boolean isDataValid;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer usernameError;

    LoginFormState(@Nullable Integer usernameError2, @Nullable Integer passwordError2) {
        this.usernameError = usernameError2;
        this.passwordError = passwordError2;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid2) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid2;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Integer getUsernameError() {
        return this.usernameError;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Integer getPasswordError() {
        return this.passwordError;
    }

    /* access modifiers changed from: package-private */
    public boolean isDataValid() {
        return this.isDataValid;
    }
}
