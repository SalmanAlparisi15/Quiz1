package com.example.quiz1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Nota extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#,###.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        Intent intent = getIntent();


        if (intent != null) {

            TextView tvWelcome = findViewById(R.id.tvWelcome);
            TextView tvnotaKode = findViewById(R.id.tvnotaKode);
            TextView tvnotaNama = findViewById(R.id.tvnotaNama);
            TextView tvnotaHarga = findViewById(R.id.tvnotaHarga);
            TextView tvnotaJumlah = findViewById(R.id.tvnotaJumlah);
            TextView tvnotaTotal = findViewById(R.id.tvnotaTotal);
            TextView tvnotaDiskon = findViewById(R.id.tvnotaDiskon);
            TextView tvnotaMember = findViewById(R.id.tvnotaMember);
            TextView tvnotaBayar = findViewById(R.id.tvnotaBayar);
            Button btnShare = findViewById(R.id.btnShare);


            String nama = intent.getStringExtra("Nama");
            String kode = intent.getStringExtra("Kode Barang");
            String namaBarang = intent.getStringExtra("Nama Barang");
            int jumlah = intent.getIntExtra("Jumlah Barang", 0);
            double hargaBarang = intent.getDoubleExtra("Harga Barang", 0);
            double totalHarga = intent.getDoubleExtra("Total Harga", 0);
            double diskon = intent.getDoubleExtra("Diskon Harga", 0);
            double member = intent.getDoubleExtra("Diskon Member", 0);
            double jumlahBayar = intent.getDoubleExtra("Jumlah Bayar", 0);


            tvWelcome.setText("Halo, " + nama + "!");
            tvnotaKode.setText("Kode Barang = " + kode);
            tvnotaNama.setText("Nama Barang = " + namaBarang);
            tvnotaJumlah.setText("Jumlah = " + jumlah);
            tvnotaHarga.setText("Harga = " + hargaBarang);
            tvnotaTotal.setText("Total Harga = " + df.format(totalHarga));
            tvnotaDiskon.setText("Diskon Harga = " + diskon);
            tvnotaMember.setText("Diskon Member = " + df.format(member));
            tvnotaBayar.setText("Jumlah Bayar = " + df.format(jumlahBayar));

            btnShare.setOnClickListener(click -> {
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                String shareMessage = "\nKode Barang: " + kode +
                        "\nNama Barang: " + namaBarang +
                        "\nJumlah Barang: " + jumlah +
                        "\nHarga Barang: " + hargaBarang +
                        "\nTotal Harga: " + df.format(totalHarga) +
                        "\nDiskon Harga: " + diskon +
                        "\nDiskon Member: " + df.format(member) +
                        "\nJumlah Bayar: " + df.format(jumlahBayar);
                intent1.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(intent1, "Bagikan Pesan Melalui..."));
            });
        }

    }
}
