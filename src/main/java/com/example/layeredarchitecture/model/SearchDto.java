package com.example.layeredarchitecture.model;

public class SearchDto {
    private String name;
    private String oid;
    private String date;

    public SearchDto() {
    }

    public SearchDto(String name, String oid, String date) {
        this.name = name;
        this.oid = oid;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SearchDto{" +
                "name='" + name + '\'' +
                ", oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
