package hello_module.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import hello_module.client.ui.MainView;

/**
 * Created by Saniye on 31.10.16.
 */

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    PlaceHistoryHandler getPlaceHistoryHandler();
    MainView getAppWidget();
}
