package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import utilities.FileUtils;

public class CPShopPage extends BasePage<CPShopPage> {
    @FindBy(xpath = "//*[@data-trk-id='jackets']")
    WebElement JACKET_BUTTON;

    @FindBy(xpath = "//*[@class='lowest']//*[@class='sr-only']" +
            " |//*[@class='product-card-title' or @class='product-vibrancy-container']")
    List<WebElement> JACKET_TEXT;

    @FindBy(xpath = "//*[@class='next-page']")
    WebElement FIND_NEXT;

    @FindBy(xpath = "//*[@class='modal-mobile-content']")
    WebElement PROMOTION_POPUP;

    public CPShopPage() {
        super();
    }


    public void checkPromotions(){
        isElementDisplayed(PROMOTION_POPUP);
        isElementNotDisplayed(PROMOTION_POPUP);
    }

    public void clickOnJackets(){
        click(JACKET_BUTTON);
    }

    public void printToFile(FileWriter fileWriter){
        for (WebElement element : JACKET_TEXT) {
            String op = getText(element);
            try {
                if (op.contains("$")) {
                    fileWriter.write("\n");
                }
                fileWriter.write(op);
                fileWriter.write("\n");
            } catch (IOException e) {
                //logger
            }
        }
    }

    public void getJacketDetails(){
        FileUtils fileUtils = new FileUtils();
        FileWriter fileWriter = fileUtils.writeToFile("CoreProduct_Jackets.txt");

        while(isFound(FIND_NEXT)){
            CPShopPage cpShopPage = new CPShopPage();
            cpShopPage.printToFile(fileWriter);
            cpShopPage.click(FIND_NEXT);
        }
        printToFile(fileWriter);
        fileUtils.closeWriter(fileWriter);
    }

}
