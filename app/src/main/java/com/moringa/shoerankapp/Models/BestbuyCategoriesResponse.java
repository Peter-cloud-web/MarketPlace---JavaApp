package com.moringa.shoerankapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BestbuyCategoriesResponse implements Serializable, Parcelable
{

    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    public final static Parcelable.Creator<BestbuyCategoriesResponse> CREATOR = new Creator<BestbuyCategoriesResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public BestbuyCategoriesResponse createFromParcel(Parcel in) {
            return new BestbuyCategoriesResponse(in);
        }

        public BestbuyCategoriesResponse[] newArray(int size) {
            return (new BestbuyCategoriesResponse[size]);
        }

    }
            ;
    private final static long serialVersionUID = 4329724256663889499L;

    protected BestbuyCategoriesResponse(Parcel in) {
        in.readList(this.categories, (Category.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public BestbuyCategoriesResponse() {
    }

    /**
     *
     * @param categories
     */
    public BestbuyCategoriesResponse(List<Category> categories) {
        super();
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(categories);
    }

    public int describeContents() {
        return  0;
    }

}
