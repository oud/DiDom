package com.didom.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.didom.myapp.domain.enumeration.PaymentType;

import com.didom.myapp.domain.enumeration.ProposalStatus;

/**
 * A Proposal.
 */
@Entity
@Table(name = "proposal")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "proposal")
public class Proposal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "proposal_time", nullable = false)
    private ZonedDateTime proposalTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @NotNull
    @Column(name = "payment_amount", precision=10, scale=2, nullable = false)
    private BigDecimal paymentAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "current_proposal_status", nullable = false)
    private ProposalStatus currentProposalStatus;

    @Column(name = "client_grade")
    private Integer clientGrade;

    @Column(name = "client_comment")
    private String clientComment;

    @Column(name = "freelance_grade")
    private Integer freelanceGrade;

    @Column(name = "freelance_comment")
    private String freelanceComment;

    @ManyToOne
    private Job job;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "proposal")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Message> messages = new HashSet<>();

    @OneToMany(mappedBy = "proposal")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Contract> contracts = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getProposalTime() {
        return proposalTime;
    }

    public Proposal proposalTime(ZonedDateTime proposalTime) {
        this.proposalTime = proposalTime;
        return this;
    }

    public void setProposalTime(ZonedDateTime proposalTime) {
        this.proposalTime = proposalTime;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public Proposal paymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public Proposal paymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
        return this;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public ProposalStatus getCurrentProposalStatus() {
        return currentProposalStatus;
    }

    public Proposal currentProposalStatus(ProposalStatus currentProposalStatus) {
        this.currentProposalStatus = currentProposalStatus;
        return this;
    }

    public void setCurrentProposalStatus(ProposalStatus currentProposalStatus) {
        this.currentProposalStatus = currentProposalStatus;
    }

    public Integer getClientGrade() {
        return clientGrade;
    }

    public Proposal clientGrade(Integer clientGrade) {
        this.clientGrade = clientGrade;
        return this;
    }

    public void setClientGrade(Integer clientGrade) {
        this.clientGrade = clientGrade;
    }

    public String getClientComment() {
        return clientComment;
    }

    public Proposal clientComment(String clientComment) {
        this.clientComment = clientComment;
        return this;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    public Integer getFreelanceGrade() {
        return freelanceGrade;
    }

    public Proposal freelanceGrade(Integer freelanceGrade) {
        this.freelanceGrade = freelanceGrade;
        return this;
    }

    public void setFreelanceGrade(Integer freelanceGrade) {
        this.freelanceGrade = freelanceGrade;
    }

    public String getFreelanceComment() {
        return freelanceComment;
    }

    public Proposal freelanceComment(String freelanceComment) {
        this.freelanceComment = freelanceComment;
        return this;
    }

    public void setFreelanceComment(String freelanceComment) {
        this.freelanceComment = freelanceComment;
    }

    public Job getJob() {
        return job;
    }

    public Proposal job(Job job) {
        this.job = job;
        return this;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public User getUser() {
        return user;
    }

    public Proposal user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public Proposal messages(Set<Message> messages) {
        this.messages = messages;
        return this;
    }

    public Proposal addMessage(Message message) {
        this.messages.add(message);
        message.setProposal(this);
        return this;
    }

    public Proposal removeMessage(Message message) {
        this.messages.remove(message);
        message.setProposal(null);
        return this;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public Proposal contracts(Set<Contract> contracts) {
        this.contracts = contracts;
        return this;
    }

    public Proposal addContract(Contract contract) {
        this.contracts.add(contract);
        contract.setProposal(this);
        return this;
    }

    public Proposal removeContract(Contract contract) {
        this.contracts.remove(contract);
        contract.setProposal(null);
        return this;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Proposal proposal = (Proposal) o;
        if (proposal.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), proposal.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Proposal{" +
            "id=" + getId() +
            ", proposalTime='" + getProposalTime() + "'" +
            ", paymentType='" + getPaymentType() + "'" +
            ", paymentAmount='" + getPaymentAmount() + "'" +
            ", currentProposalStatus='" + getCurrentProposalStatus() + "'" +
            ", clientGrade='" + getClientGrade() + "'" +
            ", clientComment='" + getClientComment() + "'" +
            ", freelanceGrade='" + getFreelanceGrade() + "'" +
            ", freelanceComment='" + getFreelanceComment() + "'" +
            "}";
    }
}
