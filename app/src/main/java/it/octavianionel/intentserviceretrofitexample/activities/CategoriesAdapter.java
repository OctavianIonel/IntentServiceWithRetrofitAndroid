package it.octavianionel.intentserviceretrofitexample.activities;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.octavianionel.intentserviceretrofitexample.R;
import it.octavianionel.intentserviceretrofitexample.model.Post;

/**
 * Created by octavian on 7/19/17.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Post> mPosts = new ArrayList<>();

    public CategoriesAdapter(Context context, List<Post> posts) {
        mContext = context;
        mPosts = posts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.slugTv.setText(post.getSlug());
        holder.titleTv.setText(post.getTitle());
        holder.idTv.setText(String.valueOf(post.getId()));
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView slugTv;
        private TextView titleTv;
        private TextView idTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.cv);
            slugTv = (TextView)itemView.findViewById(R.id.tv_slug);
            titleTv = (TextView) itemView.findViewById(R.id.tv_title);
            idTv = (TextView)itemView.findViewById(R.id.tv_id);
        }
    }
}
