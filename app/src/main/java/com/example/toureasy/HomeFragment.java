package com.example.toureasy;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;


public class HomeFragment extends Fragment {

    View view;
    String[] source = {"KSRTC","Railway Station","Mangalore Airport"};
    String[] destin = {"Panambur Beach","Tannirbhavi Beach", "Kadri Temple", "Pilikula Nisargadham", "Mangaldevi Temple","Kateel","Sulthan Bathery"};
    TextView greetingsDisplay;
    TextView kmDetail;
    passHelper passer = new passHelper();
    DBHelper DB;
    DBHelper3 DB3;
    Dialog myDialog;
    SharedPreferences sharedPreferences;
    String Source;
    String Destin;

    AutoCompleteTextView autoCompleteTxt,autoCompleteText2;

    ArrayAdapter<String> adapterSource,adapterDestin;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home, container, false);

        DB3 =  new DBHelper3(getActivity());
        DB = new DBHelper(getActivity());
        greetingsDisplay = view.findViewById(R.id.greetingsDisplay);
        kmDetail = view.findViewById(R.id.kmDetail);

        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);

        greetingsDisplay.setText("Hello " + name);

        Button btnTour = view.findViewById(R.id.btnTour);
        Button checkFare = view.findViewById(R.id.checkFare);
        Button logOut = view.findViewById(R.id.btnLogOut);



        autoCompleteTxt = view.findViewById(R.id.auto_complete_txt);
        autoCompleteText2 = view.findViewById(R.id.auto_complete_txt2);


        myDialog = new Dialog(getActivity());




        //this
        adapterSource = new ArrayAdapter<String>(getActivity(),R.layout.source_dropdown,source);
        adapterDestin = new ArrayAdapter<String>(getActivity(), R.layout.source_dropdown, destin);

        autoCompleteTxt.setAdapter(adapterSource);
        autoCompleteText2.setAdapter(adapterDestin);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Source = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(getActivity(), "Source: "+Source, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteText2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Destin = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(getActivity(), "Destination: " + Destin, Toast.LENGTH_SHORT).show();
            }
        });

        if(sharedPreferences.getBoolean("firstRun",true)){
            new TapTargetSequence(getActivity()).targets(
                    TapTarget.forView(greetingsDisplay,"Welcome " + name,"Touring made easy! Let's take a Tour of this tour easy app.")
                            .outerCircleColor(R.color.orange)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(22)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(18)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(60),
                    TapTarget.forView(autoCompleteTxt,"Source Entry","Here you have to choose your starting location")
                            .outerCircleColor(R.color.teal_200)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(22)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(18)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(60),
                    TapTarget.forView(autoCompleteText2,"Destination Entry","Enter your destination spot")
                            .outerCircleColor(R.color.teal_200)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(22)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(18)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(60),
                    TapTarget.forView(btnTour,"Check distance", "This button will quickly display the distance you have to travel")
                            .outerCircleColor(R.color.teal_200)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(22)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(18)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(60),
                    TapTarget.forView(checkFare,"Check fare Options","Click on this button to find out all the fare options available. You can further book your uber ride or check the maps without any hastle!!")
                            .outerCircleColor(R.color.teal_200)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(22)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(18)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(60),
                    TapTarget.forView(logOut,"Log Out","You do not have to leave us but...if you still want to, then feel free to log out!We will be waiting for you")
                            .outerCircleColor(R.color.pink)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(22)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(18)
                            .descriptionTextColor(R.color.black)
                            .textColor(R.color.black)
                            .textTypeface(Typeface.SANS_SERIF)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(false)
                            .tintTarget(true)
                            .transparentTarget(true)
                            .targetRadius(60)).listener(new TapTargetSequence.Listener() {
                @Override
                public void onSequenceFinish() {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.clear();
                    editor.putBoolean("hasLoggedIn",true);
                    editor.putBoolean("firstRun",false);
                    editor.apply();
                    editor.commit();
                    Toast.makeText(getActivity(), "Awesome! Now Let's go!", Toast.LENGTH_SHORT).show();
                }


                @Override
                public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {
                    Toast.makeText(getActivity(), "GREAT!", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSequenceCanceled(TapTarget lastTarget) {

                }
            }).start();

        }



        btnTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int sourceId = DB.checkSourceId(Source);
                    int destinId = DB3.checkDestinationId(Destin);
                    float distance = DB3.getDistan(sourceId,destinId);
                    String dist = Float.toString(distance);
                    kmDetail.setText(dist + " km");
//                    Toast.makeText(getActivity(), "Source Id: " + sourceId + " Destin id: " + destinId + " dist: " + distance, Toast.LENGTH_SHORT).show();
            }
        });

        checkFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Source!=null || Destin!=null){
                    int sourceId = DB.checkSourceId(Source);
                    int destinId = DB3.checkDestinationId(Destin);
                    float distance = DB3.getDistan(sourceId,destinId);
                    String dist = Float.toString(distance);

                    kmDetail.setText(dist + " km");

//                    Toast.makeText(getActivity(), Source + Destin + dist, Toast.LENGTH_SHORT).show();
                        ShowPopup(dist,distance,sourceId,destinId);
                }
                else Toast.makeText(getActivity(), "Please enter the Source and Destination", Toast.LENGTH_SHORT).show();
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.putBoolean("hasLoggedIn",false);
                editor.putBoolean("firstRun",false);
                editor.apply();
                editor.commit();
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"Succesfully Logged out",Toast.LENGTH_SHORT).show();
            }
        });
        





        return view;
    }

    public void ShowPopup(String dist,float distance,int sid,int did){
        TextView txtclose,popUpkm;
        Button btnMaps,btnUber;
        myDialog.setContentView(R.layout.custompopup);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        popUpkm = (TextView) myDialog.findViewById(R.id.popUpkm);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
        popUpkm.setText(dist + "km");
        CalculateBus(distance);

        btnMaps = (Button) myDialog.findViewById(R.id.btnMaps);
        btnUber = (Button) myDialog.findViewById(R.id.btnUber);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mapString = DB3.getMapLink(sid,did);
                Uri uri = Uri.parse(mapString);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        btnUber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uberString = DB3.getUberLink(sid,did);
                Uri uri = Uri.parse(uberString);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

        myDialog.show();
    }

    public void CalculateBus(float distance){
        TextView busCost;
        busCost = (TextView) myDialog.findViewById(R.id.busCost);
        float amount = (float) (distance*1.5);
        busCost.setText("Rs. "+Integer.toString((int)amount));
//        return amount;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}