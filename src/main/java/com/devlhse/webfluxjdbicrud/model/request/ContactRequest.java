package com.devlhse.webfluxjdbicrud.model.request;

import javax.validation.constraints.NotNull;

public class ContactRequest {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private Long phone;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "ContactRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
