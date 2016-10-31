package hello_module.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;
import com.google.inject.Provider;
import hello_module.client.activity.HomeActivity;
import hello_module.client.activity.LoginActivity;
import hello_module.client.place.HomePlace;
import hello_module.client.place.LoginPlace;

/**
 * Created by Saniye on 27.10.16.
 */
public class AppActivityMapper implements ActivityMapper {

    Provider<HomeActivity> homeActivityProvider;
    Provider<LoginActivity> loginActivityProvider;

    @Inject
    public AppActivityMapper(final Provider<HomeActivity> homeActivityProvider,
                             final Provider<LoginActivity> loginActivityProvider) {
        super();
        this.homeActivityProvider = homeActivityProvider;
        this.loginActivityProvider = loginActivityProvider;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof HomePlace)
            return homeActivityProvider.get().getMessage((HomePlace)place);
        else if (place instanceof LoginPlace)
            return loginActivityProvider.get();
        return null;
    }

}
