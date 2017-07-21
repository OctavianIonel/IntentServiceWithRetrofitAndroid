package it.octavianionel.intentserviceretrofitexample.network;

import android.content.Context;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import it.octavianionel.intentserviceretrofitexample.model.eventbusmodel.Events;
import it.octavianionel.intentserviceretrofitexample.utils.Constants;
import it.octavianionel.intentserviceretrofitexample.model.CategoryPostsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by octavian on 7/19/17.
 */

public class NetworkManager {

    private static final String TAG = NetworkManager.class.getCanonicalName();
    private APIService mApiService;
    private Context mContext;

    public NetworkManager(Context context) {
        this.mContext = context;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApiService = retrofit.create(APIService.class);
    }

    public APIService getmApiService() {
        return mApiService;
    }

    public void obtainCategoryPosts(String dev, String slug) {
        mApiService.getCategoryPostsAPI(dev, slug).enqueue(new Callback<CategoryPostsResponse>() {
            @Override
            public void onResponse(Call<CategoryPostsResponse> call, Response<CategoryPostsResponse> response) {
                EventBus.getDefault().post(new Events.EventCategories(response.body().getPosts()));
            }

            @Override
            public void onFailure(Call<CategoryPostsResponse> call, Throwable t) {
                Log.d(TAG, "failure");
            }
        });
    }
}
