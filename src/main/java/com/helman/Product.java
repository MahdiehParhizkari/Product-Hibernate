package com.helman;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tbl_product")
public class Product {
    public Product(){}

    @Id
    @Column (name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "countryid_fk")
    private int countryid_fk;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private Float price;

    @Column(name = "createdate")
    private Date createdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryid_fk() {
        return countryid_fk;
    }

    public void setCountryid_fk(int countryid_fk) {
        this.countryid_fk = countryid_fk;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryid_fk=" + countryid_fk +
                ", count=" + count +
                ", price=" + price +
                ", createdate=" + createdate +
                '}';
    }
}
