package src;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "classroom", schema = "university", catalog = "")
@IdClass(ClassroomEntityPK.class)
public class ClassroomEntity {
    private String building;
    private String roomNumber;
    private Integer capacity;
    private Collection<SectionEntity> sections;

    @Id
    @Column(name = "building")
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Id
    @Column(name = "room_number")
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomEntity that = (ClassroomEntity) o;
        return Objects.equals(building, that.building) &&
                Objects.equals(roomNumber, that.roomNumber) &&
                Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, roomNumber, capacity);
    }

    @OneToMany(mappedBy = "classroom")
    public Collection<SectionEntity> getSections() {
        return sections;
    }

    public void setSections(Collection<SectionEntity> sections) {
        this.sections = sections;
    }
}
