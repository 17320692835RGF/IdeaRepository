package com.ren.entity;

public class Goods {
    private Integer id;
    private String name;
    private String adress;
    private String broad;

    public Goods(Integer id, String name, String adress, String broad) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.broad = broad;
    }

    public Goods() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getBroad() {
        return broad;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", broad='" + broad + '\'' +
                '}';
    }
}
