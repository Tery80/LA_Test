import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.ArticlePage;
import pages.BaseFunction;
import pages.HomePage;


public class LaTest {

    BaseFunction baseFunction = new BaseFunction();
    private static final Logger LOGGER = LogManager.getLogger(LaTest.class);

    private static final String HOME_PAGE_URL = "www.la.lv";
    private static final int ARTICLE_NUMBER = 1;

    @Test
    public void firstArticleTest() {
        LOGGER.info("This test will check LA.lv 1 article Title at Home page and Article page");
        LOGGER.info("Open homepage.");
        baseFunction.openUrl(HOME_PAGE_URL);

        LOGGER.info("Getting title of the article.");
        HomePage homePage = new HomePage(baseFunction);
        WebElement article = homePage.getArticle(ARTICLE_NUMBER);
        String title = homePage.getTitle(article);

        LOGGER.info("Open article.");
        ArticlePage articlePage = homePage.openArticle(article);

        LOGGER.info("Getting article title from the article page.");
        String articleTitle = articlePage.getTitle();

        LOGGER.info("Comparing title of the first article on article view and main pages.");
        Assertions.assertEquals(title, articleTitle, "Titles are not equals");

        LOGGER.info("Test is successful. Web page will be closed");
        baseFunction.closeWebPage();
    }
}
