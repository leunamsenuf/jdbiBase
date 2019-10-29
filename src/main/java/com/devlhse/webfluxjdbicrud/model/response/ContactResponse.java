package com.devlhse.webfluxjdbicrud.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactResponse {

    private Long id;
    private String name;
    private String email;
    private Long phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ContactResponse(Builder builder) {
        id = builder.id;
        name = builder.name;
        email = builder.email;
        phone = builder.phone;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "ContactResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String name;
        private String email;
        private Long phone;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

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

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder updatedAt(LocalDateTime val) {
            updatedAt = val;
            return this;
        }

        public ContactResponse build() {
            return new ContactResponse(this);
        }
    }
}
