package src;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class TimeSlotEntityPK implements Serializable {
    private String timeSlotId;
    private String day;
    private BigInteger startHr;
    private BigInteger startMin;

    @Column(name = "time_slot_id")
    @Id
    public String getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(String timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    @Column(name = "day")
    @Id
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Column(name = "start_hr")
    @Id
    public BigInteger getStartHr() {
        return startHr;
    }

    public void setStartHr(BigInteger startHr) {
        this.startHr = startHr;
    }

    @Column(name = "start_min")
    @Id
    public BigInteger getStartMin() {
        return startMin;
    }

    public void setStartMin(BigInteger startMin) {
        this.startMin = startMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlotEntityPK that = (TimeSlotEntityPK) o;
        return Objects.equals(timeSlotId, that.timeSlotId) &&
                Objects.equals(day, that.day) &&
                Objects.equals(startHr, that.startHr) &&
                Objects.equals(startMin, that.startMin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeSlotId, day, startHr, startMin);
    }
}
