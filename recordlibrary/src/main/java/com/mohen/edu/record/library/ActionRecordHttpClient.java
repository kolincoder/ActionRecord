package com.mohen.edu.record.library;

import com.google.gson.Gson;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

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
        params.addParameter("mode", "addReport");
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

    public void submitList(final List<ActionEntity> list){
        RequestParams params = new RequestParams(uri+"?cmd=Report&mode=uploadReport&" +
                "key="+key+"&rid="+String.valueOf(Math.random()));
        String dataStr = new Gson().toJson(list);
        /*JsonArray jsonArray = new Gson().toJsonTree(list,
                new TypeToken<List<ActionEntity>>(){}.getType()).getAsJsonArray();*/
        params.addParameter("data", dataStr.getBytes());
//        params.addHeader("Content-Type", "text/html");
        x.http().post(params, new Callback.CommonCallback<JSONObject>() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtil.d("upload record list "+jsonObject);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

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
