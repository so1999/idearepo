package file;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Sun on 2015/12/14.
 */
public class Unzip{
    List<String> fileList;
    private static final String INPUT_ZIP_FILE="myfile.zip";
    private static final String OUTPUT_FOLDER="outputzip";

    public static void main(String[] args) {
        Unzip unzip=new Unzip();
        unzip.unZipIt(INPUT_ZIP_FILE,OUTPUT_FOLDER);
    }

    private void unZipIt(String zipFile, String outputFolder) {
        byte[] buffer=new byte[1024];

        //create output directory if not exists
        File folder=new File(OUTPUT_FOLDER);
        if(!folder.exists()){
            folder.mkdir();
        }

        //get the zip file content
        try {
            ZipInputStream zis=new ZipInputStream(new FileInputStream(zipFile));
            ZipEntry ze=zis.getNextEntry();
            while(ze!=null){
                String fileName=ze.getName();
                File newFile=new File(outputFolder+File.separator+fileName);
                System.out.println("file unzip: "+newFile.getAbsolutePath());
                //create all non exists folders
                new File(newFile.getParent()).mkdir();
                FileOutputStream fos=new FileOutputStream(newFile);

                int len;
                while ((len=zis.read(buffer))>0){
                    fos.write(buffer,0,len);
                }

                fos.close();
                ze=zis.getNextEntry();

            }
            zis.closeEntry();
            zis.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}