package com.example.myfirstapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class GetValsActivity extends Activity {

    private ListView listView;
    public static String response = "Loading...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_vals_activity);
        String login = getIntent().getStringExtra("Login");
        String pass = getIntent().getStringExtra("Pass");
        listView = (ListView) findViewById(R.id.listView);
        String url = "http://82.146.52.50/taskserver/index.php?login=" + login + "&pass=" + pass;
        new UserRequestTask().execute(url);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showResult();
            }
        }, 300);
    }

    private void showResult() {
        String[] vals = response.split("<br>");
        if (vals.length != 2) {
            this.showErrorDialog();
            return;
        }
        List<Map<String, String>> values = new ArrayList<Map<String, String>>();
        Map user;
        for (int i = 0; i < 10; i++) {
            user = new HashMap<String, String>();
            user.put("Name", vals[0]);
            user.put("Surname", vals[1]);
            values.add(user);
        }
        SimpleAdapter adapter = new UserAdapter(this, values, R.layout.user_list_layout, new String[] {"Name", "Surname"}, new int[] {R.id.login, R.id.pass});
        listView.setAdapter(adapter);
    }

    private void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(GetValsActivity.this);
        builder.setTitle("Ошибка!")
                .setMessage(response)
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNegativeButton("Назад",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Intent intent = new Intent(GetValsActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
