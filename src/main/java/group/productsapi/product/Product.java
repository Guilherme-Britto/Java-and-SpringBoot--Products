package group.productsapi.product;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String description;
    private Double price;
    private LocalDateTime created_at;
    private Integer code;

    public Product() {
    }

    public Product(Long id, LocalDateTime created_at, Double price, String description, Integer code) {
        this.id = id;
        this.created_at = created_at;
        this.price = price;
        this.description = description;
        this.code = code;
    }

    public Product(String description, Double price, Integer code) {
        this.description = description;
        this.price = price;
        this.code = code;
    }

    @PrePersist
    public void prePersist() {
        this.created_at = LocalDateTime.now();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", created_at=" + created_at +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", code=" + code +
                '}';
    }
}
