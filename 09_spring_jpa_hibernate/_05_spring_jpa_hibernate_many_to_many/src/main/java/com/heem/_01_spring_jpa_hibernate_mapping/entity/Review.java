package com.heem._01_spring_jpa_hibernate_mapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="review")
public class Review {

    // define fields

    // define cstr

    // define get/ set

    // define toString

    // annotate fields


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "comment")
    private String comment;



    //private Course course_id;

    public Review() {

    }

    public Review(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
