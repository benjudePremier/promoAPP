package com.example.promo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class menu_act extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        // Aqui llamo el elemento pod id
        videoView = (VideoView) findViewById(R.id.vid);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video1)); // ruta del video
        // control de la navigacion
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
        videoView.start();
    }

    public void Promociones(View v) {
        Intent i = new Intent(this, promociones.class);
        startActivity(i);

    }
    public void Gestion(View v) {
        Intent i = new Intent(this, afrebase.class);
        startActivity(i);

    }
}