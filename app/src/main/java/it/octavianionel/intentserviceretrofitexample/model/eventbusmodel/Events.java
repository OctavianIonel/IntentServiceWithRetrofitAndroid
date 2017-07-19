package it.octavianionel.intentserviceretrofitexample.model.eventbusmodel;

import java.util.List;

import it.octavianionel.intentserviceretrofitexample.model.Post;

/**
 * Created by octavian on 7/19/17.
 */

public class Events {

    public static class EventCategories {
        private List<Post> mPostList;

        public EventCategories(List<Post> posts) {
            mPostList = posts;
        }

        public List<Post> getmPostList() {
            return mPostList;
        }
    }
}
