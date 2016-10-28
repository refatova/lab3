package hello_module.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import hello_module.client.ClientFactory;
import hello_module.client.place.HomePlace;
import hello_module.client.ui.HomePageView;


/**
 * Created by Saniye on 27.10.16.
 */
public class HomeActivity extends AbstractActivity implements HomePageView.Presenter {
    private ClientFactory clientFactory;
    private String message;


    public HomeActivity(HomePlace place, ClientFactory clientFactory) {
        this.message = place.getGreetingMessage();
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        HomePageView homePageView = clientFactory.gethomePageView();
        homePageView.setExitButtonText();
        homePageView.setGreetingMessage(message);
        homePageView.setPresenter(this);
        containerWidget.setWidget(homePageView.asWidget());
    }

    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

}
