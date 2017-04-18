package dragger2.nuoyuan.com.myapplication;


import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

import dragger2.nuoyuan.com.myapplication.bean.Article;
import dragger2.nuoyuan.com.myapplication.bean.Student;
import dragger2.nuoyuan.com.myapplication.bean.User;
import dragger2.nuoyuan.com.myapplication.db.ArticleDao;
import dragger2.nuoyuan.com.myapplication.db.DatabaseHelper;
import dragger2.nuoyuan.com.myapplication.db.StudentDao;
import dragger2.nuoyuan.com.myapplication.db.UserDao;
import dragger2.nuoyuan.com.myapplication.utils.L;


public class TestUtils {

    public void testAddArticle() {
        User u = new User();
        u.setName("000");
        new UserDao(MyApp.context).add(u);
        Article article = new Article();
        article.setTitle("hello world");
        article.setUser(u);
        new ArticleDao(MyApp.context).add(article);

    }

    public void testGetArticleById() {
        Article article = new ArticleDao(MyApp.context).get(1);
        L.e(article.getUser() + " , " + article.getTitle());
    }

    public void testGetArticleWithUser() {
        Article article = new ArticleDao(MyApp.context).getArticleWithUser(1);
        L.e(article.getUser() + " , " + article.getTitle());
    }

    public void testListArticlesByUserId() {
        List<Article> articles = new ArticleDao(MyApp.context).listByUserId(1);
        L.e(articles.toString());
    }

    public void testGetUserById() {
        User user = new UserDao(MyApp.context).get(1);
        L.e(user.getName());
        if (user.getArticles() != null)
            for (Article article : user.getArticles()) {
                L.e(article.toString());
            }
    }

    public void testAddStudent(String name) throws SQLException {
        Dao dao = DatabaseHelper.getHelper(MyApp.context).getDao(Student.class);
        Student student = new Student();
        student.setDao(dao);
        student.setName(name);
        student.create();
    }

    public String querystudentDao() throws SQLException {
        Student user = new StudentDao(MyApp.context).get(1);
        return user.toString();
    }


}
