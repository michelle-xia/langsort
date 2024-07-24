package com.icat.langsort.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseModel {
    @SerializedName("aaData")
    @Expose
    private List<List<String>> aaData;

    @SerializedName("sEcho")
    @Expose
    private String sEcho;

    @SerializedName("iTotalRecords")
    @Expose
    private Integer iTotalRecords;

    @SerializedName("iTotalDisplayRecords")
    @Expose
    private Integer iTotalDisplayRecords;

    public List<List<String>> getAaData() {
    return aaData;
    }

    public void setAaData(List<List<String>> aaData) {
    this.aaData = aaData;
    }

    public String getsEcho() {
    return sEcho;
    }

    public void setsEcho(String sEcho) {
    this.sEcho = sEcho;
    }

    public Integer getiTotalRecords() {
    return iTotalRecords;
    }

    public void setiTotalRecords(Integer iTotalRecords) {
    this.iTotalRecords = iTotalRecords;
    }

    public Integer getiTotalDisplayRecords() {
    return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
    this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

}