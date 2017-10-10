package com.mohen.edu.record.library;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Kenneth on 2017/9/27.
 */

public class ActionRecordHttpClient {

    private String uri;
    private String key;

    public ActionRecordHttpClient(String uri, String key){
        this.uri = uri;
        this.key = key;
    }

    public void submit(final ActionEntity entity){
        RequestParams params = new RequestParams(uri);
        params.addParameter("cmd", "Report");
        params.addParameter("mode", "uploadReport");
        params.addParameter("key", key);
        params.addParameter("rid", String.valueOf(Math.random()));
        params.addParameter("name", entity.getName());
        params.addParameter("v1", String.valueOf("1"));
        params.addParameter("cfg", entity.getCfg());
        params.addParameter("type", entity.getType());

        x.http().get(params, new Callback.CommonCallback<JSONObject>() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtil.d("record action success: "+jsonObject.toString() );
                /*DbManager db = DbHelper.getInstance().getDB();
                try {
                    db.dropTable(ActionEntity.class);
                } catch (DbException e) {
                    e.printStackTrace();
                }*/
            }

            @Override
            public void onError(Throwable throwable, boolean b) {
                LogUtil.e("record action error: "+throwable.getMessage());
                /*DbManager db = DbHelper.getInstance().getDB();
                try {
                    db.saveOrUpdate(entity);
                } catch (DbException e) {
                    e.printStackTrace();
                }*/

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
