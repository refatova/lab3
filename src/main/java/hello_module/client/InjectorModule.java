package hello_module.client;

import com.google.gwt.inject.client.AbstractGinModule;
import hello_module.client.activity.ActivityModule;
import hello_module.client.mvp.MvpModule;
import hello_module.client.ui.*;

/**
 * Created by Saniye on 31.10.16.
 */
public class InjectorModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(MainView.class);

        install(new MvpModule());
        install(new ViewModule());
        install(new ActivityModule());
    }
}
