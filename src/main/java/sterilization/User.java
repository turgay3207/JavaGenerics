package sterilization;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;

    private String name;

    private String tc_no;

    public User(Long id, String name, String tc_no) {
        this.id = id;
        this.name = name;
        this.tc_no = tc_no;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTc_no() {
        return tc_no;
    }

    public void setTc_no(String tc_no) {
        this.tc_no = tc_no;
    }

}
