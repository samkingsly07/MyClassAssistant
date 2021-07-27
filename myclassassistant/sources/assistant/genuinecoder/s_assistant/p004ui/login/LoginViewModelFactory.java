package assistant.genuinecoder.s_assistant.p004ui.login;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import assistant.genuinecoder.s_assistant.data.LoginDataSource;
import assistant.genuinecoder.s_assistant.data.LoginRepository;

/* renamed from: assistant.genuinecoder.s_assistant.ui.login.LoginViewModelFactory */
public class LoginViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return new LoginViewModel(LoginRepository.getInstance(new LoginDataSource()));
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
