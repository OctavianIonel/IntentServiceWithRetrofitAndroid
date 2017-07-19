package it.octavianionel.intentserviceretrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by octavian on 7/19/17.
 */

public class CustomFields {

    @SerializedName("dsq_thread_id")
    @Expose
    private List<String> dsqThreadId = null;
    @SerializedName("rop_post_url_facebook")
    @Expose
    private List<String> ropPostUrlFacebook = null;

    public List<String> getDsqThreadId() {
        return dsqThreadId;
    }

    public void setDsqThreadId(List<String> dsqThreadId) {
        this.dsqThreadId = dsqThreadId;
    }

    public List<String> getRopPostUrlFacebook() {
        return ropPostUrlFacebook;
    }

    public void setRopPostUrlFacebook(List<String> ropPostUrlFacebook) {
        this.ropPostUrlFacebook = ropPostUrlFacebook;
    }

}
