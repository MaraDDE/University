package src;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "university", catalog = "")
public class CourseEntity {
    private String courseId;
    private String title;
    private String deptName;
    private BigInteger credits;
    private DepartmentEntity departmentByDeptName;
    private Collection<PrereqEntity> prereqsByCourseId;
    private Collection<PrereqEntity> prereqsByCourseId_0;
    private Collection<SectionEntity> sectionsByCourseId;

    @Id
    @Column(name = "course_id")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "dept_name")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "credits")
    public BigInteger getCredits() {
        return credits;
    }

    public void setCredits(BigInteger credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(courseId, that.courseId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(credits, that.credits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, title, deptName, credits);
    }

    @ManyToOne
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name", insertable=false, updatable=false)
    public DepartmentEntity getDepartmentByDeptName() {
        return departmentByDeptName;
    }

    public void setDepartmentByDeptName(DepartmentEntity departmentByDeptName) {
        this.departmentByDeptName = departmentByDeptName;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<PrereqEntity> getPrereqsByCourseId() {
        return prereqsByCourseId;
    }

    public void setPrereqsByCourseId(Collection<PrereqEntity> prereqsByCourseId) {
        this.prereqsByCourseId = prereqsByCourseId;
    }

    @OneToMany(mappedBy = "courseByPrereqId")
    public Collection<PrereqEntity> getPrereqsByCourseId_0() {
        return prereqsByCourseId_0;
    }

    public void setPrereqsByCourseId_0(Collection<PrereqEntity> prereqsByCourseId_0) {
        this.prereqsByCourseId_0 = prereqsByCourseId_0;
    }

    @OneToMany(mappedBy = "courseByCourseId")
    public Collection<SectionEntity> getSectionsByCourseId() {
        return sectionsByCourseId;
    }

    public void setSectionsByCourseId(Collection<SectionEntity> sectionsByCourseId) {
        this.sectionsByCourseId = sectionsByCourseId;
    }
}
