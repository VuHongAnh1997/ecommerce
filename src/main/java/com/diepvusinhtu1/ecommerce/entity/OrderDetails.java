package com.diepvusinhtu1.ecommerce.entity;

import lombok.*;

import javax.persistence.*;
import java.math.*;

@Entity
@Table(name = "order_details")
@Data
@NoArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Product.class, cascade = CascadeType.ALL)
    private Product product;

    @Column
    private BigDecimal price;

    @Column
    private Integer num;

    @Column(name = "total_money")
    private Integer totalMoney;

    public OrderDetails() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }
}
