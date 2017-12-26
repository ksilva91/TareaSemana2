package com.example.kruger.tareasemana2android;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    TextInputLayout til_name;
    TextInputLayout til_phone;
    TextInputLayout til_email;
    TextInputLayout til_description;
    DatePicker dp_born_date;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        til_name = findViewById(R.id.til_name);
        til_phone = findViewById(R.id.til_phone);
        til_email = findViewById(R.id.til_email);
        til_description = findViewById(R.id.til_description);
        dp_born_date = findViewById(R.id.dp_born_date);
        next = findViewById(R.id.bt_next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate(til_name.getEditText().getText().toString(),
                        til_phone.getEditText().getText().toString(),
                        til_email.getEditText().getText().toString(),
                        til_description.getEditText().getText().toString(),
                        view)){
                    Intent intent = new Intent(MainActivity.this,ConfirmActivity.class);
                    intent.putExtra("name",til_name.getEditText().getText().toString());
                    intent.putExtra("phone",til_phone.getEditText().getText().toString());
                    intent.putExtra("email",til_email.getEditText().getText().toString());
                    intent.putExtra("description",til_description.getEditText().getText().toString());

                    int day = dp_born_date.getDayOfMonth();
                    int month = dp_born_date.getMonth() + 1;
                    int year = dp_born_date.getYear();
                    intent.putExtra("born_date",day + "/" + month + "/" + year);

                    startActivity(intent);
                }
            }
        });
    }

    public boolean validate(String name, String phone, String email, String description, View view){
        if(name.trim().equals("")){
            Snackbar.make(view,getResources().getString(R.string.msg_name),Snackbar.LENGTH_SHORT).show();
            return false;
        }else if(phone.trim().equals("")){
            Snackbar.make(view,getResources().getString(R.string.msg_phone),Snackbar.LENGTH_SHORT).show();
            return false;
        }else if(email.trim().equals("")){
            Snackbar.make(view,getResources().getString(R.string.msg_email),Snackbar.LENGTH_SHORT).show();
            return false;
        } else if(description.trim().equals("")){
            Snackbar.make(view,getResources().getString(R.string.msg_description),Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
