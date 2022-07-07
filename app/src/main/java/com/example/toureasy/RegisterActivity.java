package com.example.toureasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username,phone, password,repassword;
    Button signup,signin;
    DBHelper DB;
    //    DBHelper2 DB2;
    DBHelper3 DB3;
    passHelper passR;

    SharedPreferences sharedPreferences;

    //sharedpreferences name and key name
//    private static final String SHARED_PREF_NAME = "mypref";
//    private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        phone = (EditText) findViewById(R.id.phone);
        signin = (Button) findViewById(R.id.btnsignin);
        signup = (Button) findViewById(R.id.btnsignup);
        DB = new DBHelper(this);
//        DB2 = new DBHelper2(this);
        DB3 = new DBHelper3(this);
        passR = new passHelper();

        //checking for already logged in user or not ie availibility of data

//        String name = sharedPreferences.getString(KEY_NAME,null);
//
//        if(name != null){
//            //if data available the go to home
//            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
//            startActivity(intent);
//        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String ph = phone.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(RegisterActivity.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass,Integer.parseInt(ph));

                            if(insert ==true){
//                                Toast.makeText(MainActivity.this,"Registered successfully!",Toast.LENGTH_SHORT).show();
                                passR.setUsername(user);
//                                DB.sourceInsert();
//                                DB3.destinationInsert();
//                                DB3.insertDistance();
//                                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
//                                startActivity(intent);
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterActivity.this,"Registration failed",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(RegisterActivity.this,"User already exists",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this,"Password does'nt match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}