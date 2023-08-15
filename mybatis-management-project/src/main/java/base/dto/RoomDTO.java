package base.dto;

public class RoomDTO {
    private int code;
    private String title;
    private String description;
    private MemberDTO member;

    public RoomDTO() {}

    public RoomDTO(int code) {
        this.code = code;
    }

    public RoomDTO(String title, String description, MemberDTO member) {
        this.title = title;
        this.description = description;
        this.member = member;
    }

    public RoomDTO(int code, String title, String description, MemberDTO member) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.member = member;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", member=" + member +
                '}';
    }
}
