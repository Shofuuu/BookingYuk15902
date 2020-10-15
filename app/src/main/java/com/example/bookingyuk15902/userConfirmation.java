package com.example.bookingyuk15902;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class userConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_confirmation);

        Button btnSelesai = (Button) findViewById(R.id.btnSelesai);
        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToFirstPage();
            }
        });

        GlobalClass globalClass = (GlobalClass) getApplicationContext();
        TextView confirmMsg = (TextView) findViewById(R.id.confirmMsg);
        confirmMsg.setText(
                "Terimakasih telah\n" +
                "menggunakan Booking\n" +
                "Yukk. Konfirmasi\n" +
                "pendaftaran anda akan\n" +
                "segera dikirimkan\n" +
                "melalui sms ke nomer\n" +
                globalClass.getValueTelp()
        );
    }

    private void backToFirstPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}