package org.nttdata.ecomjsf.DAO;


import org.nttdata.ecomjsf.model.Category;

import java.util.List;

public interface CategoryDAO {
    public void addCategory(Category Category);
    public void updateCategory(Category Category);
    public List<Category> listCategorys();
    public List<Category> selectCatByKeyword(String keyWord);
    public Category getCategoryById(int id);
    public void removeCategory(int id);
}
