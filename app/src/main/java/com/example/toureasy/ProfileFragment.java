//package com.example.toureasy;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//public class ProfileFragment extends Fragment {
//
//    View view;
//    TextView greetingsProfile,phoneProfile;
//    passHelper passR ;
//    DBHelper db;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        view= inflater.inflate(R.layout.fragment_profile, container, false);
//
//        passR = new passHelper();
//        db = new DBHelper(getActivity());
//
//        greetingsProfile = (TextView) view.findViewById(R.id.greetingsProfile);
//        phoneProfile = (TextView) view.findViewById(R.id.phoneProfile);
//
//        String username = passR.getUsername();
//        int phone = db.getPhone(username);
//
//        greetingsProfile.setText("Hello " + username  );
//        phoneProfile.setText("Phone number: " + Integer.toString(phone));
//
//
//        return view;
//    }
//}