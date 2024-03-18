package org.nttdata.ecomjsf.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nttdata.ecomjsf.DAO.ProductDAO;
import org.nttdata.ecomjsf.model.Product;
import org.nttdata.ecomjsf.util.HibernateUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAOImpl implements ProductDAO {
    private static final Logger logger = Logger.getLogger(ProductDAOImpl.class.getName());

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
    public void addProduct(Product category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        logger.info("Product saved successfully, Product Details="+category);
    }

    @Override
    public void updateProduct(Product category) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(category);
        session.getTransaction().commit();
        logger.info("Product updated successfully, Product Details="+category);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> listProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> ProductsList = session.createQuery("from Product").list();
        session.getTransaction().commit();

        return ProductsList;
    }

    @Override
    public List<Product> selectProductsByKeyword(String keyWord) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> productsList = session.createQuery("from Product p WHERE p.productName LIKE :keyword")
                .setParameter("keyword", "%" + keyWord + "%")
                .list();
        session.getTransaction().commit();

        return productsList;
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product category = (Product) session.load(Product.class, Integer.valueOf(id));
        session.getTransaction().commit();
        //logger.info("Product loaded successfully, Product details="+category);
        return category;
    }

    @Override
    public void removeProduct(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product category = (Product) session.load(Product.class, Integer.valueOf(id));

        if(null != category){
            session.delete(category);
        }
        session.getTransaction().commit();
        logger.info("Product deleted successfully, Product details="+category);
    }
}
