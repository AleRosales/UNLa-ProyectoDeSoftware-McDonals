package unla.ProyectoSoftware.database;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mauro on 13/12/17.
 */

public class PersistUtils {

/*
    public static void persistEntity(Context context, EntityMobile entity) throws Exception {
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(context);


        try {
            entity.onDBAction(context, DynamicConstants.DBACTION.PERSIST);
            dbHelper.getCustomDao(entity.getClass()).createOrUpdate(entity);

            for (EntityMobile subEntity : (List<EntityMobile>) DynamicUtils.safeList(entity.getReferencedEntities())) {
                persistEntity(context, subEntity);
            }
        } catch (SQLException e) {
            if (log) {
                LogDynamic.getInstance().log(context, LogDynamic.TipoLog.ERROR, "CreateOrUpdate",
                        "Error sql: " + e.getMessage());
            }
            throw e;
        } catch (Exception e) {
            if (log) {
                LogDynamic.getInstance().log(context, LogDynamic.TipoLog.ERROR, "CreateOrUpdate",
                        "Error : " + e.getMessage());
            }
            throw e;
        }

    }
    public static void removeEntity(Context context, EntityMobile entity) throws Exception {
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(context);
        try{
            entity.onDBAction(context, DynamicConstants.DBACTION.DELETE);
            dbHelper.getCustomDao(entity.getClass()).delete(entity);
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        for(EntityMobile subEntity : (List<EntityMobile>) DynamicUtils.safeList(entity.getReferencedEntities())){
            removeEntity(context,subEntity);
        }
    }

    public static List<EntityMobile> addEntityIfNotNull( List<EntityMobile> list,EntityMobile entityMobile){
        if(list == null){
            list = new ArrayList<>();
        }
        if(entityMobile != null){
            list.add(entityMobile);
        }
        return list;
    }

    public static List<EntityMobile> addCollectionIfNotNull(List<EntityMobile> output,List<EntityMobile> input){
        if(!CollectionUtils.isEmpty(input)){
            output.addAll(input);
        }
        return output;
    }

    public static List<EntityMobile> addCollectionIfNotNull(List<EntityMobile> output, Collection input){
        if(!CollectionUtils.isEmpty(input)){
            output.addAll(input);
        }
        return output;
    }*/
}
