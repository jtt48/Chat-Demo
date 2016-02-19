package com.example.zylo.chat_try;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("started in the right place");
        startActivity(new Intent(this,MainActivity.class));
    }


    }

