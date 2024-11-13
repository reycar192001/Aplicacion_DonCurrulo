package com.example.examenfinal_doncurrulo.Domain;

public class ComentDomain {

    private String name;
    private String img;
    private String coments;
    private String score;
    private float rating;

    public ComentDomain(String name, String img, String coments, String score, float rating) {
        this.name = name;
        this.img = img;
        this.coments = coments;
        this.score = score;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getComents() {
        return coments;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
