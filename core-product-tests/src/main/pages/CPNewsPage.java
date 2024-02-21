package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.FileUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CPNewsPage extends BasePage<CPNewsPage> {
    @FindBy(xpath = "//h3[contains(text(),'VIDEOS')]/following::*[contains(@class,'ContentGrid_contentGridColumn')]")
    List<WebElement> VIDEOS;

    @FindBy(xpath = "//h3[contains(text(),'VIDEOS')]/following::time")
    List<WebElement> TIME;

    @FindBy(xpath = "//*[@data-testid='social-section']")
    WebElement SOCIAL;
    public CPNewsPage() {
        super();
    }

    public int countVideos(){
        return VIDEOS.size();
    }

    public int countVideosgreaterThan3d(){
        int count = 0;
        for(WebElement i:TIME){
            String val = i.getText();
            int length = val.length();
            if(val.charAt(length-1)=='d'&&Integer.parseInt(val.substring(0,length-1))>=3){
                count++;
            }
        }
        return count;
    }


    public void printtofile(){
        FileUtils fileUtils = new FileUtils();
        FileWriter fileWriter = fileUtils.writeToFile("CoreProduct_Videos.txt");
        try {
            fileWriter.write("Total Video Count : " + countVideos());
            fileWriter.write("\n");
            fileWriter.write("Videos Count >=3d : " + countVideosgreaterThan3d());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileUtils.closeWriter(fileWriter);
    }





}
