package patterns.structural.proxy_pattern;

import patterns.structural.proxy_pattern.downloader.YouTubeDownloader;
import patterns.structural.proxy_pattern.proxy.YouTubeCacheProxy;
import patterns.structural.proxy_pattern.some_cool_media_library.ThirdPartyYouTubeClass;

public class Demo {
    public static void main(String[] args) {
        YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
        YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

        long naive = test(naiveDownloader);
        long smart = test(smartDownloader);
        System.out.println("Time saved by caching proxy: " + (naive - smart) + "ms");
    }

    private static long test(YouTubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        //Поведение юзера в нашем приложении
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        //Юзер может помещать одни и те же страницы достаточно часто
        downloader.renderVideoPage("catzzzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}
