package org.journal.dto;


import java.util.List;
import java.util.Set;

public class TeacherDTO {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Set<GroupDTO> groupSet;
    private List<LessonDTO> lessonList;
    private List<GradeDTO> gradeList;


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<GroupDTO> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<GroupDTO> groupSet) {
        this.groupSet = groupSet;
    }

    public List<LessonDTO> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<LessonDTO> lessonList) {
        this.lessonList = lessonList;
    }

    public List<GradeDTO> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<GradeDTO> gradeList) {
        this.gradeList = gradeList;
    }
}
