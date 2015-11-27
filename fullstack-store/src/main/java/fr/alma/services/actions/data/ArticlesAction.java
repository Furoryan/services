package fr.alma.services.actions.data;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 11/21/15.
 */
@Result(type = "json")
public class ArticlesAction extends ActionSupport {

    private static final Logger log = LogManager.getLogger(ArticlesAction.class);
    
    private List<Article> articles;

    public String execute() throws Exception {
        articles = new ArrayList<Article>();
        articles.add(new Article(1, "Article 1", "Description 1", 20.99, 12));
        articles.add(new Article(2, "Article 2", "Description 2", 9.99, 20));
        articles.add(new Article(3, "Article 3", "Description 3", 999.50, 999));
        articles.add(new Article(4, "Article 4", "Description 4", 0, 1));

        log.debug("Return {} Articles", articles.size());
        return SUCCESS;
    }

    public List<Article> getArticles(){
        return articles;
    }

}
