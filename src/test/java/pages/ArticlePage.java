package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
    private BaseFunction baseFunction;
    private static final Logger LOGGER = LogManager.getLogger(ArticlePage.class);
    private final By TITLE = By.xpath(".//h1[@class='article-title']");

    public ArticlePage(BaseFunction baseFunction) {

        this.baseFunction = baseFunction;
    }

    public String getTitle() {
        LOGGER.info("Getting title from the article page.");
        WebElement element = baseFunction.getElement(TITLE);
        return element.getText();
    }
}
