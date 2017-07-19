package it.octavianionel.intentserviceretrofitexample.network;

import it.octavianionel.intentserviceretrofitexample.model.CategoryPostsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by octavian on 7/19/17.
 */

public interface APIService {

    //http://stacktips.com/api/get_category_posts/?dev=1&slug=android
    //BASE_URL + get_category_posts/?dev=1&slug=android
    @GET("get_category_posts/")
    Call<CategoryPostsResponse> getCategoryPostsAPI(@Query("dev") String dev, @Query("slug") String slug);
}
