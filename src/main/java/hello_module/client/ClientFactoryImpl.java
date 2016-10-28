package hello_module.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import hello_module.client.ui.HomePageView;
import hello_module.client.ui.HomePageViewImpl;
import hello_module.client.ui.LoginPageView;
import hello_module.client.ui.LoginPageViewImpl;

/**
 * Created by Saniye on 27.10.16.
 */
public class ClientFactoryImpl implements ClientFactory
{
    private static final EventBus eventBus = new SimpleEventBus();
    private static final PlaceController placeController = new PlaceController(eventBus);
    private static final HomePageView homeView = new HomePageViewImpl();
    private static final LoginPageView loginView = new LoginPageViewImpl();

    @Override
    public EventBus getEventBus()
    {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController()
    {
        return placeController;
    }

    @Override
    public HomePageView gethomePageView() {
        return homeView;
    }

    @Override
    public LoginPageView getLoginPageView() {
        return loginView;
    }


}
