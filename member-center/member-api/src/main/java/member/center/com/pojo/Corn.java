package member.center.com.pojo;


public class Corn {
    private Integer  id;
    private String userCode;
    private String CornCode;

    public Integer getId() {
        return id;
    }

    public Corn setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public Corn setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public String getCornCode() {
        return CornCode;
    }

    public Corn setCornCode(String cornCode) {
        CornCode = cornCode;
        return this;
    }
}
