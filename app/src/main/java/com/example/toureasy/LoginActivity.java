package com.example.toureasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnlogin;
    DBHelper DB;
//    DBHelper2 DB2;
    DBHelper3 DB3;
    passHelper passD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button)  findViewById(R.id.btnsignin1);
        DB = new DBHelper(this);
        DB3 = new DBHelper3(this);
//        DB2 = new DBHelper2(this);
        passD = new passHelper();

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
                        Toast.makeText(LoginActivity.this,"Sign in Successfull " + user,Toast.LENGTH_SHORT).show();
                        passD.setUsername(user);
//                        passD = new passHelper();
                        DB.sourceInsert();
                        DB3.destinationInsert();
                        DB3.insertDistance();
//                        boolean res = DB.destinInsert();
//                        Toast.makeText(LoginActivity.this, "res: " + res, Toast.LENGTH_SHORT).show();
//                        DB.destinationInsert();
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}