package hu.me.iit.gyak.gyak.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Licit {

    private Integer licit;
    private Integer userid;
    @Id
    @GeneratedValue
    private Long id;

    public Licit(int licit, int userId) {
        super();
        this.licit=licit;
        this.userid =userId;
    }

    public int getLicit() {
        return licit;
    }

    public void setLicit(int licit) {
        this.licit = licit;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
