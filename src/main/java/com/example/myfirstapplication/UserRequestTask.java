package com.example.myfirstapplication;

import android.os.AsyncTask;

import java.io.IOException;

public class UserRequestTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        String url = strings[0];
        String response;
        try {
            response = UserRequest.sendRequest(url);
        } catch (IOException e) {
            return e.getMessage();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
