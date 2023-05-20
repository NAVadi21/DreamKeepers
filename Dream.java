package com.example.aadat;

public class Dream {
    private String date;
    private String title;
    private String description;

    public Dream(String date, String title, String description) {
        this.date = date;
        this.title = title;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

