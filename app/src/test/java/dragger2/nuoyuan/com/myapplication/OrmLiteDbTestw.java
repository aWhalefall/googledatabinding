package dragger2.nuoyuan.com.myapplication;


import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.List;

import dragger2.nuoyuan.com.myapplication.bean.Article;
import dragger2.nuoyuan.com.myapplication.bean.User;
import dragger2.nuoyuan.com.myapplication.db.ArticleDao;
import dragger2.nuoyuan.com.myapplication.db.UserDao;
import dragger2.nuoyuan.com.myapplication.utils.L;

import static org.mockito.Mockito.mock;


public class OrmLiteDbTestw {


    @Mock
    Context context;

    @Before
    public void initData() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddArticle() {
        User u = new User();
        u.setName("000000000000");
        new UserDao(context).add(u);
        Article article = new Article();
        article.setTitle("ORMLite的使用");
        article.setUser(u);
        new ArticleDao(context).add(article);

    }
//
//    @Test
//    public void testGetArticleById() {
//        Article article = new ArticleDao(context).get(1);
//        L.e(article.getUser() + " , " + article.getTitle());
//    }
//
//    @Test
//    public void testGetArticleWithUser() {
//
//        Article article = new ArticleDao(context).getArticleWithUser(1);
//        L.e(article.getUser() + " , " + article.getTitle());
//    }
//
//    @Test
//    public void testListArticlesByUserId() {
//        List<Article> articles = new ArticleDao(context).listByUserId(1);
//        L.e(articles.toString());
//    }
//
//    @Test
//    public void testGetUserById() {
//        User user = new UserDao(context).get(1);
//        L.e(user.getName());
//        if (user.getArticles() != null)
//            for (Article article : user.getArticles()) {
//                L.e(article.toString());
//            }
//    }
//
//    @Test
//    public void testAddStudent() throws SQLException {
//        OrmLiteDbTestw ormLiteDbTestw = new OrmLiteDbTestw();
//        ormLiteDbTestw.testAddStudent();
//    }
//

}
