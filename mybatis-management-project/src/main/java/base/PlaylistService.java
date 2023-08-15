package base;

import base.dto.MemberDTO;
import base.dto.MusicDTO;
import base.dto.PlaylistDTO;
import base.dto.RoomDTO;
import base.enums.DtoEnum;
import base.handler.ObjectHandler;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PlaylistService {
    private PlaylistMapper playlistMapper;

    private void decideCommitOrRollback(SqlSession sqlSession, int ret) {
        if (ret > 0) {
            sqlSession.commit();
            return;
        }

        sqlSession.rollback();
    }

    public Object selectObject(Object object) {
        SqlSession sqlSession = Template.getSqlSession();
        playlistMapper = sqlSession.getMapper(PlaylistMapper.class);

        Object selectedObj = null;
        String selectedObjName = ObjectHandler.toObjectName(object);

        if (selectedObjName.equals(DtoEnum.PLAYLIST.toString())) {
            if (object == null)
                selectedObj = playlistMapper.selectAllPlaylist(null);
            else
                selectedObj = playlistMapper.selectAllPlaylist((Map<String, Object>)object);
        } else if (selectedObjName.equals(DtoEnum.ROOM.toString())) {
            RoomDTO room = (RoomDTO) object;
            switch (room.getCode()) {
                case -1:
                    selectedObj = playlistMapper.selectAllRoom();
                    break;
                default:
                    selectedObj = playlistMapper.selectRoomByCode(room.getCode());
                    break;
            }
        } else if (selectedObjName.equals(DtoEnum.MEMBER.toString())) {
            MemberDTO member = (MemberDTO) object;
            switch (member.getCode()) {
                case -1:
                    selectedObj = playlistMapper.selectAllMember();
                    break;
                default:
                    selectedObj = playlistMapper.selectMemberByCode(member.getCode());
                    break;
            }
        } else if (selectedObjName.equals(DtoEnum.MUSIC.toString())) {
            MusicDTO music = (MusicDTO) object;
            switch (music.getCode()) {
                case -1:
                    selectedObj = playlistMapper.selectAllMusic();
                    break;
                default:
                    selectedObj = playlistMapper.selectMusicByCode(music.getCode());
                    break;
            }
        }

        sqlSession.close();

        return selectedObj;
    }

    public boolean registObject(Object object) {
        SqlSession sqlSession = Template.getSqlSession();
        playlistMapper = sqlSession.getMapper(PlaylistMapper.class);

        String names[] = object.getClass().getName().split("Objects.");
        String selectedObjName = names[names.length - 1];
        int ret = -1;

        switch (selectedObjName) {
            case "PlaylistDTO":
                ret = playlistMapper.insertPlaylist((PlaylistDTO) object);
                break;
            case "RoomDTO":
                ret = playlistMapper.insertRoom((RoomDTO) object);
                break;
            case "MemberDTO":
                ret = playlistMapper.insertMember((MemberDTO) object);
                break;
            case "MusicDTO":
                ret = playlistMapper.insertMusic((MusicDTO) object);
                break;
        }

        decideCommitOrRollback(sqlSession, ret);

        sqlSession.close();

        return ret > 0;
    }

    public boolean modifyObject(Object object) {
        SqlSession sqlSession = Template.getSqlSession();
        playlistMapper = sqlSession.getMapper(PlaylistMapper.class);

        String names[] = object.getClass().getName().split("Objects.");
        String selectedObjName = names[names.length - 1];
        int ret = -1;

        switch (selectedObjName) {
            case "PlaylistDTO":
                //ret = playlistMapper.updatePlaylist((PlaylistDTO) object);
                break;
            case "RoomDTO":
                ret = playlistMapper.updateRoom((RoomDTO) object);
                break;
            case "MemberDTO":
                ret = playlistMapper.updateMember((MemberDTO) object);
                break;
            case "MusicDTO":
                ret = playlistMapper.updateMusic((MusicDTO) object);
                break;
        }

        decideCommitOrRollback(sqlSession, ret);

        sqlSession.close();

        return ret > 0;
    }

    public boolean deleteObject(Object object) {
        SqlSession sqlSession = Template.getSqlSession();
        playlistMapper = sqlSession.getMapper(PlaylistMapper.class);

        String names[] = object.getClass().getName().split("Objects.");
        String selectedObjName = names[names.length - 1];
        int ret = -1;

        switch (selectedObjName) {
            case "PlaylistDTO":
                // ret = playlistMapper.deletePlaylist((PlaylistDTO) object);
                break;
            case "RoomDTO":
                ret = playlistMapper.deleteRoom((RoomDTO) object);
                break;
            case "MemberDTO":
                ret = playlistMapper.deleteMember((MemberDTO) object);
                break;
            case "MusicDTO":
                ret = playlistMapper.deleteMusic((MusicDTO) object);
                break;
        }

        decideCommitOrRollback(sqlSession, ret);

        sqlSession.close();

        return ret > 0;
    }
}
