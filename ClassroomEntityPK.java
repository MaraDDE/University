package src;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClassroomEntityPK implements Serializable {
    private String building;
    private String roomNumber;

    @Column(name = "building")
    @Id
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Column(name = "room_number")
    @Id
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomEntityPK that = (ClassroomEntityPK) o;
        return Objects.equals(building, that.building) &&
                Objects.equals(roomNumber, that.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, roomNumber);
    }
}
