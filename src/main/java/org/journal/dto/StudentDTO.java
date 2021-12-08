package org.journal.dto;


import java.util.Set;

public class StudentDTO {

    private int id;
    private String name;
    private String password;
    private String email;
    private String surname;
    private GroupDTO group;
    private Set<GradeDTO> gradeSet;

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

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public Set<GradeDTO> getGradeSet() {
        return gradeSet;
    }

    public void setGradeSet(Set<GradeDTO> gradeSet) {
        this.gradeSet = gradeSet;
    }
}
