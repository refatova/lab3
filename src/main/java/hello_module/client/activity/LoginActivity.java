package hello_module.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import hello_module.client.ClientFactory;
import hello_module.client.place.LoginPlace;
import hello_module.client.ui.LoginPageView;

/**
 * Created by Saniye on 27.10.16.
 */
public class LoginActivity extends AbstractActivity implements LoginPageView.Presenter {

    private ClientFactory clientFactory;

    public LoginActivity(LoginPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        LoginPageView loginPageView = clientFactory.getLoginPageView();
        loginPageView.setNameFieldLabel();
        loginPageView.setPasswordFieldLabel();
        loginPageView.cleanErrorMessage();
        loginPageView.setLoginButtonText();
        loginPageView.cleanLoginField();
        loginPageView.cleanPasswordField();
        loginPageView.setLoginButtonEnable(true);
        loginPageView.setPresenter(this);
        containerWidget.setWidget(loginPageView.asWidget());
    }

    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
