package iuh.fit.se.productmvc.util;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("my-pu");

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}