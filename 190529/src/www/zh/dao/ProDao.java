package www.zh.dao;


import www.zh.common.Product;

import java.util.List;

public interface ProDao {

    //查询商品
    List<Product> getAllPro();

    //添加商品
    void addProduct(Product pd);


}



