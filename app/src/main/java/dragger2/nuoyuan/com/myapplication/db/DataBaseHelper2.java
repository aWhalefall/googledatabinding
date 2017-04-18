package dragger2.nuoyuan.com.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

import java.io.File;
import java.io.InputStream;

/**
 * Created by weichyang on 2017/4/13.
 * 熟悉数据库的基本操作
 */

public class DataBaseHelper2 extends OrmLiteSqliteOpenHelper {

    private static final String TABLE_NAME = "ny_test.db";
    private static final int DATABASE_VERSION = 1;

    /**
     * @param context         上下文
     * @param databaseName    数据库名字
     * @param factory         CursorFactor 工厂
     * @param databaseVersion 数据库版本
     */
    public DataBaseHelper2(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, TABLE_NAME, null, DATABASE_VERSION);
    }

    public DataBaseHelper2(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, int configFileId) {
        super(context, databaseName, factory, databaseVersion, configFileId);
    }

    public DataBaseHelper2(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, File configFile) {
        super(context, databaseName, factory, databaseVersion, configFile);
    }

    public DataBaseHelper2(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, InputStream stream) {
        super(context, databaseName, factory, databaseVersion, stream);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

        if (sqLiteDatabase.getVersion() < DATABASE_VERSION) {
            //升级具体表和字段

        } else {
            //降级不处理
        }


    }


}
