package com.coolweathermine.android.Weather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tony on 2017/4/30.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
