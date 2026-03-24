package iuh.fit.se.productmvc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;

    @Column(name = "unit_in_stock")
    private int unitInStock;

    @Column(name = "url_image")
    private String urlImage;

    public Product() {}

    public Product(String name, double price, int unitInStock, String urlImage) {
        this.name = name;
        this.price = price;
        this.unitInStock = unitInStock;
        this.urlImage = urlImage;
    }

    public Product(int id, String name, double price, int unitInStock, String urlImage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unitInStock = unitInStock;
        this.urlImage = urlImage;
    }

    // getter setter
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getUnitInStock() { return unitInStock; }
    public String getUrlImage() { return urlImage; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setUnitInStock(int unitInStock) { this.unitInStock = unitInStock; }
    public void setUrlImage(String urlImage) { this.urlImage = urlImage; }
}