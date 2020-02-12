package com.example.myfrag.Adapter;

public class example_item {
    private String mimageResource;
    private String mtitle;
    public example_item(String imageResource, String s1)
    { this.mimageResource=imageResource;
      this.mtitle=s1;

    }

    public String getMimageResource() {
        return mimageResource;
    }

    public String getMtitle() {
        return mtitle;
    }
}
