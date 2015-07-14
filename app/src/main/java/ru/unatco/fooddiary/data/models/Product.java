package ru.unatco.fooddiary.data.models;

public class Product {
    private String mId;
    private String mName;

    public Product() {}

    public Product(String mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return !(mId != null ? !mId.equals(product.mId) : product.mId != null);

    }

    @Override
    public int hashCode() {
        return mId != null ? mId.hashCode() : 0;
    }
}
