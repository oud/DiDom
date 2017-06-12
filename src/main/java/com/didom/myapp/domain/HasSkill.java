package com.didom.myapp.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.didom.myapp.domain.enumeration.PaymentType;

/**
 * A HasSkill.
 */
@Entity
@Table(name = "has_skill")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "hasskill")
public class HasSkill implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @NotNull
    @Column(name = "payment_amont", precision=10, scale=2, nullable = false)
    private BigDecimal paymentAmont;

    @ManyToOne
    private User user;

    @ManyToOne
    private Skill skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public HasSkill paymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPaymentAmont() {
        return paymentAmont;
    }

    public HasSkill paymentAmont(BigDecimal paymentAmont) {
        this.paymentAmont = paymentAmont;
        return this;
    }

    public void setPaymentAmont(BigDecimal paymentAmont) {
        this.paymentAmont = paymentAmont;
    }

    public User getUser() {
        return user;
    }

    public HasSkill user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public HasSkill skill(Skill skill) {
        this.skill = skill;
        return this;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HasSkill hasSkill = (HasSkill) o;
        if (hasSkill.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), hasSkill.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HasSkill{" +
            "id=" + getId() +
            ", paymentType='" + getPaymentType() + "'" +
            ", paymentAmont='" + getPaymentAmont() + "'" +
            "}";
    }
}
