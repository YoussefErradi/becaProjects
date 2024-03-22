package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.Produit;

@ManagedBean(name = "adminUsers", eager = true)
@SessionScoped
public class AdminUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<User> allUsers;
    private List<User> filteredUsers;
    private List<Produit> allProducts;
    private List<Produit> categoryProducts;
    private User selectedUser;
    private User userToAdd = new User();
    private int user;
    private Produit productToAdd = new Produit();
    private boolean editMode = false;
    private boolean addMode = false;
    private UserRestBean userRestBean = new UserRestBean();


    @PostConstruct
    public void init() {
        userRestBean.getUsers();
        allUsers = userRestBean.getUsersList();
    }

    public void edit() {
        System.out.println("edit clicked");
        editMode = true;
        addMode = false;
    }

    public void cancelUpdate() {
        editMode = false;
    }

    public void prepareAdd() {
        addMode = true;
        editMode = false;
        userToAdd = new User();
    }

    public void cancelAdd() {
        userToAdd = new User();
        addMode = false;
    }

    public void addUser() {
        System.out.println("Adding... => " + userToAdd);
        if (userToAdd != null) {
            userRestBean.addUser(userToAdd);
            System.out.println("Ajout de la catégorie avec Succès");
            addMessage(FacesMessage.SEVERITY_INFO, "Ajout Réussi", "Ajout de la catégorie avec Succès");
        } else {
            addMessage(FacesMessage.SEVERITY_WARN, "Ajout échoué", "Erreur lors de l'ajout de la catégorie");
        }
        addMode = false;
    }

    public void updateUser() {
        if (selectedUser != null) {
            System.out.println("Updating... => " + selectedUser);
//            userService.updateUser(selectedUser);
            System.out.println("Modification de la catégorie avec Succès");
            addMessage(FacesMessage.SEVERITY_INFO, "Modification Réussie", "Modification de la catégorie avec Succès");
        } else {
            addMessage(FacesMessage.SEVERITY_WARN, "Modification échouée", "Erreur lors de la modification de la catégorie");
        }
        editMode = false;
    }

    public void deleteSelectedUser() {
//        userService.removeUser(selectedUser.getId());
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.addMessage("msgDel", new FacesMessage(FacesMessage.SEVERITY_INFO, "User Supprimée", selectedUser.toString()));
//        allUsers=getAllUsers();
    }

    public Produit getProductToAdd() {
        return productToAdd;
    }

    public void setProductToAdd(Produit productToAdd) {
        this.productToAdd = productToAdd;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }


    public List<User> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(List<User> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }

    public List<Produit> getAllProducts() {
        return allProducts;
    }

    public void setAllProducts(List<Produit> allProducts) {
        this.allProducts = allProducts;
    }

    public List<Produit> getCategoryProducts() {
        return categoryProducts;
    }

    public void setCategoryProducts(List<Produit> categoryProducts) {
        this.categoryProducts = categoryProducts;
    }


    public User getSelectedUser() {
        return selectedUser;
    }


    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }


    public User getUserToAdd() {
        return userToAdd;
    }


    public void setUserToAdd(User userToAdd) {
        this.userToAdd = userToAdd;
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
        System.out.println("addMode = " + addMode);
        this.addMode = addMode;
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public UserRestBean getUserRestBean() {
        return userRestBean;
    }
}
