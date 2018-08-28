package com.example.data.playground.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@org.springframework.data.mongodb.core.mapping.Document(collection = "mydata")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "mydata", type = "students")
public class Student {
    @Id
    private Long id;

    private String name;

    private String address;

    private Integer rank;

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.rank = builder.rank;
    }

    public Student() {
    }

    public static Builder newStudent() {
        return new Builder();
    }


    public static final class Builder {
        private Long id;
        private String name;
        private String address;
        private Integer rank;

        private Builder() {
        }

        public Student build() {
            return new Student(this);
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder rank(Integer rank) {
            this.rank = rank;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rank=" + rank +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
