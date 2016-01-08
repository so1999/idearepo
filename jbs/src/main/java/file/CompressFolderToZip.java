package file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Sun on 2015/12/14.
 */
public class CompressFolderToZip {

    List<String> fileList;
    private static final String OUTPUT_ZIP_FILE = "myfile.zip";
    private static final String SOURCE_FOLDER = "D:/dev/github/idearepo/jbs/src/main/java";

    CompressFolderToZip() {
        fileList = new ArrayList<String>();
    }

    public static void main(String[] args) {
        CompressFolderToZip cftz = new CompressFolderToZip();
        cftz.generateFileList(new File(SOURCE_FOLDER));
        cftz.zipIt(OUTPUT_ZIP_FILE);
    }

    private void zipIt(String zipFile) {
        byte[] buffer = new byte[1024];
        try {
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            System.out.println("Output to Zip: " + zipFile);
            for (String file : this.fileList) {
                System.out.println("File Added: " + file);
                ZipEntry ze = new ZipEntry(file);
                zos.putNextEntry(ze);
                FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
                System.out.println(SOURCE_FOLDER + File.separator + file);
                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                in.close();
            }
            zos.closeEntry();
            zos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateFileList(File node) {
        //add file only
        if(node.isFile()){
            fileList.add(generateZipEnty(node.getAbsoluteFile().toString()));

        }
        if(node.isDirectory()){
            String [] subNote=node.list();
            for(String fileName:subNote){
                generateFileList(new File(node,fileName));
            }
        }

    }

    /**
     * @param file
     * @return
     */
    private String generateZipEnty(String file) {
        return file.substring(SOURCE_FOLDER.length()+1,file.length());
    }

}
