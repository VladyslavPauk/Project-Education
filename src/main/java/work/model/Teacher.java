package work.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String password;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Subgroup> subgroupList;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Lesson> lessonList;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Grade> gradeList;

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

    public List<Subgroup> getSubgroupList() {
        return subgroupList;
    }

    public void setSubgroupList(List<Subgroup> subgroupList) {
        this.subgroupList = subgroupList;
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }
}
