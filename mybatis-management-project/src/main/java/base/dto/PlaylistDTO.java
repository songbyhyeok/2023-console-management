package base.dto;

import java.util.List;

public class PlaylistDTO {
    private RoomDTO room;
    private List<MusicDTO> musicList;

    public PlaylistDTO() {}

    public PlaylistDTO(int roomCode) {
        room = new RoomDTO(roomCode);
    }

    public PlaylistDTO(RoomDTO room, List<MusicDTO> musicList) {
        this.room = room;
        this.musicList = musicList;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

    public List<MusicDTO> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<MusicDTO> musicList) {
        this.musicList = musicList;
    }

    @Override
    public String toString() {
        return "PlaylistDTO{" +
                "room=" + room +
                ", musicList=" + musicList +
                '}';
    }
}
