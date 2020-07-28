package member.provider.designpattern;

public enum ChannelEnum {

    BD("BD","backDook"),
    BK("BK","blackEnemy"),
    GGL("GGL","givenGreenLight");



    private String code;
    private String  name;

    ChannelEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public ChannelEnum setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public ChannelEnum setName(String name) {
        this.name = name;
        return this;
    }
}
