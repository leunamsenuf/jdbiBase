package com.devlhse.webfluxjdbicrud.model;


public class Contact {

    private Long id;
    private String name;
    private String email;
    private Long phone;

    private Contact(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setEmail(builder.email);
        setPhone(builder.phone);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private String email;
        private Long phone;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder phone(Long val) {
            phone = val;
            return this;
        }


        public Contact build() {
            return new Contact(this);
        }
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
