package com.example.bookingyuk15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class userTiketPesawat extends AppCompatActivity {
    public static final String EXTRA_JENIS_KENDARAAN = "com.example.bookingyuk15902.EXTRA_JENIS_KENDARAAN";
    public static final String EXTRA_SPINNER_KENDARAAN = "com.example.bookingyuk15902.EXTRA_SPINNER_KENDARAAN";
    public static final String EXTRA_HARI_PENERBANGAN = "com.example.bookingyuk15902.EXTRA_PENERBANGAN";
    public static final String EXTRA_WAKTU = "com.example.bookingyuk15902.EXTRA_WAKTU";

    private String selectedKendaraan;
    private String pilihanKendaraan;
    RadioButton radioButton;
    RadioGroup radioGroupHariKiri;
    RadioGroup radioGroupHariKanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tiket_pesawat);

        TextView labelKendaraan = (TextView) findViewById(R.id.labelKendaraan);
        Intent intent = getIntent();
        pilihanKendaraan = intent.getStringExtra(userSelectTicket.EXTRA_TIKET_PILIH);
        labelKendaraan.setText("Pilih " + pilihanKendaraan);

        List<String> strKendaraan;
        if(pilihanKendaraan == "Pesawat")
            strKendaraan = Arrays.asList(getResources().getStringArray(R.array.spinnerPesawat));
        else if(pilihanKendaraan == "Kereta")
            strKendaraan = Arrays.asList(getResources().getStringArray(R.array.spinnerKereta));
        else if(pilihanKendaraan == "Bis")
            strKendaraan = Arrays.asList(getResources().getStringArray(R.array.spinnerBis));
        else
            strKendaraan = Arrays.asList(getResources().getStringArray(R.array.spinnerPesawat));

        Spinner spinnerKendaraan = (Spinner) findViewById(R.id.spinnerKendaraan);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strKendaraan);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerKendaraan.setAdapter(adapter);
        spinnerKendaraan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedKendaraan = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                selectedKendaraan = adapterView.getItemAtPosition(0).toString();
            }
        });

        radioGroupHariKiri = (RadioGroup) findViewById(R.id.radioHariKiri); // Senin - Kamis
        radioGroupHariKanan = (RadioGroup) findViewById(R.id.radioHariKanan); // Jum'at - Minggu

        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserInformation();
            }
        });
    }

    private String getCheckBoxWaktu(){
        String cbWaktu = "";

        CheckBox cbPagi = (CheckBox) findViewById(R.id.cbPagi);
        CheckBox cbSiang = (CheckBox) findViewById(R.id.cbSiang);
        CheckBox cbSore = (CheckBox) findViewById(R.id.cbSore);

        if(cbPagi.isChecked())
            cbWaktu += cbPagi.getText().toString() + ", ";
        if(cbSiang.isChecked())
            cbWaktu += cbSiang.getText().toString() + ", ";
        if(cbSore.isChecked())
            cbWaktu += cbSore.getText().toString() + ", ";

        return cbWaktu;
    }

    private void openUserInformation() {
        String strRadioHari = "";
        int radioIDKiri = radioGroupHariKiri.getCheckedRadioButtonId();
        int radioIDKanan = radioGroupHariKanan.getCheckedRadioButtonId();

        if(radioIDKiri != (-1)){
            radioButton = findViewById(radioIDKiri);
            strRadioHari = radioButton.getText().toString();
        }
        if(radioIDKanan != (-1)){
            radioButton = findViewById(radioIDKanan);
            strRadioHari = radioButton.getText().toString();
        }

        Intent intent = new Intent(this, userInformation.class);

        intent.putExtra(EXTRA_JENIS_KENDARAAN, pilihanKendaraan);
        intent.putExtra(EXTRA_SPINNER_KENDARAAN, selectedKendaraan);
        intent.putExtra(EXTRA_HARI_PENERBANGAN, strRadioHari);
        intent.putExtra(EXTRA_WAKTU, getCheckBoxWaktu());

        startActivity(intent);
    }
}