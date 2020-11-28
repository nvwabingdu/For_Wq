package com.example.myapplication.android.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Android Studio.
 * User: 86182
 * Date: 2020-11-24
 * Time: 13:32
 */
public class DatabaseActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_sqlite);

        /**【初始化数据库】**/
        SQLFunction.initTable(DatabaseActivity.this);

        /**【动态申请sdCard读写权限】**/
        //DocumentTool.verifyStoragePermissions(MainActivity.this);

        btn_sql = this.findViewById(R.id.btn_sql);
        btn_sql.setOnClickListener(this);

    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_sql:
                DB_i_u_d_s();
                break;
        }
    }

    /**
     * 【操作数据库的方法】
     **/
    private void DB_i_u_d_s() {
        SQLFunction function = new SQLFunction();

        /**
         Log.i("TAG:","插入数据！");
         Object[] data = {"root","123456"};
         function.insert(MainActivity.this,data);
         */

        /**
         * Log.i("TAG:","通过id来修改数据！");
         *String name = "sale";
         *String info = "TestSale";
         *int _id = 7;
         *Object[]data = {name,info,_id};
         *function.update(MainActivity.this,data);
         * */

        /**
         * Log.i("TAG:","通过id来删除数据！");
         *int d_id = 2;
         *Object[] did = {d_id};
         *function.delete(MainActivity.this,did);
         * */
        Log.i("TAG:", "查询数据！");
        String where1 = null;
        String where2 = null;
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        list = function.query(DatabaseActivity.this, where1, where2);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Log.i("TAG:", "从数据库中拿到的数据 _ID为：" + list.get(i).get("_id"));
                Log.i("TAG:", "从数据库中拿到的数据name为：" + list.get(i).get("name"));
                Log.i("TAG:", "从数据库中拿到的数据info为：" + list.get(i).get("info"));
            }
        } else {
            Log.i("TAG:", "从数据库中没有拿到数据！");
        }
    }
}
