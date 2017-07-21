package it.octavianionel.intentserviceretrofitexample.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

import it.octavianionel.intentserviceretrofitexample.model.CategoryPostsResponse;
import it.octavianionel.intentserviceretrofitexample.network.NetworkManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by octavian on 7/19/17.
 */

public class DownloadService extends IntentService {

    public static final int STATUS_RUNNING = 0;
    public static final int STATUS_FINISHED = 1;
    public static final int STATUS_ERROR = 2;


    private static final String TAG = "DownloadService";

    private NetworkManager mNetworkManager;
    private Context mContext;


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public DownloadService(String name) {
        super(name);
    }

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mNetworkManager = new NetworkManager(mContext);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "Service Started!");

        final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        String dev = intent.getStringExtra("dev");
        String slug = intent.getStringExtra("slug");

        final Bundle bundle = new Bundle();
        receiver.send(STATUS_RUNNING, bundle);

        mNetworkManager.getmApiService().getCategoryPostsAPI(dev, slug).enqueue(new Callback<CategoryPostsResponse>() {
            @Override
            public void onResponse(Call<CategoryPostsResponse> call, Response<CategoryPostsResponse> response) {
                response.body();
                bundle.putParcelableArrayList("postList", (ArrayList<? extends Parcelable>) response.body().getPosts());
                receiver.send(STATUS_FINISHED, bundle);

            }

            @Override
            public void onFailure(Call<CategoryPostsResponse> call, Throwable t) {
                Log.d(TAG, "onFailure");
                receiver.send(STATUS_ERROR, bundle);
            }
        });
        Log.d(TAG, "Service Stopping!");
        this.stopSelf();

    }
}
