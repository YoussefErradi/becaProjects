package org.nttdata.ecomjsf.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nttdata.ecomjsf.DAO.CategoryDAO;
import org.nttdata.ecomjsf.model.Category;
import org.nttdata.ecomjsf.util.HibernateUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAOImpl implements CategoryDAO {
    private static final Logger logger = Logger.getLogger(CategoryDAOImpl.class.getName());

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return HibernateUtil.getSessionFactory();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Could not create SessionFactory", e);
            throw new IllegalStateException("Could not create SessionFactory");
        }
    }

    @Override
    public void addCategory(Category Category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(Category);
        session.getTransaction().commit();
        logger.info("Category saved successfully, Category Details="+Category);
    }

    @Override
    public void updateCategory(Category Category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(Category);
        session.getTransaction().commit();
        logger.info("Category updated successfully, Category Details="+Category);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> listCategorys() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Category> CategorysList = session.createQuery("from Category").list();
        session.getTransaction().commit();

        return CategorysList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Category> selectCatByKeyword(String keyWord) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Category> CategorysList = session.createQuery("from Category c WHERE c.catName LIKE '%"+keyWord+"%'").list();
        session.getTransaction().commit();

        return CategorysList;
    }
    @Override
    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Category Category = (Category) session.load(Category.class, Integer.valueOf(id));
        session.getTransaction().commit();
        //logger.info("Category loaded successfully, Category details="+Category);
        return Category;
    }

    @Override
    public void removeCategory(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Category Category = (Category) session.load(Category.class, Integer.valueOf(id));

        if(null != Category){
            session.delete(Category);
        }
        session.getTransaction().commit();
        logger.info("Category deleted successfully, Category details="+Category);
    }
}
