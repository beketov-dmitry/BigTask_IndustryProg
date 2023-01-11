package Archivates;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipArchivate {
    public String unarchivate(String data) {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream("__fixtures__/" + data))) {
            ZipEntry entry;
            String name = null;
            String fileData = "";

            while ((entry = zin.getNextEntry()) != null) {

                name = entry.getName(); // получим название файла
                // распаковка
                FileOutputStream fout = new FileOutputStream("C:\\Users\\ADD-0\\IdeaProjects\\BigTask\\__fixtures__\\" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                    fileData = fileData + c;
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
            return name;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
