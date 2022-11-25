package Decorator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ArchivateDecorator extends DataSourceDecorator{
    ArchivateDecorator(DataSource source) {
        super(source);
    }
    @Override
    public void writeData(String data) {
        super.writeData(archivate(data));
    }

    @Override
    public String readData() throws IOException {
        return unarchivate(super.readData());
    }
    public String unarchivate(String data) throws IOException {
        ZipInputStream zin = new ZipInputStream(new FileInputStream("__fixtures__/" + data));
        ZipEntry entry;
        String name;
        String fileData = "";

        while((entry=zin.getNextEntry())!=null) {

            name = entry.getName(); // получим название файла
            // распаковка
            FileOutputStream fout = new FileOutputStream("__fixtures__" + name);
            for (int c = zin.read(); c != -1; c = zin.read()) {
                fout.write(c);
                fileData = fileData + c;
            }
            fout.flush();
            zin.closeEntry();
            fout.close();
        }
        return fileData;
    }
}
