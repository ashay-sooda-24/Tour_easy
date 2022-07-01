package com.example.toureasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class exploreMore extends AppCompatActivity {
    ImageView img;
    TextView title,placeDesc;

    passHelper passer = new passHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_more);

        img = (ImageView) findViewById(R.id.imageView);
        title = (TextView) findViewById(R.id.imageTitle);
        placeDesc = (TextView) findViewById(R.id.placeDesc);
        int imgId = passer.getId();

        switch (imgId){
            case 1:
                img.setImageResource(R.drawable.panambur);
                title.setText("Panambur Beach");
                placeDesc.setText("Panambur Beach is a beach in the city of Mangalore in the Indian state of Karnataka. This beach is on the shores of Arabian sea and is credited as one of the safest and best maintained beaches of India.It is the most popular, well connected and the most visited beach of Karnataka.");
                break;

            case 2:
                img.setImageResource(R.drawable.tannibhavi);
                title.setText("Tannirbhavi Beach");
                placeDesc.setText("It is one of those beaches that have trees on them and offers a picturesque landscape.One can sit under the green trees and lose track of time while enjoying the scenic beauty of the place.");
                break;

            case 3:
                img.setImageResource(R.drawable.kadri);
                title.setText("Kadri Temple");
                placeDesc.setText("the chief deity of this temple is Manjunatha, which incorporates a Shiva linga. The statue of Lokeshwara in the seated position with three faces and six arms is tipped to be the best bronze statue in India.");
                break;

            case 4:
                img.setImageResource(R.drawable.nisarga);
                title.setText("Pilikula Nisargadham");
                placeDesc.setText("Pilikula Nisargadhama is a multi-purpose tourist attraction, at Vamanjoor, eastern part of Mangalore city in Karnataka, managed by the District Administration of Dakshina Kannada. It is a major tourist attraction.");
                break;

            case 5:
                img.setImageResource(R.drawable.managaladevi);
                title.setText("Mangaldevi Temple");
                placeDesc.setText("The Mangaladevi Temple is dedicated to Hindu god Shakti. The city of Mangalore is named after the presiding deity, Mangaladevi.");
                break;

            case 6:
                img.setImageResource(R.drawable.kateel);
                title.setText("Kateel Temple");
                placeDesc.setText("Kateel or Kateelu is a temple town in the Dakshina Kannada district of the Indian state of Karnataka. It is considered one of the holiest Hindu temple towns in India. It is situated on the banks of the river Nandini.");
                break;

            case 7:
                img.setImageResource(R.drawable.sulthan);
                title.setText("Sultan Battery");
                placeDesc.setText("The Sultan Bateri watch tower, constructed in 1784 by Tipu Sultan is in Boloor, 4 km from the centre of Mangalore city, the chief port city in the state of Karnataka, India.");
                break;
        }

    }
}