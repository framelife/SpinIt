package com.example.SpinIt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Popup extends Activity {
    private String[] selection;
    Button accepting;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.popupwindow);
        TextView choice;
        Intent displayPopUp = getIntent();
       // String[] info = displayPopUp.getStringArrayExtra("info");
        String info = displayPopUp.getStringExtra("info");
        choice = (TextView)findViewById(R.id.shownPopUp);
        accepting = (Button) findViewById(R.id.yelpAccept);
        final String tempChoice = (String) choice.getText();
        final Place winningPlace = displayPopUp.getParcelableExtra("winningPlace");
        final Spin currentSpin = displayPopUp.getParcelableExtra("spin");
        final String currentGroup = displayPopUp.getStringExtra("currentGroup");
        accepting.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
//            Intent registerIntent = new Intent(Popup.this, GroupChatActivity.class);
//            startActivity(registerIntent);
            SpunPlaces sp1 = currentSpin.getPerson().getSpunPlaces();
           sp1.addPlace(winningPlace);
           currentSpin.getPerson().setSpunPlaces(sp1);

            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    if(currentGroup.equals("thisisaforbiddenchatnamedontuseitplease")){
                        Intent displayPopUp = new Intent(Popup.this, MainPageActivity.class);
                        startActivity(displayPopUp);
                    }
                    else {
                        Intent displayPopUp = new Intent(Popup.this, GroupChatActivity.class);
                        displayPopUp.putExtra("winningPlace", winningPlace);
                        displayPopUp.putExtra("groupName", currentGroup);
                        startActivity(displayPopUp);
                    }
                }
            }, 1000);

        }
    });

        super.onCreate(savedInstanceState);



        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.7), (int)(height*.5));
        String name = "Name: ";
        String address = "Address: ";
        String url = "URL: ";

        String color1 = "<font color='#000000'>Name: </font>";
        String color2 = "<font color='#000000'>Address: </font>";
        String color3 = "<font color='#000000'>URL: </font>";


        choice.setText(Html.fromHtml("<p>" + color1 + "<br>" + info + "<br>" +
                color2 + "<br>" + winningPlace.getAddress() + "<br>"
                + color3 + "<br>" + winningPlace.getURL()+ "</p>"));
//       choice.setText("Name: " + "</br>" + info + "</br>" + "Address: "  );
//        choice.setText((Html.fromHtml(name + color1)));
    }
}
