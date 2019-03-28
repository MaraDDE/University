package src;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "university", catalog = "")
public class StudentEntity {
    private String id;
    private String name;
    private String deptName;
    private Integer totCred;
    private DepartmentEntity departmentByDeptName;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "tot_cred")
    public Integer getTotCred() {
        return totCred;
    }

    public void setTotCred(Integer totCred) {
        this.totCred = totCred;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(totCred, that.totCred);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deptName, totCred);
    }

    @ManyToOne
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name", insertable = false, updatable = false)
    public DepartmentEntity getDepartmentByDeptName() {
        return departmentByDeptName;
    }

    public void setDepartmentByDeptName(DepartmentEntity departmentByDeptName) {
        this.departmentByDeptName = departmentByDeptName;
    }
    // 1
    @Override
    public String toString() {
        return
                "Name = " + name + '\t' +
                        "Department = " + deptName + '\t' +
                        "Credits = " + totCred;
    }

}
