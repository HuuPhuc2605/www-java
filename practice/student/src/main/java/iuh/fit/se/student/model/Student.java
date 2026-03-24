package iuh.fit.se.student.model;

import jakarta.persistence.*;

@Table(name="student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private boolean gender;
    private String image;

    public Student() {
    }

    public Student(int id, String name, int age, boolean gender, String image) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.image = image;
    }

    public Student(String name, int age, boolean gender, String image) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
