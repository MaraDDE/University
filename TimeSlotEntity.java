package src;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "time_slot", schema = "university", catalog = "")
@IdClass(TimeSlotEntityPK.class)
public class TimeSlotEntity {
    private String timeSlotId;
    private String day;
    private BigInteger startHr;
    private BigInteger startMin;
    private BigInteger endHr;
    private BigInteger endMin;
    private SectionEntity section;
    @Id
    @Column(name = "time_slot_id")
    public String getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(String timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    @Id
    @Column(name = "day")
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Id
    @Column(name = "start_hr")
    public BigInteger getStartHr() {
        return startHr;
    }

    public void setStartHr(BigInteger startHr) {
        this.startHr = startHr;
    }

    @Id
    @Column(name = "start_min")
    public BigInteger getStartMin() {
        return startMin;
    }

    public void setStartMin(BigInteger startMin) {
        this.startMin = startMin;
    }

    @Basic
    @Column(name = "end_hr")
    public BigInteger getEndHr() {
        return endHr;
    }

    public void setEndHr(BigInteger endHr) {
        this.endHr = endHr;
    }

    @Basic
    @Column(name = "end_min")
    public BigInteger getEndMin() {
        return endMin;
    }

    public void setEndMin(BigInteger endMin) {
        this.endMin = endMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlotEntity that = (TimeSlotEntity) o;
        return Objects.equals(timeSlotId, that.timeSlotId) &&
                Objects.equals(day, that.day) &&
                Objects.equals(startHr, that.startHr) &&
                Objects.equals(startMin, that.startMin) &&
                Objects.equals(endHr, that.endHr) &&
                Objects.equals(endMin, that.endMin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeSlotId, day, startHr, startMin, endHr, endMin);
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "time_slot_id", referencedColumnName = "time_slot_id", nullable = false, insertable=false, updatable=false), @JoinColumn(name = "day", referencedColumnName = "day", nullable = false, insertable=false, updatable=false), @JoinColumn(name = "start_hr", referencedColumnName = "start_hr", nullable = false, insertable=false, updatable=false), @JoinColumn(name = "start_min", referencedColumnName = "start_min", nullable = false, insertable=false, updatable=false)})
    public SectionEntity getSection() {
        return section;
    }

    public void setSection(SectionEntity section) {
        this.section = section;
    }
}
