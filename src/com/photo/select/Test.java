package com.photo.select;

import java.io.File;

public class Test {

    public static void main(String[] args) {
        // 将文件从一个目录移动到另一个目录
        File file = new File("E:\\2022-11-6 杜陵\\ARW\\XYY08160.ARW");
        File newFile = new File("E:\\2022-11-6 杜陵\\xiiu\\XYY08160.ARW");
        if(file.renameTo(newFile)){
            System.out.println("文件移动失败");;
        }else{
            System.out.println("文件移动失败");
        }
    }
}
