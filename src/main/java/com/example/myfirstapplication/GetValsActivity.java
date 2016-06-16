package com.example.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetValsActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_vals_activity);
        String login = getIntent().getStringExtra("Login");
        String pass = getIntent().getStringExtra("Pass");
        listView = (ListView) findViewById(R.id.listView);

        List<Map<String, String>> values = new ArrayList<Map<String, String>>();
        Map user;
        for (int i = 0; i < 10; i++) {
            user = new HashMap<String, String>();
            user.put("Login", login);
            user.put("Pass", pass);
            values.add(user);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, values, R.layout.user_list_layout, new String[] {"Login", "Pass"}, new int[] {R.id.login, R.id.pass});
        listView.setAdapter(adapter);
    }
}
