package springboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "organization")
public class Organization {

    /*
    Org_id
    Org_Name
    owner_id
    Description
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private int id;
    @Column
    private String name;
    @Column
    private int owner_id;
    @Column
    private String description;

    public Organization(int id, String name, int owner_id, String description) {
        this.id = id;
        this.name = name;
        this.owner_id = owner_id;
        this.description = description;
    }

    public Organization() {

    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner_id='" + owner_id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
