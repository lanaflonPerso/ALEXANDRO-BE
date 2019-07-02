package com.jle.alexandro.models.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "shipping_method", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class ShippingMethodEntity {
    private Integer idShippingMethod;
    private String description;
    private BigDecimal charges;
    private Set<OrderHeaderEntity> orderHeadersByIdShippingMethod;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shipping_method", nullable = false)
    public Integer getIdShippingMethod() {
        return idShippingMethod;
    }

    public void setIdShippingMethod(Integer idShippingMethod) {
        this.idShippingMethod = idShippingMethod;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "charges", nullable = false, precision = 4)
    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingMethodEntity that = (ShippingMethodEntity) o;
        return Objects.equals(idShippingMethod, that.idShippingMethod) &&
                Objects.equals(description, that.description) &&
                Objects.equals(charges, that.charges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idShippingMethod, description, charges);
    }

    @OneToMany(mappedBy = "shippingMethodByShippingMethodId")
    public Set<OrderHeaderEntity> getOrderHeadersByIdShippingMethod() {
        return orderHeadersByIdShippingMethod;
    }

    public void setOrderHeadersByIdShippingMethod(Set<OrderHeaderEntity> orderHeadersByIdShippingMethod) {
        this.orderHeadersByIdShippingMethod = orderHeadersByIdShippingMethod;
    }
}
