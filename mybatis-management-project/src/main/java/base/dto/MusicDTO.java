package base.dto;

public class MusicDTO {
    private int code;
    private String title;
    private String artist;
    private String album;
    private String composer;

    public MusicDTO() {}

    public MusicDTO(int code) {
        this.code = code;
    }

    public MusicDTO(String title, String artist, String album, String composer) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.composer = composer;
    }

    public MusicDTO(int code, String title, String artist, String album, String composer) {
        this.code = code;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.composer = composer;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    @Override
    public String toString() {
        return "MusicDTO{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", composer='" + composer + '\'' +
                '}';
    }
}
