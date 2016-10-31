package hello_module.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import hello_module.client.place.LoginPlace;

/**
 * Created by Saniye on 27.10.16.
 */
public class MainMVP implements EntryPoint {

    private Place defaultPlace = new LoginPlace();
    private SimplePanel appWidget = new SimplePanel();


    @Override
    public void onModuleLoad() {
        Injector ginjector = GWT.create(Injector.class);
        RootPanel.get("content").add(ginjector.getAppWidget());
        ginjector.getPlaceHistoryHandler().handleCurrentHistory();
    }
}
