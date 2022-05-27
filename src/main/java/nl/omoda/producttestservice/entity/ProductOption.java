package nl.omoda.producttestservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Long colorId;
    private String name;

    protected ProductOption() {}

    public ProductOption(Long id, Long productId, Long colorId, String name) {
        this.id = id;
        this.productId = productId;
        this.colorId = colorId;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getColorId() {
        return this.colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductOption productId(Long productId) {
        setProductId(productId);
        return this;
    }

    public ProductOption colorId(Long colorId) {
        setColorId(colorId);
        return this;
    }

    public ProductOption name(String name) {
        setName(name);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", productId='" + getProductId() + "'" +
                ", colorId='" + getColorId() + "'" +
                ", name='" + getName() + "'" +
                "}";
    }
}
