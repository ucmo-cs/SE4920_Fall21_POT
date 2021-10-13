package springboot.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "org_user")
public class Org_User implements Serializable {

    /*
    Id : int unique identifier
    Id : int unique user
     */

    @Id
    private int org_id;
    @Id
    private int user_id;

    public Org_User(int orgId, int userId) {
        this.org_id = orgId;
        this.user_id = userId;
    }

    public Org_User() {

    }

    @Override
    public String toString() {
        return "Org_User{" +
                "orgId=" + org_id +
                ", userId='" + user_id + '\'' +
                '}';
    }

    public int getOrgId() {
        return org_id;
    }

    public void setOrgId(int orgId) {
        this.org_id = orgId;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

}