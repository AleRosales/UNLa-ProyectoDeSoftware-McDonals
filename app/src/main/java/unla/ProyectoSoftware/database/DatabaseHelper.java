package unla.ProyectoSoftware.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import unla.ProyectoSoftware.R;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static DatabaseHelper instance;

    private static final String DATABASE_NAME    = "ormlite_mcdonals_poyecto_software.db";
    private static final int    DATABASE_VERSION = 26;

    private List<Dao> daos = new ArrayList<Dao>();
    private List<Class> loadedDaos = new ArrayList<Class>();
    private List<String> daoClasses = new ArrayList<String>();
    private static Context context;

    public static synchronized DatabaseHelper getInstance(Context context) {
        DatabaseHelper.context = context;
        if (instance == null) {
            instance = OpenHelperManager.getHelper(context, DatabaseHelper.class);
        }
        return instance;
    }

    public synchronized static void destroy(){
        if (instance != null) {
            OpenHelperManager.releaseHelper();
            instance = null;
        }
    }

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.daoClasses = Arrays.asList(context.getResources().getStringArray(R.array.class_of_entities));
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
            for (String strClass : daoClasses) {
                try {
                    TableUtils.createTable(connectionSource, Class.forName(strClass));
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();

                    System.out.println(e.getMessage());

                } catch (Exception ex){
                    ex.printStackTrace();

                    System.out.println(ex.getMessage());

                }
            }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
                          int oldVersion, int newVersion) {
        for (String strClass : daoClasses) {
            try {
                TableUtils.dropTable(connectionSource, Class.forName(strClass),true);
            } catch (SQLException e) {
                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }
        }
        onCreate(db, connectionSource);
    }

    /* User */
    public Dao getCustomDao(Class clazz) throws SQLException {
        Dao dao = null;
        try {
            if(!loadedDaos.contains(clazz)) {
                if (daoClasses.contains(clazz.getName())) {
                    dao = getDao(clazz);
                    loadedDaos.add(clazz);
                    daos.add(dao);
                } else {
                    return null;
                }
            }else{
                dao = daos.get(loadedDaos.indexOf(clazz));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Toast.makeText(context, throwables.getMessage(), Toast.LENGTH_SHORT).show();
        }

        return dao;
    }

    @Override
    public void close() {
        daos = new ArrayList<>();
        loadedDaos = new ArrayList<>();

        super.close();
    }


}