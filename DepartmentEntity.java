package src;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "department", schema = "university", catalog = "")
public class DepartmentEntity {
    private String deptName;
    private String building;
    private BigDecimal budget;
    private Collection<CourseEntity> coursesByDeptName;
    private Collection<InstructorEntity> instructorsByDeptName;
    private Collection<StudentEntity> studentsByDeptName;

    @Id
    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "building")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "budget")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(deptName, that.deptName) &&
                Objects.equals(building, that.building) &&
                Objects.equals(budget, that.budget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptName, building, budget);
    }

    @OneToMany(mappedBy = "departmentByDeptName")
    public Collection<CourseEntity> getCoursesByDeptName() {
        return coursesByDeptName;
    }

    public void setCoursesByDeptName(Collection<CourseEntity> coursesByDeptName) {
        this.coursesByDeptName = coursesByDeptName;
    }

    @OneToMany(mappedBy = "departmentByDeptName")
    public Collection<InstructorEntity> getInstructorsByDeptName() {
        return instructorsByDeptName;
    }

    public void setInstructorsByDeptName(Collection<InstructorEntity> instructorsByDeptName) {
        this.instructorsByDeptName = instructorsByDeptName;
    }

    @OneToMany(mappedBy = "departmentByDeptName")
    public Collection<StudentEntity> getStudentsByDeptName() {
        return studentsByDeptName;
    }

    public void setStudentsByDeptName(Collection<StudentEntity> studentsByDeptName) {
        this.studentsByDeptName = studentsByDeptName;
    }
    // 1
    @Override
    public String toString() {
        return
                "Name = " + deptName + '\t' +
                        "Building = " + building + '\t' +
                        "Budget = " + budget;
    }
}
