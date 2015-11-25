package fr.alma.services.actions.data;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolas on 11/24/15.
 */

@Result(type = "json")
public class Cart extends ActionSupport {


    private static final Logger log = LogManager.getLogger(Cart.class);

    private List<Article> cartContent;
    private double totalPrice = 0;

    public String execute() throws Exception {
        cartContent = new ArrayList<Article>();

        cartContent.add(new Article("Article 1", "Description 1", 20.99, 12));
        cartContent.add(new Article("Article 2", "Description 2", 9.99, 20));
        cartContent.add(new Article("Article 3", "Description 3", 999.50, 999));
        cartContent.add(new Article("Article 4", "Description 4", 0, 1));

        log.debug("Cart contains {} Articles", cartContent.size());
        return SUCCESS;
    }


    public void calculateTotalPrice(){
        for (Article a: cartContent){
            totalPrice += a.getPrice();
        }
    }

    public double getTotalPrice(){
        return getTotalPrice();
    }
}
