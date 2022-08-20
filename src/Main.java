import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        String jpgPath = "E:\\2022-8-13 葡萄城婚礼\\100MSDCF\\03_酒宴\\JPG";
        String arwPath = "E:\\2022-8-13 葡萄城婚礼\\100MSDCF\\ARW";
        String toPath = "E:\\2022-8-13 葡萄城婚礼\\100MSDCF\\03_酒宴\\ARW";

        File jpg = new File(jpgPath);
        File arw = new File(arwPath);

        String[] jpgNames = jpg.list();
        File[] arwFiles = arw.listFiles();

        List<File> moves = new LinkedList<>();

        for (String name : jpgNames) {
            String jpgName = name.split("\\.")[0];
            for (File arwFile : arwFiles) {
                String arwName = arwFile.getName();
                if (arwName.startsWith(jpgName)) {
                    moves.add(arwFile);
                }
            }
        }

        for (File move : moves) {
            File source = move;
            File dest = new File(toPath + File.separator + source.getName());
            FileChannel input = null;
            FileChannel output = null;
            try {
                input = new FileInputStream(source).getChannel();
                output = new FileOutputStream(dest).getChannel();
                output.transferFrom(input, 0, input.size());
            } finally {
                input.close();
                output.close();
            }
        }
    }
}