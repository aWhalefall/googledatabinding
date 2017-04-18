package dragger2.nuoyuan.com.myapplication.db;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

import dragger2.nuoyuan.com.myapplication.bean.Student;

public class StudentDao {

    private Context context;
    private Dao<Student, Integer> userDaoOpe;
    private DatabaseHelper helper;

    public StudentDao(Context context) {
        this.context = context;
        try {
            helper = DatabaseHelper.getHelper(context);
            userDaoOpe = helper.getDao(Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加一个用户
     *
     * @param student
     * @throws SQLException
     */
    public void add(Student student) {
        try {
            userDaoOpe.create(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Student get(int id) {
        try {
            return userDaoOpe.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> queryAll() {
        try {
            return userDaoOpe.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int deleteByName(String name) {
        try {
            //int result = userDaoOpe.executeRaw("DELETE FROM tb_student WHERE name=?", name);

            Where where = userDaoOpe.deleteBuilder().where().eq("name", name);
            userDaoOpe.deleteBuilder().setWhere(where);
            int result = userDaoOpe.deleteBuilder().delete();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
