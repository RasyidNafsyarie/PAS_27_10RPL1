package com.example.pas_27_10rpl1;

public class Makanan {

    private String title;
    private int img;
    private String deskripsi;

    public Makanan(String title, int img, String deskripsi) {
        this.title = title;
        this.img = img;
        this.deskripsi = deskripsi;
    }


    public String getTitle() {
        return title;
    }

    public void setTitleTv(String title) {
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDeskripsi() {
        return deskripsi;
    }


}
