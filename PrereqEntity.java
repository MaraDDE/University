package src;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "prereq", schema = "university", catalog = "")
@IdClass(PrereqEntityPK.class)
public class PrereqEntity {
    private String courseId;
    private String prereqId;
    private CourseEntity courseByCourseId;
    private CourseEntity courseByPrereqId;

    @Id
    @Column(name = "course_id")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "prereq_id")
    public String getPrereqId() {
        return prereqId;
    }

    public void setPrereqId(String prereqId) {
        this.prereqId = prereqId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrereqEntity that = (PrereqEntity) o;
        return Objects.equals(courseId, that.courseId) &&
                Objects.equals(prereqId, that.prereqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, prereqId);
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable=false, updatable=false)
    public CourseEntity getCourseByCourseId() {
        return courseByCourseId;
    }

    public void setCourseByCourseId(CourseEntity courseByCourseId) {
        this.courseByCourseId = courseByCourseId;
    }

    @ManyToOne
    @JoinColumn(name = "prereq_id", referencedColumnName = "prereq_id", nullable = false, insertable=false, updatable=false)
    public CourseEntity getCourseByPrereqId() {
        return courseByPrereqId;
    }

    public void setCourseByPrereqId(CourseEntity courseByPrereqId) {
        this.courseByPrereqId = courseByPrereqId;
    }
}
