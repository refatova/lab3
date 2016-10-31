package hello_module.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import hello_module.client.place.HomePlace;
import hello_module.client.ui.HomePageView;


/**
 * Created by Saniye on 27.10.16.
 */
public class HomeActivity extends AbstractActivity implements HomePageView.Presenter {
    private String message;
    HomePageView homePageView;
    private PlaceController placeController;

    @Inject
    public HomeActivity(HomePageView homePageView,PlaceController placeController) {
        this.homePageView=homePageView;
        this.placeController=placeController;

    }

    public HomeActivity getMessage(HomePlace place) {
        this.message = place.getGreetingMessage();
        return this;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        homePageView.setExitButtonText();
        homePageView.setGreetingMessage(message);
        homePageView.setPresenter(this);
        containerWidget.setWidget(homePageView.asWidget());
    }

    @Override
    public void goTo(Place place) {
        placeController.goTo(place);
    }

}
