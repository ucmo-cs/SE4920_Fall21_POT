package springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "supervisor_subordinate")
public class Supervisor_Subordinate implements Serializable {

    /*
    Id : int supervisor_id
    Id : int subordinate_id
     */

    @Id
    private int supervisor_id;
    @Id
    private int subordinate_id;

    public Supervisor_Subordinate(int supervisor_id, int subordinate_id) {
        this.supervisor_id = supervisor_id;
        this.subordinate_id = subordinate_id;
    }

    public Supervisor_Subordinate() {

    }

    @Override
    public String toString() {
        return "Supervisor_Subordinate{" +
                "supervisor_id=" + supervisor_id +
                ", subordinate_id='" + subordinate_id + '\'' +
                '}';
    }

    public int getSupervisorId() {
        return supervisor_id;
    }

    public void setSupervisorId(int supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public int getSubordinateId() {
        return subordinate_id;
    }

    public void SetSubordinateId(int subordinate_id) {
        this.subordinate_id = subordinate_id;
    }

}