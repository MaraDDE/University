package src;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "section", schema = "university", catalog = "")
@IdClass(SectionEntityPK.class)
public class SectionEntity {
    private String courseId;
    private String secId;
    private String semester;
    private int year;
    private String building;
    private String roomNumber;
    private String timeSlotId;
    private CourseEntity courseByCourseId;
    private ClassroomEntity classroom;
    private Collection<TakesEntity> takes;
    private Collection<TeachesEntity> teaches;

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

    @Basic
    @Column(name = "building")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Basic
    @Column(name = "room_number")
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "time_slot_id")
    public String getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(String timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionEntity that = (SectionEntity) o;
        return year == that.year &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(secId, that.secId) &&
                Objects.equals(semester, that.semester) &&
                Objects.equals(building, that.building) &&
                Objects.equals(roomNumber, that.roomNumber) &&
                Objects.equals(timeSlotId, that.timeSlotId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, secId, semester, year, building, roomNumber, timeSlotId);
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
    @JoinColumns({@JoinColumn(name = "building", referencedColumnName = "building", insertable=false, updatable=false), @JoinColumn(name = "room_number", referencedColumnName = "room_number", insertable=false, updatable=false)})
    public ClassroomEntity getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomEntity classroom) {
        this.classroom = classroom;
    }

    @OneToMany(mappedBy = "section")
    public Collection<TakesEntity> getTakes() {
        return takes;
    }

    public void setTakes(Collection<TakesEntity> takes) {
        this.takes = takes;
    }

    @OneToMany(mappedBy = "section")
    public Collection<TeachesEntity> getTeaches() {
        return teaches;
    }

    public void setTeaches(Collection<TeachesEntity> teaches) {
        this.teaches = teaches;
    }
}
