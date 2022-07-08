package com.example.toureasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class exploreMore extends AppCompatActivity {
    ImageView img;
    TextView title,placeDesc;

    ImageView backBtn;
    passHelper passer = new passHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_more);

        img = (ImageView) findViewById(R.id.imageView);
        title = (TextView) findViewById(R.id.imageTitle);
        placeDesc = (TextView) findViewById(R.id.placeDesc);
        backBtn = (ImageView) findViewById(R.id.backbtn);
        int imgId = passer.getId();

        switch (imgId){
            case 1:
                img.setImageResource(R.drawable.panambur);
                title.setText("Panambur Beach");
                placeDesc.setText("Panambur Beach is a beach in the city of Mangalore in the Indian state of Karnataka.\n" +
                        "\n" +
                        "This beach is on the shores of Arabian sea and is credited as one of the safest and best maintained beaches of India. It is the most popular, well connected and the most visited beach of Karnataka.\n" +
                        "\n" +
                        "The beach is located in the place called Panambur 10 km north of the City center which comes under the administration of Mangalore City Corporation.\n" +
                        "\n" +
                        "As of now this beach is maintained by a private enterprise under the banner of Panambur Beach Tourism Development Project. Other attractions include jet ski rides, boating, dolphin viewing, food stalls and is also known for its highly skilled and trained lifeguards who patrol the beach to ensure visitor safety.\n" +
                        "\n" +
                        "This beach has been popular for its sunsets, the port area and a picnic spot for tourists and locals alike and offers views of the sunset. The beach attracts visitors due to its close proximity to the city. The ships anchored out in the sea waiting for berth in the harbor can be seen from the Beach.");
                break;

            case 2:
                img.setImageResource(R.drawable.tannibhavi);
                title.setText("Tannirbhavi Beach");
                placeDesc.setText("Tannirbhavi beach is a beach in Mangalore, Karnataka, India. It is one of the most popular tourist destinations in coastal Karnataka. Along with the beach, Sultan Battery, Tannirbavi Tree Park & the proposed Marine museum are also the tourist attractions. It can be reached either by land near Kuloor Bridge or by ferry via Gurupura river from Sultan Battery.\n" +
                        "\n" +
                        "Tannirbhavi (also spelled as Tannirbavi) is one of the popular beaches in Mangalore city, and comes second in popularity next to Panambur beach. Tannirbhavi beach has some basic facilities like lifeguards, proper toilets, a parking lot, a couple of small eateries and concrete benches.\n" +
                        "\n" +
                        "On the other side of the land strip of the beach there is a barge-mounted 220 MW power plant set up by the GMR Group. It is located at a distance of 12 km from Mangalore.");
                break;

            case 3:
                img.setImageResource(R.drawable.kadri);
                title.setText("Kadri Temple");
                placeDesc.setText("The chief deity of this temple is Manjunatha, which incorporates a Shiva linga. The statue of Lokeshwara in the seated position with three faces and six arms is tipped to be the best bronze statue in India.It is about 1.5 meter tall.\n" +
                        "\n" +
                        "There is a natural spring at an elevated location at the back of the temple. It is called Gomukha. It is believed that the water flows from Bhageerathi river, in Kashi and thereby it gets its name as Kashi Bhageerathi theertha. The water from this spring is let into nine ponds of different sizes adjacent to it. Visitors wash themselves in these ponds before entering the main temple.");
                break;

            case 4:
                img.setImageResource(R.drawable.nisarga);
                title.setText("Pilikula Nisargadham");
                placeDesc.setText("In the Tulu language, \"pili\" means tiger and \"kula\" means lake. The name Tiger Lake is because tigers used to come to this lake to drink."+
                        "\n"+
                        "Pilikula Nisargadhama (or Nisarga Dhama) is a multi-purpose tourist attraction, at Vamanjoor, eastern part of Mangalore city in Karnataka, managed by the District Administration of Dakshina Kannada. It is a major tourist attraction of Mangalore. It attracts large number of tourists due to the availability of multiple facilities.");
                break;

            case 5:
                img.setImageResource(R.drawable.managaladevi);
                title.setText("Mangaldevi Temple");
                placeDesc.setText("The Mangaladevi Temple is a Hindu temple at Bolara in the city of Mangalore in the Indian state of Karnataka, situated about three km southwest of the city centre. The temple is dedicated to Hindu god Shakti in the form of Mangaladevi. The city of Mangalore is named after the presiding deity, Mangaladevi. The temple is of significant antiquity and is believed to have been built during the 9th century by Kundavarman, the most famous king of the Alupa dynasty during the 9th century, under the patronage of Matsyendranath. As per another legend, the temple is believed to have been built by Parashurama, one of the ten avatars of Hindu god Vishnu and later expanded by Kundavarman.\n" +
                        "\n" +
                        "The temple is built in Kerala style architecture, which is common in all temples in the South Indian state of Kerala and Western Ghats, with most of its structure made of wood. The presiding deity, Mangaladevi in the central shrine is in a seated posture. There are shrines around the sanctum for other deities.\n" +
                        "\n" +
                        "In modern times, the temple is maintained and administered by trustees. The temple is open daily from 6 a.m. to 1 pm and 4 pm to 8:30 pm.");
                break;

            case 6:
                img.setImageResource(R.drawable.kateel);
                title.setText("Kateel Temple");
                placeDesc.setText("In Tulu, 'Kati' means 'center'. Kateel is midway between Kanakagiri, the source of the river, and Pavanje, where the river joins the sea. 'Ila' means area (land), thus the place is called 'Kati + lla', Kateel."+
                        "\n"+
                        "Kateel or Kateelu is a temple town in the Dakshina Kannada district of the Indian state of Karnataka. It is considered one of the holiest Hindu temple towns in India. It is situated on the banks of the river Nandini.");
                break;

            case 7:
                img.setImageResource(R.drawable.sulthan);
                title.setText("Sultan Battery");
                placeDesc.setText("The Sultan Bateri watch tower, constructed in 1784 by Tipu Sultan is in Boloor, 4 km from the centre of Mangalore city, the chief port city in the state of Karnataka, India."+"\n" + "It was the major dockyard and arsenal of the ruler. It was a naval station and was of great importance to the sultan as he used it to intercept enemy warships and prevent them from docking.");
                break;
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //need to go to exploreFragment.
                finish();
            }
        });

    }
}