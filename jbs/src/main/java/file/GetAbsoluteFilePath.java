package file;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sun on 2016/1/8.
 */
public class GetAbsoluteFilePath {
    public static void main(String[] args) {
        try {
            File temp=File.createTempFile("i-am-a-temp-file",".tmp");
            String absolutePath=temp.getAbsolutePath();
            System.out.println(absolutePath);
            String filePath=absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));
            System.out.println(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
