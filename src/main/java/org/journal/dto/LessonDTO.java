package org.journal.dto;

import java.util.Set;

public class LessonDTO {

    private int id;
    private String name;
    private GroupDTO group;
    private TeacherDTO teacher;
    private Set<GradeDTO> gradeSet;


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

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public Set<GradeDTO> getGradeSet() {
        return gradeSet;
    }

    public void setGradeSet(Set<GradeDTO> gradeSet) {
        this.gradeSet = gradeSet;
    }
}
