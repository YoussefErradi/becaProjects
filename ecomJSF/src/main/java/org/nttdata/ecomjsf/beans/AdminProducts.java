package org.nttdata.ecomjsf.beans;

import org.nttdata.ecomjsf.service.ProductDAOImpl;
import org.nttdata.ecomjsf.model.Product;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean (name = "AdminProducts", eager = true)
@SessionScoped
public class AdminProducts implements Serializable {
    private static final long serialVersionUID = 1L;

    private Product productToAdd = new Product();
    private ProductDAOImpl productService = new ProductDAOImpl();
    private List<Product> allProducts;
    private Product selectedProduct;
    private boolean editMode = false;
    private boolean addMode = false;

    @PostConstruct
    public void init(){
        allProducts = productService.listProducts();
    }

    public void addProduct(){
        if(productToAdd != null) {
            productService.addProduct(productToAdd);
            addMessage(FacesMessage.SEVERITY_INFO, "Product added successfully", null);
            productToAdd = new Product(); // reset the productToAdd
            allProducts = productService.listProducts(); // refresh the list of products
        } else {
            addMessage(FacesMessage.SEVERITY_WARN, "Failed to add product", null);
        }
        addMode = false;
    }

    public void updateProduct(){
        if(selectedProduct != null) {
            productService.updateProduct(selectedProduct);
            addMessage(FacesMessage.SEVERITY_INFO, "Product updated successfully", null);
            allProducts = productService.listProducts(); // refresh the list of products
        } else {
            addMessage(FacesMessage.SEVERITY_WARN, "Failed to update product", null);
        }
        editMode = false;
    }

    public void deleteSelectedProduct() {
        if(selectedProduct != null) {
            productService.removeProduct(selectedProduct.getId());
            addMessage(FacesMessage.SEVERITY_INFO, "Product deleted successfully", null);
            allProducts = productService.listProducts(); // refresh the list of products
        } else {
            addMessage(FacesMessage.SEVERITY_WARN, "Failed to delete product", null);
        }
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }


    // getters and setters for productToAdd, productService, allProducts, selectedProduct, editMode, addMode


    public Product getProductToAdd() {
        return productToAdd;
    }

    public void setProductToAdd(Product productToAdd) {
        this.productToAdd = productToAdd;
    }

    public ProductDAOImpl getProductService() {
        return productService;
    }

    public void setProductService(ProductDAOImpl productService) {
        this.productService = productService;
    }

    public List<Product> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Product> allProducts) {
        this.allProducts = allProducts;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public boolean isAddMode() {
        return addMode;
    }

    public void setAddMode(boolean addMode) {
        this.addMode = addMode;
    }
}