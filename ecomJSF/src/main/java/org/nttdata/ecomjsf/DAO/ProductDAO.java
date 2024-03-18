package org.nttdata.ecomjsf.DAO;

import org.nttdata.ecomjsf.model.Product;

import java.util.List;

public interface ProductDAO {
    public void addProduct(Product Product);
    public void updateProduct(Product Product);
    public List<Product> listProducts();

    public List<Product> selectProductsByKeyword(String keyWord);
    public Product getProductById(int id);
    public void removeProduct(int id);
}
