package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    BaseFunction baseFunction;

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    private static final By ARTICLES = By.className("ci-content");
    private static final By TITLE = By.xpath(".//div[contains(@class,'ci-title')]");

    public HomePage(BaseFunction baseFunctions) {
        this.baseFunction = baseFunctions;
    }

    public WebElement getArticle(int articleNumber) {
        LOGGER.info("Start to get  article from homepage.");

        return baseFunction.getElement(articleNumber, getArticlesList());
    }

    public List<WebElement> getArticlesList() {
        LOGGER.info("Getting all articles from homepage");

        return baseFunction.getElementsList(ARTICLES);
    }

    public String getTitle(WebElement article) {
        LOGGER.info("Getting Title.");
        String articleTitle = article.findElement(TITLE).getText();
        return articleTitle;
    }

    public ArticlePage openArticle(WebElement article) {
        LOGGER.info("Clicking on title.");
        baseFunction.click(article);
        return new ArticlePage(baseFunction);
    }
//
//    private List<ArticleWrapper> getAllArticles() {
//        List<WebElement> articles = baseFunctions.findElements(ARTICLE_ITEM);
//        List<ArticleWrapper> articleWrappers = new ArrayList<ArticleWrapper>();
//
//        Iterables.addAll(articleWrappers, articles.stream()
//                .map(webElement -> new ArticleWrapper(baseFunctions, webElement))
//                .collect(Collectors.toList()));
//
//        return articleWrappers;
//    }
//
//    private ArticleWrapper getArticleByTitle(String name) {
//        Optional<ArticleWrapper> wrapper = Iterables.tryFind(getAllArticles(),
//                articleWrapper -> articleWrapper.getArticleTitle().contains(name));
//        return wrapper.isPresent() ? wrapper.get() : null;
//    }
//
//    public ArticlePage openArticleByTitle(String articleName) {
//        getArticleByTitle(articleName).clickOnTitle();
//        return new ArticlePage(baseFunctions);
//    }
}
