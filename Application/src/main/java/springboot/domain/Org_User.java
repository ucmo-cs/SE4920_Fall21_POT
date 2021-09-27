package springboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "org_user")
public class Org_User {
    /*

    Id : int unique identifier
    Id : int unique user

     */

    @Id
    private int orgId;
    @Id
    private int userId;

    public Org_User(int orgId, int userId) {
        this.orgId = orgId;
        this.userId = userId;
    }

    public Org_User() {

    }

    @Override
    public String toString() {
        return "Org_User{" +
                "orgId=" + orgId +
                ", userId='" + userId + '\'' +
                '}';
    }

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}