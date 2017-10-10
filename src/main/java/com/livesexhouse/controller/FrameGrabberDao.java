package com.livesexhouse.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

/**
 *
 * @author roller
 */
public class FrameGrabberDao {

    public Object[] grab(String videoLocation, String imgSaveLocation) {
        Boolean b = true;
        int count = 1;
        Double timeSec = 0.0;
        try {

            FrameGrabber frameGrabber = new FFmpegFrameGrabber(videoLocation);

            Frame frame = new Frame();

            Java2DFrameConverter j2fc = new Java2DFrameConverter();
            BufferedImage bi;

            File f;
            frameGrabber.start();
            int max = frameGrabber.getLengthInFrames();
            int part = 4;
            int step = max / part;
            double frameRate = frameGrabber.getFrameRate();

            timeSec = max / frameRate;

            boolean next = false;

            for (int i = 1; i < frameGrabber.getLengthInFrames(); i++) {
                frame = frameGrabber.grab();

                if (i == 1 || i == step || i == step * 2 || i == step * 3 || i == step * 4 - 30 || next) {

                    bi = j2fc.getBufferedImage(frame);

                    f = new File(imgSaveLocation + count + ".jpg");
                    if (bi != null) {
                        bi = Thumbnails.of(bi).size(400, 266).asBufferedImage();
                        ImageIO.write(bi, "jpg", f);
                        next = false;
                        count++;
                    } else {
                        next = true;
                    }
                }

            }

            frameGrabber.flush();

        } catch (IOException e) {
            b = false;
        }

        if (count != 6) {
            b = false;
        }
        return new Object[]{b, timeSec};
    }

}
