package com.mohen.edu.record.library.db;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by Kenneth on 2017/9/29.
 */

public class DbHelper {

    private static DbHelper me;
    private DbManager.DaoConfig daoConfig;

    public static DbHelper getInstance(){
        if (me==null){
            me = new DbHelper();
        }
        return me;
    }

    private DbHelper(){
        daoConfig = new DbManager.DaoConfig()
                .setDbName("record.db")
                .setDbVersion(1)
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager dbManager) {
                        //开启WAL,对写入速度提升巨大
                        dbManager.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager dbManager, int i, int i1) {

                    }
                });
    }

    public DbManager getDB(){
        return x.getDb(daoConfig);
    }

}
