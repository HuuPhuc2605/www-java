package iuh.fit.se.productscrud.dao;

import iuh.fit.se.productscrud.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class GenericDAO<T> {
    private Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }
    public void save(T entity){
        EntityManager em = (EntityManager) JpaUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void delete(int id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            em.getTransaction().begin();

            T entity = em.find(type, id);
            if (entity != null) em.remove(entity);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public T findById(int id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();

        try {
            return em.find(type, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return null;
    }
}
