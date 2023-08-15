package base.dto;

public class MemberDTO {
    private int code;
    private String name;
    private String nickname;

    public MemberDTO(){}

    public MemberDTO(int code) {
        this.code = code;
    }

    public MemberDTO(String name, String nickname) {
        this.name = name;
        this.nickname = nickname;
    }

    public MemberDTO(int code, String name, String nickname) {
        this.code = code;
        this.name = name;
        this.nickname = nickname;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
