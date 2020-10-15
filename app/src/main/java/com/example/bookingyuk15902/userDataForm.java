package com.example.bookingyuk15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class userDataForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_form);

        Button btnPilihTiket = (Button) findViewById(R.id.btnPilihTiket);
        btnPilihTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSelectTiket();
            }
        });
    }

    private void openSelectTiket() {
        EditText textNama = (EditText) findViewById(R.id.valueNama);
        String valueNama = textNama.getText().toString();

        EditText textTelp = (EditText) findViewById(R.id.valueTelp);
        String valueTelp = textTelp.getText().toString();

        EditText textEmail = (EditText) findViewById(R.id.valueEmail);
        String valueEmail = textEmail.getText().toString();

        GlobalClass globalClass = (GlobalClass) getApplicationContext();
        globalClass.setValueEmail(valueEmail);
        globalClass.setValueName(valueNama);
        globalClass.setValueTelp(valueTelp);

        Intent intent = new Intent(this, userSelectTicket.class);
        startActivity(intent);
    }
}