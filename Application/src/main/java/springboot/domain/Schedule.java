package springboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule implements Comparable {

    /*
    Id : int
    User_id
    Start_time
    End_time
    Description:
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private int id;
    @Column
    private int user_id;
    @Column
    private String start_time;
    @Column
    private String end_time;
    @Column
    private String description;

    public Schedule() {

    }

    public Schedule(int id, int user_id, String start_time, String end_time, String description) {
        this.id = id;
        this.user_id = user_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Schedule){
            Schedule s = (Schedule) o;
            int comp = s.start_time.compareTo(this.start_time);
            if(comp<0){
                return -1;
            }
            else if(comp>0){
                return 1;
            }
            else return 0;
        }
        return -1;
    }
}
