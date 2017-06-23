package com.didom.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import com.didom.myapp.domain.enumeration.Duration;

/**
 * A Job.
 */
@Entity
@Table(name = "job")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration")
    private Duration duration;

    @NotNull
    @Size(max = 200)
    @Lob
    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @ManyToOne
    private Skill mainSkill;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Proposal> proposals = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Job title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Job startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public Job duration(Duration duration) {
        this.duration = duration;
        return this;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public Job description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Skill getMainSkill() {
        return mainSkill;
    }

    public Job mainSkill(Skill skill) {
        this.mainSkill = skill;
        return this;
    }

    public void setMainSkill(Skill skill) {
        this.mainSkill = skill;
    }

    public User getUser() {
        return user;
    }

    public Job user(User user) {
        this.user = user;
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Proposal> getProposals() {
        return proposals;
    }

    public Job proposals(Set<Proposal> proposals) {
        this.proposals = proposals;
        return this;
    }

    public Job addProposal(Proposal proposal) {
        this.proposals.add(proposal);
        proposal.setJob(this);
        return this;
    }

    public Job removeProposal(Proposal proposal) {
        this.proposals.remove(proposal);
        proposal.setJob(null);
        return this;
    }

    public void setProposals(Set<Proposal> proposals) {
        this.proposals = proposals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Job job = (Job) o;
        if (job.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), job.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Job{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", duration='" + getDuration() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
