package com.mohen.edu.actionrecord;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.Gson;
import com.mohen.edu.record.library.ActionCFG;
import com.mohen.edu.record.library.ActionEntity;
import com.mohen.edu.record.library.ActionRecordHttpClient;
import com.mohen.edu.record.library.Cfg;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActionRecordHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * http://192.168.60.178/home/mpcmd.ashx
         * cmd=Report&mode=uploadReport&key=60987188103781609&rid=0.7101400894438715
         */
        client = new ActionRecordHttpClient("http://192.168.60.178/home/mpcmd.ashx", "60987188103781609");
        client.submitFromDatabase();
        findViewById(R.id.btn_single).setOnClickListener(this);
        findViewById(R.id.btn_list).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_single:
                client.submit(createActionEntity());
                break;
            case R.id.btn_list:
                List<ActionEntity> list = new ArrayList<>();
                list.add(createActionEntity());
                client.submitList(list);
                break;
        }
    }

    private ActionEntity createActionEntity(){
        Cfg cfg = new Cfg("测试A", String.valueOf(System.currentTimeMillis()),
                null, "com.mohen.edu.actionrecord");
        ActionEntity entity = new ActionEntity(ActionCFG.Name.APP, 0, 0,
                null, null, ActionCFG.Type.type_action_app,
                new Gson().toJsonTree(cfg).toString());
        return entity;
    }

}
