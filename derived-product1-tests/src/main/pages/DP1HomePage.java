package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DP1HomePage extends BasePage<DP1HomePage>{

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement COOKIE_ACCEPT;

    @FindBy(xpath = "//button[contains(@class,'TileHeroStories_tileHeroStoriesButton')]")
    List<WebElement> SLIDES;

    public void acceptCookie(){
        try {
            click(COOKIE_ACCEPT);
        } catch (Exception e) {
            //continue
        }
    }

    public boolean checkForInvisibilityOfCookie(){
        try{
            waitForInvisibility(COOKIE_ACCEPT);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public int countSlides(){
        return SLIDES.size();
    }

    public List<String> getTitleofAllSlides(){
        List<String> titles = new ArrayList<>();
        for(WebElement i: SLIDES){
            titles.add(i.getText());
        }
        return titles;
    }

    public long countDuration(){
        WebElement element = null;
        for(int i=0;i< SLIDES.size();i++){
            if(SLIDES.get(i).getAttribute("aria-selected").equalsIgnoreCase("true")){
                if(i==SLIDES.size()-1){
                    element = SLIDES.getFirst();
                }else{
                    element = SLIDES.get(i+1);
                }
            }
        }

        while(element.getAttribute("aria-selected").equalsIgnoreCase("false")){
            //do nothing
        }
        long start = System.currentTimeMillis();
        while(element.getAttribute("aria-selected").equalsIgnoreCase("true")){
            //do nothing
        }
        long end = System.currentTimeMillis();
        return (end-start)/1000;
    }

}
