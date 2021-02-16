package com.helman;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class ProductDaoTest {
    ProductDao productDao = new ProductDao();

    @Test
    public void findAll() {
        List<Product> productList = productDao.findAll();
        for(Product product : productList){
            System.out.println(product);
        }
        for(int i = 0 ; i<productList.size(); i++){
            System.out.println(productList.get(i));
        }
    }

    @Test
    public void findByIdTest(){
        Product product = productDao.findById(33);
        System.out.println(product);
    }

    @Test
    public void insertTest(){
        Product pro = new Product();
        pro.setId(33);
        pro.setName("Benz");
        pro.setCountryid_fk(1);
        pro.setCount(1);
        pro.setPrice(Float.parseFloat("800"));
        pro.setCreatedate(new Date());
        productDao.insert(pro);
    }

    @Test
    public void updateTest(){
        Product pro = productDao.findById(36);
        pro.setCountryid_fk(2);
        pro.setCount(4);
        pro.setPrice(Float.parseFloat("30000"));
        productDao.update(pro);
    }

    @Test
    public void deleteTest(){
        Product product = productDao.findById(33);
        productDao.delete(product);
    }
}