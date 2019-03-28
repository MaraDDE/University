package src;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SectionEntityPK implements Serializable {
    private String courseId;
    private String secId;
    private String semester;
    private int year;

    @Column(name = "course_id")
    @Id
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "sec_id")
    @Id
    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    @Column(name = "semester")
    @Id
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Column(name = "year")
    @Id
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionEntityPK that = (SectionEntityPK) o;
        return year == that.year &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(secId, that.secId) &&
                Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, secId, semester, year);
    }
}
