package patterns.structural.proxy_pattern.some_cool_media_library;

import java.util.HashMap;

public class ThirdPartyYouTubeClass implements ThirdPartyTouTubeLib {
    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    //Фейковые методы, симулирующие сетевую активность. Они медленные, как в реальной жизни

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.println("Connected!" + "\n");
    }

    private HashMap<String, Video> getRandomVideos() {
        System.out.print("Downloading populars... ");
        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<>();
        hmap.put("catzzzzzzzzz", new Video("asdafafasf", "Catzzzz.avi"));
        hmap.put("aopycixovhpv", new Video("lajgba9asd", "Dogs play with ball.mp4"));
        hmap.put("mmsncdj777sa", new Video("lllollllol", "Dancing video.mpq"));
        hmap.put("rtyoweiooen1", new Video("asznbsqi37", "Barcelona vs RealM.mov"));
        hmap.put("vienuuufq43s", new Video("pqowuvfyxi", "Java lesson#1.avi"));

        System.out.println("Done!" + "\n");
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        experienceNetworkLatency();
        Video video = new Video(videoId, "Some video title");

        System.out.println("Done!" + "\n");
        return video;
    }
}
