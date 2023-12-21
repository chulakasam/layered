package com.example.layeredarchitecture.model;

public class TableDTO {private String oid;
    private String date;
    private String itemcode;
    private String description;
    private String qty;
    private String unitprice;

    public TableDTO() {
    }

    public TableDTO(String oid, String date, String itemcode, String description, String qty, String unitprice) {
        this.oid = oid;
        this.date = date;
        this.itemcode = itemcode;
        this.description = description;
        this.qty = qty;
        this.unitprice = unitprice;
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

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public String toString() {
        return "TableDto{" +
                "oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", description='" + description + '\'' +
                ", qty='" + qty + '\'' +
                ", unitprice='" + unitprice + '\'' +
                '}';
    }
}
