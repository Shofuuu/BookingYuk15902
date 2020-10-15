package com.example.bookingyuk15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;
import com.example.bookingyuk15902.GlobalClass;

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
        GlobalClass globalClass = new GlobalClass();

        valueNama.setText(globalClass.getValueName());
        valueTelp.setText(globalClass.getValueTelp());
        valueEmail.setText(globalClass.getValueEmail());
        valueJenisKendaraan.setText(intent.getStringExtra(userTiketPesawat.EXTRA_JENIS_KENDARAAN));
        valueNamaKendaraan.setText(intent.getStringExtra(userTiketPesawat.EXTRA_SPINNER_KENDARAAN));
        valueHariKeberangkatan.setText(intent.getStringExtra(userTiketPesawat.EXTRA_HARI_PENERBANGAN));
        valueWaktu.setText(intent.getStringExtra(userTiketPesawat.EXTRA_WAKTU));
    }
}