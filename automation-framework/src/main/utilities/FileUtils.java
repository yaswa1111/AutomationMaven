package utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static utilities.driverCreator.browser;

public class FileUtils {

//    public void createFile(String name){
//        File file = new File("target/"+name);
//        file.delete();
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            //do nothing
//        }
//    }

    public FileWriter writeToFile(String name){
        File f = new File("output");
        f.mkdir();
        try {
            return new FileWriter("output/"+browser.get()+"_"+name);
        } catch (IOException e) {
            //do nothing
        }
        return null;
    }

    public void closeWriter(FileWriter fileWriter){
        try {
            fileWriter.close();
        } catch (IOException e) {
            //do nothing
        }
    }
}
