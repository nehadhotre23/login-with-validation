package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView attempt, replaceButton;
    int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        attempt = (TextView) findViewById(R.id.attemmpt);
        replaceButton = (TextView) findViewById(R.id.textViewDisableBUtton);

        login.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                String USERNAME = username.getText().toString();
                String PASSWORD = password.getText().toString();

                if (USERNAME.equals("neha") && PASSWORD.equals("1234")) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong user & pass", Toast.LENGTH_LONG).show();
                    attempt.setVisibility(View.VISIBLE);
                    count--;
                    attempt.setText("Attempt left " + count);

//                    if(count == 0){
//                     login.setEnabled(false);
//                    }
                    if(count == 0){
                        login.setVisibility(View.GONE);
                        replaceButton.setVisibility(View.VISIBLE);
                        replaceButton.setTextColor(Color.RED);
                        replaceButton.setTextSize(20);
                        replaceButton.setTextAlignment(Gravity.CENTER);
                        replaceButton.setText("You have to restart you app again");
                    }

                }

            }
        });
    }
}
