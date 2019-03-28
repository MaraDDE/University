package src;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "advisor", schema = "university", catalog = "")
public class AdvisorEntity {
    private String sId;
    private String iId;

    @Id
    @Column(name = "s_ID")
    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "i_ID")
    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdvisorEntity that = (AdvisorEntity) o;
        return Objects.equals(sId, that.sId) &&
                Objects.equals(iId, that.iId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, iId);
    }
}
