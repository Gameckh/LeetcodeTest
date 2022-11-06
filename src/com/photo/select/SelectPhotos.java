package com.photo.select;

import java.io.File;

public class SelectPhotos {

    public static final String from_path = "E:\\2022-11-6 杜陵\\ARW";
    public static final String to_path = "E:\\2022-11-6 杜陵\\xiiu";

    public static void main(String[] args) {

        File fromPath = new File(from_path);
        File toPath = new File(to_path);

        File[] arwFiles = fromPath.listFiles();
        File[] jpgFiles = toPath.listFiles();

        for (File jpg : jpgFiles) {
            String jpgName = jpg.getName();
            String photoName = jpgName.split("\\.")[0];
            for (File arw :arwFiles) {
                String arwName = arw.getName();
                String name = arwName.split("\\.")[0];
                if (name.equals(photoName)) {
                    File target = new File(toPath.getAbsolutePath() + File.separator + arwName);
                    System.out.println(target);
                    if (!arw.renameTo(target)) {
                        System.out.println(arwName + " 移动失败");
                    }
                }
            }
        }

    }
}
