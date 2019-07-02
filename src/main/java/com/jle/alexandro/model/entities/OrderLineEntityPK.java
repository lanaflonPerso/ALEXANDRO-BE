package com.jle.alexandro.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderLineEntityPK implements Serializable {
    private Integer orderHeaderId;
    private Integer productId;

    @Column(name = "order_header_id", nullable = false)
    @Id
    public Integer getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(Integer orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    @Column(name = "product_id", nullable = false)
    @Id
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineEntityPK that = (OrderLineEntityPK) o;
        return Objects.equals(orderHeaderId, that.orderHeaderId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderHeaderId, productId);
    }
}
