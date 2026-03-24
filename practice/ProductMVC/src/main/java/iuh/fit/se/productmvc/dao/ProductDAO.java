package iuh.fit.se.productmvc.dao;

import iuh.fit.se.productmvc.model.Product;
import iuh.fit.se.productmvc.util.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDAO {

    // READ ALL
    public List<Product> getAllProducts() {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = "SELECT p FROM Product p";
            TypedQuery<Product> query = em.createQuery(jpql, Product.class);

            List<Product> list = query.getResultList();
            System.out.println("SIZE JPA = " + list.size());

            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    // INSERT
    public void insertProduct(Product p) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // DELETE
    public void deleteProduct(int id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            Product p = em.find(Product.class, id);
            if (p != null) {
                em.remove(p);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // FIND BY ID
    public Product getProductById(int id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    // UPDATE
    public void updateProduct(Product p) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}