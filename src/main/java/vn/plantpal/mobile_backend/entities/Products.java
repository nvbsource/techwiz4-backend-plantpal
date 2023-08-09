package vn.plantpal.mobile_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "type", nullable = true, length = 30)
    private String type;
    @OneToOne(mappedBy = "productsById")
    private Accessories accessoriesById;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<Carts> cartsById;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<OrderItems> orderItemsById;
    @OneToMany(mappedBy = "productsByProductId_0")
    private Collection<OrderItems> orderItemsById_0;
    @OneToOne(mappedBy = "productsById")
    private Plants plantsById;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<Stocks> stocksById;
    @OneToMany(mappedBy = "productsByProductId_0")
    private Collection<Stocks> stocksById_0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(id, products.id) && Objects.equals(type, products.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public Accessories getAccessoriesById() {
        return accessoriesById;
    }

    public void setAccessoriesById(Accessories accessoriesById) {
        this.accessoriesById = accessoriesById;
    }

    public Collection<Carts> getCartsById() {
        return cartsById;
    }

    public void setCartsById(Collection<Carts> cartsById) {
        this.cartsById = cartsById;
    }

    public Collection<OrderItems> getOrderItemsById() {
        return orderItemsById;
    }

    public void setOrderItemsById(Collection<OrderItems> orderItemsById) {
        this.orderItemsById = orderItemsById;
    }

    public Collection<OrderItems> getOrderItemsById_0() {
        return orderItemsById_0;
    }

    public void setOrderItemsById_0(Collection<OrderItems> orderItemsById_0) {
        this.orderItemsById_0 = orderItemsById_0;
    }

    public Plants getPlantsById() {
        return plantsById;
    }

    public void setPlantsById(Plants plantsById) {
        this.plantsById = plantsById;
    }

    public Collection<Stocks> getStocksById() {
        return stocksById;
    }

    public void setStocksById(Collection<Stocks> stocksById) {
        this.stocksById = stocksById;
    }

    public Collection<Stocks> getStocksById_0() {
        return stocksById_0;
    }

    public void setStocksById_0(Collection<Stocks> stocksById_0) {
        this.stocksById_0 = stocksById_0;
    }
}
