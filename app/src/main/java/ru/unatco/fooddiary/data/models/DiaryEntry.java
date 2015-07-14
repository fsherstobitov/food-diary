package ru.unatco.fooddiary.data.models;

import java.util.Date;
import java.util.List;

public class DiaryEntry {
    private String mId;
    private Date mDate;
    private String mNote;
    private List<Product> mChildProducts;
    private List<Product> mMotherProducts;

    public DiaryEntry() {
        mDate = new Date();
    }

    public DiaryEntry(String id, Date date, String note, List<Product> childProducts, List<Product> motherProducts) {
        mId = id;
        mDate = date;
        mNote = note;
        mChildProducts = childProducts;
        mMotherProducts = motherProducts;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }

    public List<Product> getChildProducts() {
        return mChildProducts;
    }

    public void setChildProducts(List<Product> childProducts) {
        mChildProducts = childProducts;
    }

    public List<Product> getMotherProducts() {
        return mMotherProducts;
    }

    public void setMotherProducts(List<Product> motherProducts) {
        mMotherProducts = motherProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiaryEntry that = (DiaryEntry) o;

        return mId.equals(that.mId);

    }

    @Override
    public int hashCode() {
        return mId.hashCode();
    }
}
