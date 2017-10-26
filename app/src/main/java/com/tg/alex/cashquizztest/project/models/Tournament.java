package com.tg.alex.cashquizztest.project.models;

import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex on 10/26/2017.
 */

public class Tournament {

    @SerializedName("id")
    private String id;

    @SerializedName("imageUrl")
    private String imgUrl;

    @SerializedName("description")
    private String desc;

    @SerializedName("endedAt")
    private String endDate;

    @SerializedName("categoryId")
    private String categoryId;

    private Date mDate;
    private SimpleDateFormat mInputFormat;
    private SimpleDateFormat mOutputFormat;

    public Tournament() {
    }

    public String getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public String getEndDate() {
        setEndDate();
        return mOutputFormat.format(mDate);
    }

    public long getEndDateTimeStamp(){
        setEndDate();
        return mDate.getTime();
    }

    public String getCategoryId() {
        return categoryId;
    }

    private void setEndDate(){
        if(mDate == null){
            mInputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            mOutputFormat = new SimpleDateFormat("MM.dd.yyyy - HH:mm");
            try {
                mDate = mInputFormat.parse(endDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
