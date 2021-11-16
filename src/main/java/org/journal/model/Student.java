package org.journal.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String surname;

    @ManyToOne
    @JoinColumn(name = "subgroup_id")
    private Subgroup subgroup;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private Set<Grade> gradeSet;

    @Override
    public String toString() {
        return " " + name + " " + surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Subgroup getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Subgroup subgroup) {
        this.subgroup = subgroup;
    }

    public Set<Grade> getGradeSet() {
        return gradeSet;
    }

    public void setGradeSet(Set<Grade> gradeSet) {
        this.gradeSet = gradeSet;
    }
}
