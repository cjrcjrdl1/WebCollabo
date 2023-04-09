package chosun.community.web.Register;

public class joined_member {
    String memId;
    String password;
    String name;
    joined_member(){};
    joined_member(String memId, String password, String name){
        this.memId = memId;
        this.password = password;
        this.name = name;
    };

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

