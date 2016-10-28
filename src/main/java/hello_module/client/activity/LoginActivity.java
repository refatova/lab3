package hello_module.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import hello_module.client.ClientFactory;
import hello_module.client.LoginServiceIntf;
import hello_module.client.LoginServiceIntfAsync;
import hello_module.client.place.HomePlace;
import hello_module.client.place.LoginPlace;
import hello_module.client.ui.GWTHelloConstants;
import hello_module.client.ui.LoginPageView;
import hello_module.client.ui.LoginPageViewImpl;

import java.util.logging.Logger;

/**
 * Created by Saniye on 27.10.16.
 */
public class LoginActivity extends AbstractActivity implements LoginPageView.Presenter {

    private ClientFactory clientFactory;
    private LoginPageView loginPageView;
    private static Logger logger = Logger.getLogger(LoginPageViewImpl.class.getName());
    private final LoginServiceIntfAsync loginService = GWT.create(LoginServiceIntf.class);
    private GWTHelloConstants constants = GWT.create(GWTHelloConstants.class);
    private static final String LOGIN_PAGE = "LoginPage: ";

    public LoginActivity(LoginPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.loginPageView=clientFactory.getLoginPageView();
    }

    @Override
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
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

    @Override
    public void sendUserToServer(String login, String password) {
        loginService.login(login, password, LocaleInfo.getCurrentLocale().getLocaleName(),
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable caught) {
                       loginPageView.setErrorMessage(constants.serverError());
                        logger.info(LOGIN_PAGE + "Error message \"Incorrect username or password\"");
                        loginPageView.setLoginButtonEnable(true);
                    }

                    @Override
                    public void onSuccess(String result) {
                        goTo(new HomePlace(result));
                    }
                });
    }
}
