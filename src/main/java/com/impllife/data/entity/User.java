package com.impllife.data.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "il_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String name;
    private String phone;
    private String email;

    private Date dateCreate;
    private Date dateLastUpdateData;

    private boolean twoFactorAuthTypeEnable;
    private TwoFactorAuthType twoFactorAuthType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> addresses = new LinkedHashSet<>();

    //region get set

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateLastUpdateData() {
        return dateLastUpdateData;
    }

    public void setDateLastUpdateData(Date dateLastUpdateData) {
        this.dateLastUpdateData = dateLastUpdateData;
    }

    public boolean isTwoFactorAuthTypeEnable() {
        return twoFactorAuthTypeEnable;
    }

    public void setTwoFactorAuthTypeEnable(boolean twoFactorAuthTypeEnable) {
        this.twoFactorAuthTypeEnable = twoFactorAuthTypeEnable;
    }

    public TwoFactorAuthType getTwoFactorAuthType() {
        return twoFactorAuthType;
    }

    public void setTwoFactorAuthType(TwoFactorAuthType twoFactorAuthType) {
        this.twoFactorAuthType = twoFactorAuthType;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isTwoFactorAuthTypeEnable() != user.isTwoFactorAuthTypeEnable()) return false;
        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getPhone() != null ? !getPhone().equals(user.getPhone()) : user.getPhone() != null) return false;
        if (getDateCreate() != null ? !getDateCreate().equals(user.getDateCreate()) : user.getDateCreate() != null)
            return false;
        if (getDateLastUpdateData() != null ? !getDateLastUpdateData().equals(user.getDateLastUpdateData()) : user.getDateLastUpdateData() != null)
            return false;
        if (getTwoFactorAuthType() != user.getTwoFactorAuthType()) return false;
        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) : user.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(user.getLastName()) : user.getLastName() != null)
            return false;
        return getAddresses() != null ? getAddresses().equals(user.getAddresses()) : user.getAddresses() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getDateCreate() != null ? getDateCreate().hashCode() : 0);
        result = 31 * result + (getDateLastUpdateData() != null ? getDateLastUpdateData().hashCode() : 0);
        result = 31 * result + (isTwoFactorAuthTypeEnable() ? 1 : 0);
        result = 31 * result + (getTwoFactorAuthType() != null ? getTwoFactorAuthType().hashCode() : 0);
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getAddresses() != null ? getAddresses().hashCode() : 0);
        return result;
    }
}
