package hello_module.client.ui;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

/**
 * Created by Saniye on 31.10.16.
 */
public class ViewModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(HomePageView.class).to(HomePageViewImpl.class).in(Singleton.class);
        bind(LoginPageView.class).to(LoginPageViewImpl.class).in(Singleton.class);
    }
}
