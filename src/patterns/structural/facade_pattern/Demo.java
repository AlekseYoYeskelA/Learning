package patterns.structural.facade_pattern;

import patterns.structural.facade_pattern.facade.VideoConversionFacade;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("yputubevideo.ogg", "mp4");
    }
}
