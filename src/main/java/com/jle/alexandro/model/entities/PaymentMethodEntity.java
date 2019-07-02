package com.jle.alexandro.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "payment_method", schema = "dbo", catalog = "DB_ALEXANDRIA")
public class PaymentMethodEntity {
    private Integer idPaymentMethod;
    private String description;
    private Set<ClientEntity> clientsByIdPaymentMethod;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_method", nullable = false)
    public Integer getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(Integer idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethodEntity that = (PaymentMethodEntity) o;
        return Objects.equals(idPaymentMethod, that.idPaymentMethod) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaymentMethod, description);
    }

    @JsonBackReference
    @OneToMany(mappedBy = "paymentMethodByPaymentMethodId")
    public Set<ClientEntity> getClientsByIdPaymentMethod() {
        return clientsByIdPaymentMethod;
    }

    public void setClientsByIdPaymentMethod(Set<ClientEntity> clientsByIdPaymentMethod) {
        this.clientsByIdPaymentMethod = clientsByIdPaymentMethod;
    }
}
