package base;

import base.dto.MemberDTO;
import base.dto.MusicDTO;
import base.dto.PlaylistDTO;
import base.enums.DtoEnum;
import base.handler.ObjectHandler;
import base.print.PrintResult;
import base.dto.RoomDTO;

import java.util.List;
import java.util.Map;

public class PlaylistController {
    private final PlaylistService playlistService;
    private final PrintResult printResult;

    PlaylistController() {
        playlistService = new PlaylistService();
        printResult = new PrintResult();
    }

    private void select(Object object) {
        Object selectedObj = playlistService.selectObject(object);
        if (selectedObj == null) {
            printResult.checkResultCode(false, "select");
            return;
        }

        String selectedDtoName = ObjectHandler.toObjectName(object);
        String selectedObjName = ObjectHandler.toObjectName(selectedObj);

        if (selectedDtoName.equals(DtoEnum.PLAYLIST.toString())) {
            List<PlaylistDTO> playlist = (List<PlaylistDTO>) selectedObj;
            playlist.forEach(System.out::println);
        } else if (selectedDtoName.equals(DtoEnum.ROOM.toString())) {
            if (selectedObjName.equals("ArrayList")) {
                List<RoomDTO> roomList = (List<RoomDTO>) selectedObj;
                roomList.forEach(System.out::println);
            } else {
                RoomDTO room = (RoomDTO) selectedObj;
                System.out.println(room);
            }
        } else if (selectedDtoName.equals(DtoEnum.MEMBER.toString())) {
            if (selectedObjName.equals("ArrayList")) {
                List<MemberDTO> memberList = (List<MemberDTO>) selectedObj;
                memberList.forEach(System.out::println);
            } else {
                MemberDTO member = (MemberDTO) selectedObj;
                System.out.println(member);
            }
        } else if (selectedDtoName.equals(DtoEnum.MUSIC.toString())) {
            if (selectedObjName.equals("ArrayList")) {
                List<MusicDTO> musicList = (List<MusicDTO>) selectedObj;
                musicList.forEach(System.out::println);
            } else {
                MusicDTO music = (MusicDTO) selectedObj;
                System.out.println(music);
            }
        }
    }

    public void selectPlaylist(Map<String, Object> parameter) {
        select(parameter);
    }

    public void selectRoom(Map<String, String> parameter) {
        RoomDTO room = null;
        String code = parameter.get("code");

        room = (code == null) ? new RoomDTO(-1) : new RoomDTO(Integer.parseInt(parameter.get("code")));
        select(room);
    }

    public void selectMember(Map<String, String> parameter) {
        MemberDTO member = null;
        String code = parameter.get("code");

        member = (code == null) ? new MemberDTO(-1) : new MemberDTO(Integer.parseInt(parameter.get("code")));
        select(member);
    }

    public void selectMusic(Map<String, String> parameter) {
        MusicDTO music = null;
        String code = parameter.get("code");

        music = (code == null) ? new MusicDTO(-1) : new MusicDTO(Integer.parseInt(parameter.get("code")));
        select(music);
    }

    private void regist(Object object) {
        boolean isSuccess = playlistService.registObject(object);
        printResult.checkResultCode(isSuccess, "insert");
    }

    public void registPlaylist(Map<String, String> parameter) {
//        String title = parameter.get("title");
//        String description = parameter.get("description");
//        regist(new PlaylistDTO(title, description));
    }

    public void registRoom(Map<String, String> parameter) {
        String title = parameter.get("title");
        String description = parameter.get("description");
//        int memberCode = Integer.parseInt(parameter.get("memberCode"));
//        regist(new RoomDTO(title, description, memberCode));
    }

    public void registMember(Map<String, String> parameter) {
        String name = parameter.get("name");
        String nickname = parameter.get("nickname");
        regist(new MemberDTO(name, nickname));
    }

    public void registMusic(Map<String, String> parameter) {
        String title = parameter.get("title");
        String artist = parameter.get("artist");
        String album = parameter.get("album");
        String composer = parameter.get("composer");
        regist(new MusicDTO(title, artist, album, composer));
    }

    private void modify(Object object) {
        boolean isSuccess = playlistService.modifyObject(object);
        printResult.checkResultCode(isSuccess, "update");
    }

    public void modifyPlaylist(Map<String, String> parameter) {
//        String title = parameter.get("title");
//        String description = parameter.get("description");
//        modify(new PlaylistDTO(Integer.parseInt(parameter.get("code")), title, description));
    }

    public void modifyRoom(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String title = parameter.get("title");
        String description = parameter.get("description");
//        int memberCode = Integer.parseInt(parameter.get("memberCode"));
//        modify(new RoomDTO(code, title, description, memberCode));
    }

    public void modifyMember(Map<String, String> parameter) {
        String name = parameter.get("name");
        String nickname = parameter.get("nickname");
        modify(new MemberDTO(Integer.parseInt(parameter.get("code")), name, nickname));
    }

    public void modifyMusic(Map<String, String> parameter) {
        String title = parameter.get("title");
        String artist = parameter.get("artist");
        String album = parameter.get("album");
        String composer = parameter.get("composer");
        modify(new MusicDTO(Integer.parseInt(parameter.get("code")), title, artist, album, composer));
    }

    private void delete(Object object) {
        boolean isSuccess = playlistService.deleteObject(object);
        printResult.checkResultCode(isSuccess, "delete");
    }

    public void deletePlaylist(Map<String, String> parameter) {
//        delete(new PlaylistDTO(Integer.parseInt(parameter.get("code"))));
    }

    public void deleteRoom(Map<String, String> parameter) {
        delete(new RoomDTO(Integer.parseInt(parameter.get("code"))));
    }

    public void deleteMember(Map<String, String> parameter) {
        delete(new MemberDTO(Integer.parseInt(parameter.get("code"))));
    }

    public void deleteMusic(Map<String, String> parameter) {
        delete(new MusicDTO(Integer.parseInt(parameter.get("code"))));
    }
}
