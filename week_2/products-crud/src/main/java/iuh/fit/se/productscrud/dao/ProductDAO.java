package iuh.fit.se.productscrud.dao;

import iuh.fit.se.productscrud.model.Product;
import iuh.fit.se.productscrud.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

/**
 * Admin
 **/
public class ProductDAO extends GenericDAO<Product> {

    public ProductDAO() {
        super(Product.class);
    }

    // ================== LIST ==================
    public List<Product> selectAllProducts() {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            String jpql = """
                    SELECT p FROM Product p
                    """;

            TypedQuery<Product> query =
                    em.createQuery(jpql, Product.class);

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }

    // ================== INSERT ==================
    public void insertProduct(Product product) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // ================== UPDATE ==================
    public void updateProduct(Product newProduct) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            Product product =
                    em.find(Product.class, newProduct.getId());

            if (product != null) {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                product.setUrl_image(newProduct.getUrl_image());
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // ================== DELETE ==================
    public void deleteProduct(int id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            Product product = em.find(Product.class, id);
            if (product != null)
                em.remove(product);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
