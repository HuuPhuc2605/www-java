package iuh.fit.se.accountapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("my-pu");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Không cần insert gì cũng được
        // Chỉ cần chạy là Hibernate tạo bảng

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Done!");
    }
}