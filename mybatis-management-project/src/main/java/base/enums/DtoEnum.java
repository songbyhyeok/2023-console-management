package base.enums;

public enum DtoEnum {
    PLAYLIST{
        @Override
        public String toString() {
            return "PlaylistDTO";
        }
    },
    ROOM {
        @Override
        public String toString() {
            return "RoomDTO";
        }
    },
    MEMBER{
        @Override
        public String toString() {
            return "MemberDTO";
        }
    },
    MUSIC{
        @Override
        public String toString() {
            return "MusicDTO";
        }
    },
    END
}
