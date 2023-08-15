package base;

import base.dto.MemberDTO;
import base.dto.MusicDTO;
import base.dto.PlaylistDTO;
import base.dto.RoomDTO;

import java.util.List;
import java.util.Map;

public interface PlaylistMapper {
    List<PlaylistDTO> selectAllPlaylist(Map<String, Object> criteria);
    List<RoomDTO> selectAllRoom();
    RoomDTO selectRoomByCode(int code);
    List<MemberDTO> selectAllMember();
    MemberDTO selectMemberByCode(int code);
    List<MusicDTO> selectAllMusic();
    MusicDTO selectMusicByCode(int code);

    int insertPlaylist(PlaylistDTO playlist);
    int insertRoom(RoomDTO room);
    int insertMember(MemberDTO member);
    int insertMusic(MusicDTO music);

    int updatePlaylist(PlaylistDTO playlist);
    int updateRoom(RoomDTO room);
    int updateMember(MemberDTO member);
    int updateMusic(MusicDTO music);

    int deletePlaylist(PlaylistDTO playlist);
    int deleteRoom(RoomDTO room);
    int deleteMember(MemberDTO member);
    int deleteMusic(MusicDTO music);
}
