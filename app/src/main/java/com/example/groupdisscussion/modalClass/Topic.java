package com.example.groupdisscussion.modalClass;

public class Topic {
    String category;

    public Topic(String list_of_category) {
        category = list_of_category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
