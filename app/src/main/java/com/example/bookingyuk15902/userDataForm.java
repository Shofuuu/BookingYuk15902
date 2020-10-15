package com.example.bookingyuk15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class userDataForm extends AppCompatActivity {
    public static final String EXTRA_NAMA = "com.example.bookingyuk15902.EXTRA_NAMA";
    public static final String EXTRA_TELP = "com.example.bookingyuk15902.EXTRA_TELP";
    public static final String EXTRA_EMAIL = "com.example.bookingyuk15902.EXTRA_EMAIL";

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

        Intent intent = new Intent(this, userSelectTicket.class);

        intent.putExtra(EXTRA_NAMA, valueNama);
        intent.putExtra(EXTRA_TELP, valueTelp);
        intent.putExtra(EXTRA_EMAIL, valueEmail);

        startActivity(intent);
    }
}