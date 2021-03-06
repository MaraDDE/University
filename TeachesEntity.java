package src;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teaches", schema = "university", catalog = "")
@IdClass(TeachesEntityPK.class)
public class TeachesEntity {
    private String id;
    private String courseId;
    private String secId;
    private String semester;
    private int year;
    private SectionEntity section;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "course_id")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "sec_id")
    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    @Id
    @Column(name = "semester")
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Id
    @Column(name = "year")
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
        TeachesEntity that = (TeachesEntity) o;
        return year == that.year &&
                Objects.equals(id, that.id) &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(secId, that.secId) &&
                Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, secId, semester, year);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable=false, updatable=false), @JoinColumn(name = "sec_id", referencedColumnName = "sec_id", nullable = false, insertable=false, updatable=false), @JoinColumn(name = "semester", referencedColumnName = "semester", nullable = false, insertable=false, updatable=false), @JoinColumn(name = "year", referencedColumnName = "year", nullable = false, insertable=false, updatable=false)})
    public SectionEntity getSection() {
        return section;
    }

    public void setSection(SectionEntity section) {
        this.section = section;
    }
}
