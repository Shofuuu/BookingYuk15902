package com.example.bookingyuk15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class userSelectTicket extends AppCompatActivity {
    public static final String EXTRA_TIKET_PILIH="com.exanple.bookingyuk15902.EXTRA_TIKET_PILIH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select_ticket);

        Button btnTiketPesawat = (Button) findViewById(R.id.btnTiketPesawat);
        btnTiketPesawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTiketPesawat();
            }
        });

        Button btnTiketKereta = (Button) findViewById(R.id.btnTiketKeretaApi);
        btnTiketKereta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTiketKereta();
            }
        });

        Button btnTiketBis = (Button) findViewById(R.id.btnTiketBis);
        btnTiketBis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTiketBis();
            }
        });
    }

    private void openTiketBis() {
        Intent intent = new Intent(this, userTiketPesawat.class);

        intent.putExtra(EXTRA_TIKET_PILIH, "Bis");

        startActivity(intent);
    }

    private void openTiketKereta() {
        Intent intent = new Intent(this, userTiketPesawat.class);

        intent.putExtra(EXTRA_TIKET_PILIH, "Kereta");

        startActivity(intent);
    }

    private void openTiketPesawat() {
        Intent intent = new Intent(this, userTiketPesawat.class);

        intent.putExtra(EXTRA_TIKET_PILIH, "Pesawat");

        startActivity(intent);
    }
}