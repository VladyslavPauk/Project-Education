package org.journal.service;

import org.journal.model.Lesson;
import org.journal.model.Student;

public interface GradeService {
    void addGrade(Student student, Lesson lesson, int gradeValue);
}
