package org.example.models;

public class Categories {
    private String id;
    private String category_name;

    public Categories(String id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }

    public Categories() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
