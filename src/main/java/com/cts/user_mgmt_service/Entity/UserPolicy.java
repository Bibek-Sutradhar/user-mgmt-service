package com.cts.user_mgmt_service.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="USER_POLICY")
public class UserPolicy {

    @Id
    @Column(name = "POLICY_ID")
    private Integer policyId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "USER_ID")
    private Users users;

    @Column(name="POLICY_NAME")
    private String policyName;

    @Column(name="AMOUNT_PAID")
    private Integer amtPaid;

    @Column(name="POLICY_END_DATE")
    private String policyEndDate;

    @Column(name="VALID")
    private String valid;

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public Integer getAmtPaid() {
        return amtPaid;
    }

    public void setAmtPaid(Integer amtPaid) {
        this.amtPaid = amtPaid;
    }

    public String getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
