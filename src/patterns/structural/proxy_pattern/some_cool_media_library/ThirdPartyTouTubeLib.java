package patterns.structural.proxy_pattern.some_cool_media_library;

import java.util.HashMap;

public interface ThirdPartyTouTubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
