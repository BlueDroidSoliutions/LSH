package com.livesexhouse.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SaveVideoFile {

    public boolean rename(String pthPics, String pthClip, String name, int id) {

        

        String idS = Integer.toString(id);

        boolean renameClip = true;
        boolean renamePics = true;
        boolean renameAll = false;

        try {
            File oldFileClip = new File(pthClip + name + ".mp4");
            File newFileClip = new File(pthClip + idS + ".mp4");
            renameClip = oldFileClip.renameTo(newFileClip);
        } catch (Exception e) {
        }

        if (renameClip) {
            for (int i = 1; i <= 5; i++) {
                if (renamePics) {

                    try {
                        File oldFilePics = new File(pthPics + name + i + ".jpg");
                        File newFilePics = new File(pthPics + idS + "_" + i + ".jpg");
                        renamePics = oldFilePics.renameTo(newFilePics);
                    } catch (Exception ex) {
                    }

                    renameAll = true;
                } else {
                    renameAll = false;
                }
            }
        }

        return renameAll;
    }

    public boolean save(byte[] bytes, String pt) {
        boolean succesSave = true;
        try {
            Path path = Paths.get(pt);
            Files.write(path, bytes);
        } catch (IOException e) {
            succesSave = false;
        }
        return succesSave;
    }

    public void deletePics(ArrayList<String> files, String pthDir) {

        try {

            for (String s : files) {

                for (int i = 1; i <= 5; i++) {
                    File file = new File(pthDir + s + i + ".jpg");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                }
            }

        } catch (Exception e) {
        }

    }

    public void deleteFile(ArrayList<String> files, String pthDir) {
        try {

            for (String s : files) {
                File file = new File(pthDir + s + ".mp4");
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
        }

    }

}
