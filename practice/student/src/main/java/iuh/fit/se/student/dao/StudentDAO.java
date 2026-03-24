package iuh.fit.se.student.dao;

import iuh.fit.se.student.model.Student;
import iuh.fit.se.student.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class StudentDAO {
    public List<Student> getAllStudent() {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        try {
            String sql = "SELECT s FROM Student s";
            TypedQuery<Student> query = em.createQuery(sql, Student.class);
            List<Student> list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
        return null;

    }
    public void addStudent(Student student) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();

            System.out.println(">>> ĐANG PERSIST");

            em.persist(student);

            System.out.println(">>> ĐÃ PERSIST");

            em.getTransaction().commit();

            System.out.println(">>> ĐÃ COMMIT");

        } catch (Exception e) {
            em.getTransaction().rollback(); // 🔥 thêm dòng này
            throw new RuntimeException(e);  // 🔥 QUAN TRỌNG
        }finally {
            em.close();
        }
    }
    public void updateStudent(Student student) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
    public void deleteStudent(int id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        try {
            em.getTransaction().begin();
            Student student1 = em.find(Student.class, id);
            if(student1 != null)
                em.remove(student1);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
    public Student getStudentId(int id) {
        EntityManager em = JpaUtil.getEmf().createEntityManager();
        try {
            return em.find(Student.class, id);
        }finally {
            em.close();
        }
    }
}
