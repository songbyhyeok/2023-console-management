package base;

import base.enums.DmlEnum;
import base.enums.DtoEnum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlaylistManager {

    private final PlaylistController playlistCtr;
    private final Map<String, String> parameter;
    private final Scanner sc;

    PlaylistManager() {
        playlistCtr = new PlaylistController();
        parameter = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void run() {
        controlAllFunctions();
    }

    private Map<String, Object> searchSpecificConditions() {
        Map<String, Object> criteria = new HashMap<>(5);

        System.out.println("검색 조건을 입력하세요.");
        System.out.println("1. 재생목록 번호 기준");
        System.out.println("2. 회원명 기준");
        System.out.println("3. 아티스트/음악 기준");
        int n = sc.nextInt();
        sc.nextLine();

        switch (n) {
            case 1: {
                System.out.println("재생목록 번호 입력하세요.");
                int roomCode = sc.nextInt();
                sc.nextLine();

                System.out.println("추가적으로 검색할 수 있는 옵션입니다.");
                System.out.println("1. 가수 기준");
                System.out.println("2. 제목 기준");
                System.out.println("3. 넘어가기");
                int conditionN = sc.nextInt();
                sc.nextLine();

                String musicInfo = "";
                switch (conditionN) {
                    case 1:
                        System.out.println("가수명 입력하세요.");
                        musicInfo = sc.nextLine();
                        break;
                    case 2:
                        System.out.println("음악 제목 입력하세요.");
                        musicInfo = sc.nextLine();
                        break;
                }

                criteria.put("roomCode", roomCode);
                if (conditionN != 3) {
                    criteria.put("conditionN", conditionN);
                    criteria.put("musicInfo", musicInfo);
                }
            }
                break;
            case 2: {
                System.out.println("1. 회원명 입력하세요.");
                String memberName = sc.nextLine();

                System.out.println("추가적으로 검색할 수 있는 옵션입니다.");
                System.out.println("1. 방 번호 옵션");
                System.out.println("2. 넘어가기");
                int conditionN = sc.nextInt();
                sc.nextLine();

                String roomInfo = "";
                switch (conditionN) {
                    case 1:
                        System.out.println("1. Between");
                        System.out.println("2. 특정 방 번호");
                        int roomMode = sc.nextInt();
                        sc.nextLine();

                        criteria.put("roomMode", roomMode);

                        switch (roomMode) {
                            case 1:
                                System.out.println("최소값 입력");
                                int minVal = sc.nextInt();
                                sc.nextLine();
                                criteria.put("minVal", minVal);

                                System.out.println("최대값 입력");
                                int maxVal = sc.nextInt();
                                sc.nextLine();
                                criteria.put("maxVal", maxVal);
                                break;
                            case 2:
                                System.out.println("방 번호 입력하세요.");
                                roomInfo = sc.nextLine();
                                criteria.put("roomInfo", roomInfo);
                                break;
                        }

                        break;
                }

                criteria.put("memberName", memberName);
            }
                break;
            case 3: {
                System.out.println("음악명 입력하세요.");
                String musicTitle = sc.nextLine();
                criteria.put("musicTitle", musicTitle);

                System.out.println("추가적으로 검색할 수 있는 옵션입니다.");
                System.out.println("1. 회원명 기준");
                System.out.println("2. 넘어가기");
                int conditionN = sc.nextInt();
                sc.nextLine();

                switch (conditionN) {
                    case 1:
                        System.out.println("회원명 입력하세요.");
                        String memberName2 = sc.nextLine();
                        criteria.put("memberName2", memberName2);
                        break;
                }
            }

                break;
        }

        return criteria;
    }

    private boolean inputCode() {
        System.out.println("3. 뒤로가기");

        boolean isExit = false;
        int inputted = sc.nextInt();
        sc.nextLine();

        switch (inputted) {
            case 2:
                System.out.println("검색 코드 입력");
                parameter.put("code", sc.nextLine());
                break;
            case 3:
                isExit = true;
                break;
        }

        return isExit;
    }

    private void displayFunctionsRelatedToSelection() {
        while (true) {
            parameter.clear();

            System.out.println("-------- 테이블 조회창 --------");
            System.out.println("1. 재생목록 조회 기능 사용");
            System.out.println("2. 방 조회 기능 사용");
            System.out.println("3. 회원 조회 기능 사용");
            System.out.println("4. 음악 조회 기능 사용");
            System.out.println("5. 뒤로 가기");

            int inputted = sc.nextInt() - 1;
            sc.nextLine();
            switch (DtoEnum.values()[inputted]) {
                case PLAYLIST:
                    System.out.println("1. 재생목록 전체 조회");
                    System.out.println("2. 재생목록 조건 조회");
                    System.out.println("3. 뒤로가기");

                    switch (sc.nextInt()) {
                        case 1:
                            playlistCtr.selectPlaylist(null);
                            break;
                        case 2:
                            playlistCtr.selectPlaylist(searchSpecificConditions());
                            break;
                    }

                    break;
                case ROOM:
                    System.out.println("1. 방 전체 조회");
                    System.out.println("2. 방 코드로 조회");

                    if (!inputCode())
                        playlistCtr.selectRoom(parameter);

                    break;
                case MEMBER:
                    System.out.println("1. 멤버 전체 조회");
                    System.out.println("2. 멤버 코드로 조회");

                    if (!inputCode())
                        playlistCtr.selectMember(parameter);

                    break;
                case MUSIC:
                    System.out.println("1. 음악 전체 조회");
                    System.out.println("2. 음악 코드로 조회");

                    if (!inputCode())
                        playlistCtr.selectMusic(parameter);

                    break;
                default:
                    controlAllFunctions();
                    break;
            }
        }
    }

    private void displayInsertFunctions() {
        while (true) {
            parameter.clear();

            System.out.println("-------- 테이블 삽입창 --------");
            System.out.println("1. 재생목록 추가 (수정중)");
            System.out.println("2. 방 추가");
            System.out.println("3. 회원 추가");
            System.out.println("4. 음악 추가");
            System.out.println("5. 뒤로 가기");

            int inputted = sc.nextInt() - 1;
            sc.nextLine();

            switch (DtoEnum.values()[inputted]) {
                case PLAYLIST:
//                    System.out.println("재생목록 제목을 입력하세요.");
//                    String title = sc.nextLine();
//                    System.out.println("재생목록 설명을 입력하세요.");
//                    String description = sc.nextLine();
//
//                    parameter.put("title", title);
//                    parameter.put("description", description);
//                    playlistCtr.registPlaylist(parameter);
                    break;
                case ROOM:
                    System.out.println("방 제목 입력하세요.");
                    String title = sc.nextLine();
                    System.out.println("방 설명 입력하세요.");
                    String description = sc.nextLine();
                    System.out.println("회원 번호 입력하세요.");
                    String memberCode = sc.nextLine();

                    parameter.put("title", title);
                    parameter.put("description", description);
                    parameter.put("memberCode", memberCode);
                    playlistCtr.registRoom(parameter);
                    break;
                case MEMBER:
                    System.out.println("회원 이름 입력하세요.");
                    String name = sc.nextLine();
                    System.out.println("회원 닉네임 입력하세요.");
                    String nickname = sc.nextLine();

                    parameter.put("name", name);
                    parameter.put("nickname", nickname);
                    playlistCtr.registMember(parameter);
                    break;
                case MUSIC:
                    System.out.println("아티스트 입력하세요.");
                    String artist = sc.nextLine();
                    System.out.println("앨범명 입력하세요.");
                    String albumName = sc.nextLine();
                    System.out.println("작곡가 입력하세요.");
                    String composer = sc.nextLine();

                    parameter.put("artist", artist);
                    parameter.put("album", albumName);
                    parameter.put("composer", composer);
                    playlistCtr.registMusic(parameter);
                    break;
                default:
                    controlAllFunctions();
                    break;
            }
        }
    }

    private void displayUpdateFunctions() {
        while (true) {
            parameter.clear();

            System.out.println("-------- 테이블 갱신창 --------");
            System.out.println("1. 재생목록 갱신 (수정중)");
            System.out.println("2. 방 갱신");
            System.out.println("3. 회원 갱신");
            System.out.println("4. 음악 갱신");
            System.out.println("5. 뒤로 가기");

            int inputted = sc.nextInt() - 1;
            sc.nextLine();

            switch (DtoEnum.values()[inputted]) {
                case PLAYLIST: {
//                    System.out.println("수정할 재생목록 코드를 입력하세요.");
//                    String playlistCode = sc.nextLine();
//                    System.out.println("수정할 재생목록 제목을 입력하세요.");
//                    String title = sc.nextLine();
//                    System.out.println("수정할 재생목록 설명을 입력하세요.");
//                    String description = sc.nextLine();
//
//                    parameter.put("code", playlistCode);
//                    parameter.put("title", title);
//                    parameter.put("description", description);
//                    playlistCtr.modifyPlaylist(parameter);
                }
                    break;
                case ROOM: {
                    System.out.println("수정할 방 코드를 입력하세요.");
                    String code = sc.nextLine();
                    System.out.println("수정할 방 제목 입력하세요.");
                    String title = sc.nextLine();
                    System.out.println("수정할 방 설명 입력하세요.");
                    String description = sc.nextLine();
                    System.out.println("수정할 회원 번호 입력하세요.");
                    String memberCode = sc.nextLine();

                    parameter.put("code", code);
                    parameter.put("title", title);
                    parameter.put("description", description);
                    parameter.put("memberCode", memberCode);
                    playlistCtr.modifyRoom(parameter);
                }
                    break;
                case MEMBER: {
                    System.out.println("수정할 회원 코드를 입력하세요.");
                    String memberCode = sc.nextLine();
                    System.out.println("수정할 회원 이름 입력하세요.");
                    String name = sc.nextLine();
                    System.out.println("수정할 회원 닉네임 입력하세요.");
                    String nickname = sc.nextLine();

                    parameter.put("code", memberCode);
                    parameter.put("name", name);
                    parameter.put("nickname", nickname);
                    playlistCtr.modifyMember(parameter);
                }
                    break;
                case MUSIC: {
                    System.out.println("수정할 아티스트 코드를 입력하세요.");
                    String musicCode = sc.nextLine();
                    System.out.println("수정할 아티스트 입력하세요.");
                    String artist = sc.nextLine();
                    System.out.println("수정할 앨범명 입력하세요.");
                    String albumName = sc.nextLine();
                    System.out.println("수정할 작곡가 입력하세요.");
                    String composer = sc.nextLine();

                    parameter.put("code", musicCode);
                    parameter.put("artist", artist);
                    parameter.put("album", albumName);
                    parameter.put("composer", composer);
                    playlistCtr.modifyMusic(parameter);
                }
                    break;
                default:
                    controlAllFunctions();
                    break;
            }
        }
    }

    private void displayDeleteFunctions() {
        while (true) {
            parameter.clear();

            System.out.println("-------- 테이블 갱신창 --------");
            System.out.println("1. 재생목록 삭제 (수정중)");
            System.out.println("2. 방 삭제");
            System.out.println("3. 회원 삭제");
            System.out.println("4. 음악 삭제");
            System.out.println("5. 뒤로 가기");

            int inputted = sc.nextInt() - 1;
            sc.nextLine();

            switch (DtoEnum.values()[inputted]) {
                case PLAYLIST:
//                    System.out.println("삭제할 재생목록 코드를 입력하세요.");
//                    parameter.put("code", sc.nextLine());
//                    playlistCtr.deletePlaylist(parameter);
                    break;
                case ROOM:
                    System.out.println("삭제할 방 코드를 입력하세요.");
                    parameter.put("code", sc.nextLine());
                    playlistCtr.deleteRoom(parameter);
                    break;
                case MEMBER:
                    System.out.println("삭제할 회원 코드를 입력하세요.");
                    parameter.put("code", sc.nextLine());
                    playlistCtr.deleteMember(parameter);
                    break;
                case MUSIC:
                    System.out.println("삭제할 음악 코드를 입력하세요.");
                    parameter.put("code", sc.nextLine());
                    playlistCtr.deleteMusic(parameter);
                    break;
                default:
                    controlAllFunctions();
                    break;
            }
        }
    }

    private void controlAllFunctions() {
        do {
            System.out.println("☆★☆★☆★☆★ 플레이리스트 프로그램 관리창 ☆★☆★☆★");
            System.out.println("1. 조회");
            System.out.println("2. 추가");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");

            int inputted = sc.nextInt() - 1;
            sc.nextLine();

            switch (DmlEnum.values()[inputted]) {
                case SELECT:
                    displayFunctionsRelatedToSelection();
                    break;
                case INSERT:
                    displayInsertFunctions();
                    break;
                case UPDATE:
                    displayUpdateFunctions();
                    break;
                case DELETE:
                    displayDeleteFunctions();
                    break;
                case END:
                    System.out.println("프로그램 종료합니다.");
                    return;
                default:
                    System.out.println("재입력 바랍니다.");
                    break;
            }

        } while (true);
    }

}
