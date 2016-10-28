package hello_module.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import hello_module.client.ui.HomePageView;
import hello_module.client.ui.LoginPageView;

/**
 * Created by Saniye on 27.10.16.
 */
public interface ClientFactory
{
    EventBus getEventBus();
    PlaceController getPlaceController();
    HomePageView gethomePageView();
    LoginPageView getLoginPageView();
}
