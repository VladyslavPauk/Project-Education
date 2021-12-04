package org.journal.dto;

import org.journal.model.Grade;
import org.journal.model.Group;
import org.journal.model.Teacher;
import java.util.Set;

public class LessonDTO {

    private int id;
    private String name;
    private Group group;
    private Teacher teacher;
    private Set<Grade> gradeSet;


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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Grade> getGradeSet() {
        return gradeSet;
    }

    public void setGradeSet(Set<Grade> gradeSet) {
        this.gradeSet = gradeSet;
    }
}
