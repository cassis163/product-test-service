package nl.omoda.producttestservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "colorId")
    private Color color;

    private String name;

    protected ProductOption() {
    }

    public ProductOption(Product product, Color color, String name) {
        this.product = product;
        this.color = color;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", product='" + getProduct() + "'" +
            ", color='" + getColor() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }

    public Long getId() {
        return this.id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
