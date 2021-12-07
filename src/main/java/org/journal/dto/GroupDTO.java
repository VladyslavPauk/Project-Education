package org.journal.dto;


import java.util.Set;

public class GroupDTO {

    private int id;
    private String name;
    private Set<StudentDTO> studentSet;
    private TeacherDTO teacher;
    private Set<LessonDTO> lessonSet;


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

    public Set<StudentDTO> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<StudentDTO> studentSet) {
        this.studentSet = studentSet;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public Set<LessonDTO> getLessonSet() {
        return lessonSet;
    }

    public void setLessonSet(Set<LessonDTO> lessonSet) {
        this.lessonSet = lessonSet;
    }
}
