package hello_module.client.activity;

import com.google.gwt.inject.client.AbstractGinModule;

/**
 * Created by Saniye on 31.10.16.
 */
public class ActivityModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(HomeActivity.class);
        bind(LoginActivity.class);
    }
}
