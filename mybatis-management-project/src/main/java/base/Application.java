package base;

public class Application {
    private static final PlaylistManager PLAYLIST_MANAGER = new PlaylistManager();;

    public static void main(String[] args) {
        PLAYLIST_MANAGER.run();
    }
}