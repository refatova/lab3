package hello_module.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import hello_module.client.place.HomePlace;
import hello_module.client.place.LoginPlace;

/**
 * Created by Saniye on 27.10.16.
 */

@WithTokenizers( { HomePlace.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
