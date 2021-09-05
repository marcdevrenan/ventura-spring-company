package br.edu.infnet.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;
    private String city;
    private String contractPlan;
    private Integer userId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Requirement> requirementList;

    public Job() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContractPlan() {
        return contractPlan;
    }

    public void setContractPlan(String contractPlan) {
        this.contractPlan = contractPlan;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Requirement> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<Requirement> requirementList) {
        this.requirementList = requirementList;
    }
}
