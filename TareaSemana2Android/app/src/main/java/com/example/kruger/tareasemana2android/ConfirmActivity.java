package com.example.kruger.tareasemana2android;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    TextView tv_name;
    TextView tv_phone;
    TextView tv_email;
    TextView tv_description;
    TextView tv_born_date;
    Button bt_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        tv_name = findViewById(R.id.tv_name);
        tv_phone = findViewById(R.id.tv_phone);
        tv_email = findViewById(R.id.tv_email);
        tv_description = findViewById(R.id.tv_description);
        tv_born_date = findViewById(R.id.tv_born_date);
        bt_edit = findViewById(R.id.bt_edit);

        setData(getIntent().getExtras());

        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void setData(Bundle bundle){
        if(bundle != null){
            tv_name.setText(bundle.getString("name"));
            tv_phone.setText(bundle.getString("phone"));
            tv_email.setText(bundle.getString("email"));
            tv_description.setText(bundle.getString("description"));
            tv_born_date.setText(bundle.getString("born_date"));
        }
    }
}
