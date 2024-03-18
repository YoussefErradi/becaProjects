package org.nttdata.ecomjsf.beans;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.nttdata.ecomjsf.model.Category;
import org.nttdata.ecomjsf.model.Product;
import org.nttdata.ecomjsf.service.CategoryDAOImpl;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean(name = "AdminCategories", eager = true)
@SessionScoped
public class AdminCategories implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Category> allCategories;
	private List<Category> filteredCategories;
	private List<Product> allProducts;
	private List<Product> categoryProducts;
	private Category selectedCategory;
	private Category CategoryToAdd = new Category();
	private int Category;
	private Product productToAdd = new Product();
	private CategoryDAOImpl categDao = new CategoryDAOImpl();
	private boolean editMode = false;
	private boolean addMode = false;
	
	private CategoryDAOImpl categService;
	{
		categService = new CategoryDAOImpl();
	}
	
	@PostConstruct
	public void init(){
		allCategories=getallCategories();
	}
	
	public void edit(){
		System.out.println("edit clicked");
		editMode=true;
		addMode=false;
	}
	public void cancelUpdate(){
		editMode=false;
	}

	public void prepareAdd(){
		addMode=true;
		editMode=false;
	}
	public void cancelAdd(){
		CategoryToAdd=new Category();
		addMode=false;	
	}
	
	public void addCategory(){
		
		if(CategoryToAdd!=null) {
			categService.addCategory(CategoryToAdd);
			System.out.println("Ajout de la catégorie avec Succès");
			addMessage(FacesMessage.SEVERITY_INFO, "Ajout Réussi", "Ajout de la catégorie avec Succès");
		}else {
			addMessage(FacesMessage.SEVERITY_WARN, "Ajout échoué", "Erreur lors de l'ajout de la catégorie");
		}
		addMode=false;
	}
	
	public void updateCategory(){
		if(selectedCategory!=null) {
			System.out.println("Updating... => "+ selectedCategory);
			categService.updateCategory(selectedCategory);
			System.out.println("Modification de la catégorie avec Succès");
			addMessage(FacesMessage.SEVERITY_INFO, "Modification Réussie", "Modification de la catégorie avec Succès");
		}else {
			addMessage(FacesMessage.SEVERITY_WARN, "Modification échouée", "Erreur lors de la modification de la catégorie");
		}
		editMode=false;
	}
	
	public void deleteSelectedCategory() {
		categService.removeCategory(selectedCategory.getId());
	      FacesContext context = FacesContext.getCurrentInstance();
	      context.addMessage("msgDel", new FacesMessage(FacesMessage.SEVERITY_INFO, "Category Supprimée", selectedCategory.toString()));
	      allCategories=getallCategories();
		}
	
	public List<Product> getCategoriyProducts() {
		Category categ = categDao.getCategoryById(Category);
		categoryProducts = new ArrayList<Product>(categ.getProducts());
		return categoryProducts;
	}
	
		
	public List<Category> getallCategories() {
		allCategories = categDao.listCategorys();
		return allCategories;
	}
	

	public Product getProductToAdd() {
		return productToAdd;
	}

	public void setProductToAdd(Product productToAdd) {
		this.productToAdd = productToAdd;
	}

	public int getCategory() {
		return Category;
	}

	public void setCategory(int Category) {
		this.Category = Category;
	}

	public void setallCategories(List<Category> allCategories) {
		this.allCategories = allCategories;
	}

	
	public List<Category> getFilteredCategorys() {
		return filteredCategories;
	}

	public void setFilteredCategorys(List<Category> filteredCategorys) {
		this.filteredCategories = filteredCategorys;
	}

	public List<Product> getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(List<Product> allProducts) {
		this.allProducts = allProducts;
	}

	public List<Product> getCategoryProducts() {
		return categoryProducts;
	}

	public void setCategoryProducts(List<Product> categoryProducts) {
		this.categoryProducts = categoryProducts;
	}


	public Category getSelectedCategory() {
		return selectedCategory;
	}


	public void setSelectedCategory(Category selectedCategory) {
		this.selectedCategory = selectedCategory;
	}


	public Category getCategoryToAdd() {
		return CategoryToAdd;
	}


	public void setCategoryToAdd(Category CategoryToAdd) {
		this.CategoryToAdd = CategoryToAdd;
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
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();
		byte[] contents = uploadedFile.getContent();
		CategoryToAdd.setCatImage(contents);
	}

	public Category getCategoryById(Integer idcat) {
		return categService.getCategoryById(idcat);
	}
}
