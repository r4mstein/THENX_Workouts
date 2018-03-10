package r4mstein.ua.thenxworkouts.auth.di;

import dagger.Component;
import r4mstein.ua.thenxworkouts.auth.login.LoginFragment;
import r4mstein.ua.thenxworkouts.auth.navigator.AuthActivity;
import r4mstein.ua.thenxworkouts.auth.register.RegisterFragment;
import r4mstein.ua.thenxworkouts.root.di.DiRootComponent;

/**
 * Created by Alex Shtain on 01.03.2018.
 */
@AuthScope
@Component(modules = DiAuthModule.class,
        dependencies = DiRootComponent.class)
public interface DiAuthComponent {
    void inject(AuthActivity _activity);
    void inject(RegisterFragment _fragment);
    void inject(LoginFragment _fragment);
}
