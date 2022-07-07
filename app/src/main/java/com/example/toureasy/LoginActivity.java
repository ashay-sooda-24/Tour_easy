package com.example.toureasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnlogin;
    DBHelper DB;
    DBHelper3 DB3;
    SharedPreferences sharedPreferences;
    TextView SignUp;

    //sharedpreferences name and key name
    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_NAME = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button)  findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);
        DB3 = new DBHelper3(this);
        SignUp = (TextView) findViewById(R.id.Signup);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        //checking for already logged in user or not ie availibility of data

        String name = sharedPreferences.getString(KEY_NAME,null);

        if(name != null){
            //if data available the go to home
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this,"Please Enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass == true){
                        DB.sourceInsert();
                        DB3.destinationInsert();
                        DB3.insertDistance();

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(KEY_NAME,user);
                        editor.putBoolean("hasLoggedIn",true);
                        editor.apply();
                        finish();

                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this,"Sign in Successfull " + user,Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}