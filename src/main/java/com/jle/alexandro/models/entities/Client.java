package com.jle.alexandro.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Objects;
import java.util.Set;

@Entity
public class Client {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private Title titleByTitleId;
    private Address addressByInvoiceAddressId;
    private Address addressByDeliveryAddressId;
    private PaymentMethod paymentMethodByPaymentMethodId;
    @JsonIgnore
    private Set<OrderHeader> orderHeadersById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 255)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NaturalId
    @Email(message = "Email should be valid")
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(email, client.email) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, phone, password);
    }

    @ManyToOne
    @JoinColumn(name = "title_id", referencedColumnName = "id", nullable = false)
    public Title getTitleByTitleId() {
        return titleByTitleId;
    }

    public void setTitleByTitleId(Title titleByTitleId) {
        this.titleByTitleId = titleByTitleId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_address_id", referencedColumnName = "id", nullable = false)
    public Address getAddressByInvoiceAddressId() {
        return addressByInvoiceAddressId;
    }

    public void setAddressByInvoiceAddressId(Address addressByInvoiceAddressId) {
        this.addressByInvoiceAddressId = addressByInvoiceAddressId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_address_id", referencedColumnName = "id", nullable = false)
    public Address getAddressByDeliveryAddressId() {
        return addressByDeliveryAddressId;
    }

    public void setAddressByDeliveryAddressId(Address addressByDeliveryAddressId) {
        this.addressByDeliveryAddressId = addressByDeliveryAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id", nullable = false)
    public PaymentMethod getPaymentMethodByPaymentMethodId() {
        return paymentMethodByPaymentMethodId;
    }

    public void setPaymentMethodByPaymentMethodId(PaymentMethod paymentMethodByPaymentMethodId) {
        this.paymentMethodByPaymentMethodId = paymentMethodByPaymentMethodId;
    }

    @OneToMany(mappedBy = "clientByClientId", cascade = CascadeType.REMOVE)
    public Set<OrderHeader> getOrderHeadersById() {
        return orderHeadersById;
    }

    public void setOrderHeadersById(Set<OrderHeader> orderHeadersById) {
        this.orderHeadersById = orderHeadersById;
    }
}
