package hello_module.client.ui;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import hello_module.client.mvp.AppActivityMapper;

/**
 * Created by Saniye on 31.10.16.
 */
@Singleton
public class MainView extends SimplePanel {
    @Inject
    public MainView(AppActivityMapper mapper, EventBus eventBus) {
        ActivityManager activityManager = new ActivityManager(mapper, eventBus);
        activityManager.setDisplay(this);
    }
}
