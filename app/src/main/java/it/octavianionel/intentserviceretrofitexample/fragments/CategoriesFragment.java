package it.octavianionel.intentserviceretrofitexample.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import it.octavianionel.intentserviceretrofitexample.R;
import it.octavianionel.intentserviceretrofitexample.activities.CategoriesAdapter;
import it.octavianionel.intentserviceretrofitexample.model.Post;
import it.octavianionel.intentserviceretrofitexample.model.eventbusmodel.Events;
import it.octavianionel.intentserviceretrofitexample.network.NetworkManager;
import it.octavianionel.intentserviceretrofitexample.services.DownloadResultReceiver;
import it.octavianionel.intentserviceretrofitexample.services.DownloadService;

/**
 * Created by octavian on 7/19/17.
 */

public class CategoriesFragment extends GeneralFragment implements DownloadResultReceiver.Receiver {

    private NetworkManager mNetworkManager;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private RecyclerView.LayoutManager mLayoutManager;
    private CategoriesAdapter mCategoriesAdapter;
    private List<Post> mPostList = new ArrayList<>();
    private Activity mActivity;

    private DownloadResultReceiver mReceiver;

    private String dev = "dev";
    private String slug = "android";

    public static CategoriesFragment newInstance() {
        Bundle args = new Bundle();
        CategoriesFragment fragment = new CategoriesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        mNetworkManager = new NetworkManager(mActivity);
        mCategoriesAdapter = new CategoriesAdapter(mActivity, mPostList);
//        mNetworkManager.obtainCategoryPosts("dev", "android");
                /* Starting Download Service */
        mReceiver = new DownloadResultReceiver(new Handler());
        mReceiver.setReceiver(this);
        Intent intent = new Intent(Intent.ACTION_SYNC, null, mActivity, DownloadService.class);

        /* Send optional extras to Download IntentService */
        intent.putExtra("dev", dev);
        intent.putExtra("slug", slug);
        intent.putExtra("receiver", mReceiver);

        mActivity.startService(intent);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        mProgressBar = (ProgressBar)view.findViewById(R.id.progressBar);
        if (mPostList.size() > 0) {
            mProgressBar.setVisibility(View.GONE);
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
        }
        mLayoutManager = new GridLayoutManager(((getActivity())), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mCategoriesAdapter);
        mCategoriesAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch (resultCode) {
            case DownloadService.STATUS_RUNNING:
                mProgressBar.setIndeterminate(true);
                break;
            case DownloadService.STATUS_FINISHED:
                /* Hide progress & extract result from bundle */
                mPostList.clear();
                mProgressBar.setIndeterminate(false);
                mProgressBar.setVisibility(View.GONE);
                mPostList = (ArrayList)resultData.getParcelableArrayList("postList");
                mCategoriesAdapter = new CategoriesAdapter(mActivity, mPostList);
                mRecyclerView.setAdapter(mCategoriesAdapter);
                mCategoriesAdapter.notifyDataSetChanged();
                break;
            case DownloadService.STATUS_ERROR:
                /* Handle the error */
                String error = resultData.getString(Intent.EXTRA_TEXT);
                Toast.makeText(mActivity, error, Toast.LENGTH_LONG).show();
                break;
        }
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEvent(Events.EventCategories event) {
//        mPostList.clear();
//        mPostList.addAll(event.getmPostList());
//        mProgressBar.setIndeterminate(false);
//        mProgressBar.setVisibility(View.GONE);
//        mCategoriesAdapter.notifyDataSetChanged();
//    }
}
