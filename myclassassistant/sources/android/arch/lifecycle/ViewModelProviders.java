package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;

public class ViewModelProviders {
    private static Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    private static Activity checkActivity(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    @MainThread
    @NonNull
    /* renamed from: of */
    public static ViewModelProvider m0of(@NonNull Fragment fragment) {
        return m1of(fragment, (ViewModelProvider.Factory) null);
    }

    @MainThread
    @NonNull
    /* renamed from: of */
    public static ViewModelProvider m2of(@NonNull FragmentActivity activity) {
        return m3of(activity, (ViewModelProvider.Factory) null);
    }

    @MainThread
    @NonNull
    /* renamed from: of */
    public static ViewModelProvider m1of(@NonNull Fragment fragment, @Nullable ViewModelProvider.Factory factory) {
        Application application = checkApplication(checkActivity(fragment));
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        }
        return new ViewModelProvider(ViewModelStores.m4of(fragment), factory);
    }

    @MainThread
    @NonNull
    /* renamed from: of */
    public static ViewModelProvider m3of(@NonNull FragmentActivity activity, @Nullable ViewModelProvider.Factory factory) {
        Application application = checkApplication(activity);
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application);
        }
        return new ViewModelProvider(ViewModelStores.m5of(activity), factory);
    }

    @Deprecated
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(@NonNull Application application) {
            super(application);
        }
    }
}
