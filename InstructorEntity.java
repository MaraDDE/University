package src;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "instructor", schema = "university", catalog = "")
public class InstructorEntity {
    private String id;
    private String name;
    private String deptName;
    private BigDecimal salary;
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
    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorEntity that = (InstructorEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, deptName, salary);
    }

    @ManyToOne
    @JoinColumn(name = "dept_name", referencedColumnName = "dept_name", insertable=false, updatable=false)
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
                "ID = " + id + '\t' +
                        "Name = " + name + '\t' +
                        "Department = " + deptName + '\t' +
                        "Salary = " + salary;
    }
}
