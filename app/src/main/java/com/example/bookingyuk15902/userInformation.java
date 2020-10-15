package com.example.bookingyuk15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class userInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        TextView valueNama = (TextView) findViewById(R.id.valueNama);
        TextView valueTelp = (TextView) findViewById(R.id.valueTelp);
        TextView valueEmail = (TextView) findViewById(R.id.valueEmail);
        TextView valueJenisKendaraan = (TextView) findViewById(R.id.valueJenisKendaraan);
        TextView valueNamaKendaraan = (TextView) findViewById(R.id.valueNamaKendaraan);
        TextView valueHariKeberangkatan = (TextView) findViewById(R.id.valueHariKeberangkatan);
        TextView valueWaktu = (TextView) findViewById(R.id.valueWaktu);

        Intent intent = getIntent();
        GlobalClass globalClass = (GlobalClass) getApplicationContext();

        valueNama.setText(globalClass.getValueName());
        valueTelp.setText(globalClass.getValueTelp());
        valueEmail.setText(globalClass.getValueEmail());
        valueJenisKendaraan.setText(intent.getStringExtra(userTiketPesawat.EXTRA_JENIS_KENDARAAN));
        valueNamaKendaraan.setText(intent.getStringExtra(userTiketPesawat.EXTRA_SPINNER_KENDARAAN));
        valueHariKeberangkatan.setText(intent.getStringExtra(userTiketPesawat.EXTRA_HARI_PENERBANGAN));
        valueWaktu.setText(intent.getStringExtra(userTiketPesawat.EXTRA_WAKTU));

        Button btnTidak = (Button) findViewById(R.id.btnTidak);
        btnTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToUserDataForm();
            }
        });

        Button btnYa = (Button) findViewById(R.id.btnYa);
        btnYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserConfirm();
            }
        });
    }

    private void openUserConfirm() {
        
    }

    private void backToUserDataForm() {
        Intent intent = new Intent(this, userDataForm.class);
        startActivity(intent);
    }
}