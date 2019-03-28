package src;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PrereqEntityPK implements Serializable {
    private String courseId;
    private String prereqId;

    @Column(name = "course_id")
    @Id
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Column(name = "prereq_id")
    @Id
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
        PrereqEntityPK that = (PrereqEntityPK) o;
        return Objects.equals(courseId, that.courseId) &&
                Objects.equals(prereqId, that.prereqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, prereqId);
    }
}
