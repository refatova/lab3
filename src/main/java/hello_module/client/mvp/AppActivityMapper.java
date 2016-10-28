package hello_module.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import hello_module.client.ClientFactory;
import hello_module.client.activity.HomeActivity;
import hello_module.client.activity.LoginActivity;
import hello_module.client.place.HomePlace;
import hello_module.client.place.LoginPlace;

/**
 * Created by Saniye on 27.10.16.
 */
public class AppActivityMapper  implements ActivityMapper {

    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace)
            return new HomeActivity((HomePlace) place, clientFactory);
        else if (place instanceof LoginPlace)
            return new LoginActivity((LoginPlace) place, clientFactory);

        return null;
    }
}
