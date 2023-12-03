package com.contact.manager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private Long age;

    @Column(name="created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    List<Expense> expenseList;

}