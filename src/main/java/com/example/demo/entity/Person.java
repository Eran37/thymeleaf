package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "person", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name", "last_name"})
})
public class Person {
}
