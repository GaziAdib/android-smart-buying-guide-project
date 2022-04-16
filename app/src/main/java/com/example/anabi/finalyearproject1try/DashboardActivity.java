package com.example.anabi.finalyearproject1try;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anabi.finalyearproject1try.BloggerApiPosts.BloggerMainActivity;
import com.example.anabi.finalyearproject1try.FireBaseBackend.activity.DatabaseDashboardActivity;
import com.example.anabi.finalyearproject1try.FireBaseBackend.registration.LoginActivity;
import com.example.anabi.finalyearproject1try.GroupChatWorld.GroupListOfGroups;
import com.example.anabi.finalyearproject1try.QRCodeScanner.BarCodeScannerMain;
import com.example.anabi.finalyearproject1try.YoutubeSupport.YoutubeMain;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class DashboardActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference RootRef;
    String currentUserID;

    SliderLayout sliderLayout;

    Vibrator vibrator;

    Toolbar toolbar;

    private CardView smartphoneCardView,desktopCardView,tvCardView,laptopCardView,youtubeCardView,youtubeExpertCardView,originalVsDuplicateCard,currencyConvertCard, gotoDatabasePost,scannerPost;

    // fab

    private FloatingActionButton fab_main, fab1_mail, fab2_share;
    private Animation fab_open, fab_close, fab_clock, fab_anticlock;
    TextView textview_mail, textview_share;

    Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        toolbar = findViewById(R.id.dashboard_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.my_smart_app_main_logo);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setTitle("Smart");




        smartphoneCardView = (CardView) findViewById(R.id.mainSmartphoneCardViewId);
        desktopCardView = (CardView) findViewById(R.id.mainDesktopCardViewId);
        tvCardView = (CardView)findViewById(R.id.mainTVCardViewId);
        laptopCardView = (CardView)findViewById(R.id.mainLaptopCardViewId);

        youtubeCardView = (CardView)findViewById(R.id.myYoutubeSupportId);
        youtubeExpertCardView = (CardView)findViewById(R.id.youtubeExpertCardViewId);
        originalVsDuplicateCard = (CardView)findViewById(R.id.originalVsDuplicateCardId);
        currencyConvertCard = (CardView)findViewById(R.id.currencyConvertCardId);

        gotoDatabasePost = (CardView) findViewById(R.id.go_to_database_dashboard);
        scannerPost = (CardView) findViewById(R.id.scannerPost);

        mAuth =FirebaseAuth.getInstance(); // used for just sign out dummy testing
        //new

        currentUserID = mAuth.getCurrentUser().getUid();

        RootRef = FirebaseDatabase.getInstance().getReference();



        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        sliderLayout = findViewById(R.id.imageSliderDashBoard);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(1); //set scroll delay in seconds :

        setSliderViews();

        fab_main = findViewById(R.id.fab);
        fab1_mail = findViewById(R.id.fab1);
        fab2_share = findViewById(R.id.fab2);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_clock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_clock);
        fab_anticlock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_anticlock);

        textview_mail = (TextView) findViewById(R.id.textview_mail);
        textview_share = (TextView) findViewById(R.id.textview_share);


        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen) {

                    textview_mail.setVisibility(View.INVISIBLE);
                    textview_share.setVisibility(View.INVISIBLE);
                    fab2_share.startAnimation(fab_close);
                    fab1_mail.startAnimation(fab_close);
                    fab_main.startAnimation(fab_anticlock);
                    fab2_share.setClickable(false);
                    fab1_mail.setClickable(false);
                    isOpen = false;
                } else {
                    textview_mail.setVisibility(View.VISIBLE);
                    textview_share.setVisibility(View.VISIBLE);
                    fab2_share.startAnimation(fab_open);
                    fab1_mail.startAnimation(fab_open);
                    fab_main.startAnimation(fab_clock);
                    fab2_share.setClickable(true);
                    fab1_mail.setClickable(true);
                    isOpen = true;
                }

            }
        });



        fab2_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Post", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), DatabaseDashboardActivity.class));

            }
        });

        fab1_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "QR code Scan", Toast.LENGTH_SHORT).show();
               // mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), BarCodeScannerMain.class));


            }
        });






        smartphoneCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vibrator.vibrate(70);
                Intent smartphoneIntent = new Intent(getApplicationContext(),SmartphoneSelectionTechOrBrand.class);
                startActivity(smartphoneIntent);

            }
        });



        desktopCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(70);

                Intent desktopIntent = new Intent(getApplicationContext(),DesktopActivity.class);
                startActivity(desktopIntent);
            }
        });

        tvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(70);

                Intent tvIntent = new Intent(getApplicationContext(),TvActivity.class);
                startActivity(tvIntent);

            }
        });

        laptopCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(70);

                Intent laptopIntent = new Intent(getApplicationContext(),LaptopChooseActivity.class);
                startActivity(laptopIntent);
            }
        });


        youtubeExpertCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(70);
                Intent youtubeReviewintent = new Intent(getApplicationContext(),YoutubeExpertActivityPageMain.class);
                startActivity(youtubeReviewintent);
            }
        });


        youtubeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(70);
                Intent intent = new Intent(getApplicationContext(),YoutubeMain.class);
                startActivity(intent);
            }
        });

        originalVsDuplicateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                //Intent i = new Intent(getApplicationContext(), SecurityPageContainer.class);
                Intent i = new Intent(getApplicationContext(), BloggerMainActivity.class);
                startActivity(i);
            }
        });


        currencyConvertCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(50);
                Intent i = new Intent(getApplicationContext(),CurrencyConverter.class);
                startActivity(i);
            }
        });

        gotoDatabasePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DatabaseDashboardActivity.class);
                startActivity(i);
            }
        });

        scannerPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), BarCodeScannerMain.class);
                startActivity(i);

            }
        });




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_for_main_dashboard,menu);
        return true;
    }






//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        if(item.getItemId() == R.id.group_chat_menu_id){
//
//           RequestNewGroup();
//
//
//        }
//
//
//
//        switch (item.getItemId()){
//
//            case R.id.expert_video_section_menu_id:
//                Intent expertIntent = new Intent(getApplicationContext(),YoutubeExpertActivityPageMain.class);
//                startActivity(expertIntent);
//                return true;
//
//            case R.id.my_video_section_menu_id:
//                Intent myVideoIntent = new Intent(getApplicationContext(),YoutubeExpertActivityPageMain.class);
//                startActivity(myVideoIntent);
//                return true;
//
//            case R.id.tech_blogpost_section_menu_id:
//                Intent blogPostIntent = new Intent(getApplicationContext(),BloggerMainActivity.class);
//                startActivity(blogPostIntent);
//                return true;
//
//
//            case R.id.qr_code_section_menu_id:
//                Intent qrCodeIntent = new Intent(getApplicationContext(),BarCodeScannerMain.class);
//                startActivity(qrCodeIntent);
//                return true;
//
//            case R.id.group_chat_menu_id:
//                Intent grpIntent = new Intent(getApplicationContext(), GroupListOfGroups.class);
//                startActivity(grpIntent);
//                return true;
//
//
//
//
//            case R.id.about_me_section_menu_id:
//                Intent aboutMeIntent = new Intent(getApplicationContext(),AboutMeActivity.class);
//                startActivity(aboutMeIntent);
//                return true;
//
//            case R.id.logout_me_section_menu_id:
//               mAuth.signOut();
//               startActivity(new Intent(getApplicationContext(),LoginActivity.class));
//                Toast.makeText(this, "You are logged out! click Login Button to Login again..", Toast.LENGTH_SHORT).show();
//                return true;
//
//           // case R.id.send_feedback_menu_id:
//               //RequestNewGroup();
//              // return true;
//
//
//
//        }
//
//        return super.onOptionsItemSelected(item);
//    }



    //Request new Group---

    private void RequestNewGroup(){

        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this,R.style.AlertDialog);

        builder.setTitle("Enter Group Name");

        final EditText groupNameField = new EditText(DashboardActivity.this);
        groupNameField.setHint("e.g Code Zone");
        builder.setView(groupNameField);

        builder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String groupName = groupNameField.getText().toString();

                if(TextUtils.isEmpty(groupName)){
                    Toast.makeText(DashboardActivity.this, "Please write group name", Toast.LENGTH_SHORT).show();
                }else {

                    CreateNewGroup(groupName);

                }
            }
        });


        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }
        });

        builder.show();



    }






    // Create our group


    private void CreateNewGroup(final String groupName) {

        RootRef.child("Groups").child(groupName).setValue("")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            Toast.makeText(DashboardActivity.this, groupName + " is Created successfully..", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }











    // adding switch statement


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()){

            case R.id.expert_video_section_menu_id:
                Intent expertIntent = new Intent(getApplicationContext(),YoutubeExpertActivityPageMain.class);
                startActivity(expertIntent);
                return true;

            case R.id.my_video_section_menu_id:
                Intent myVideoIntent = new Intent(getApplicationContext(),YoutubeExpertActivityPageMain.class);
                startActivity(myVideoIntent);
                return true;

            case R.id.tech_blogpost_section_menu_id:
                Intent blogPostIntent = new Intent(getApplicationContext(),BloggerMainActivity.class);
                startActivity(blogPostIntent);
                return true;


            case R.id.qr_code_section_menu_id:
                Intent qrCodeIntent = new Intent(getApplicationContext(),BarCodeScannerMain.class);
                startActivity(qrCodeIntent);
                return true;

            case R.id.group_chat_menu_id:
                RequestNewGroup();
                return true;


            case R.id.about_me_section_menu_id:
                Intent aboutMeIntent = new Intent(getApplicationContext(),AboutMeActivity.class);
                startActivity(aboutMeIntent);
                return true;

            case R.id.logout_me_section_menu_id:
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                Toast.makeText(this, "You are logged out! click Login Button to Login again..", Toast.LENGTH_SHORT).show();
                return true;

             case R.id.send_feedback_menu_id:
                 Intent i = new Intent(getApplicationContext(),SendFeedbackActivity.class);
                 startActivity(i);
                 return true;


            case R.id.group_list_activity_menu_id:
                Intent groupListIntent = new Intent(getApplicationContext(),GroupListOfGroups.class);
                startActivity(groupListIntent);
                return true;


        }

        return super.onOptionsItemSelected(item);
    }























    // slider

    private void setSliderViews() {

        for (int i = 0; i <= 10; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.desktop_dummy_slider);
                    sliderView.setDescription("Desktop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.desktop_dummy_slider2);
                    sliderView.setDescription("Desktop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.dashboard_smartphone_slider_main);
                    sliderView.setDescription("Smartphone show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.dashboard_laptop_slider);
                    sliderView.setDescription("Smartphone show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 4:
                    sliderView.setImageDrawable(R.drawable.dashboard_desktop_slider);
                    sliderView.setDescription("Smartphone show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 5:
                    sliderView.setImageDrawable(R.drawable.dashboard_tv_slider);
                    sliderView.setDescription("Laptop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 6:
                    sliderView.setImageDrawable(R.drawable.dashboard_smart_tv_slider);
                    sliderView.setDescription("Laptop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 7:
                    sliderView.setImageDrawable(R.drawable.dashboard_youtube_expert_slider);
                    sliderView.setDescription("Laptop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 8:
                    sliderView.setImageDrawable(R.drawable.dashboard_youtube_my_slider);
                    sliderView.setDescription("Laptop show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 9:
                    sliderView.setImageDrawable(R.drawable.tv_dummy_slider1);
                    sliderView.setDescription("TV show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;

                case 10:
                    sliderView.setImageDrawable(R.drawable.tv_dummy_slider2);
                    sliderView.setDescription("TV show");
                    //sliderView.setImageUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription " + (i + 1));
            final int finalI = i;
            sliderView.setOnSliderClickListener(new com.smarteist.autoimageslider.SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(com.smarteist.autoimageslider.SliderView sliderView) {
                    Toast.makeText(DashboardActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            sliderLayout.addSliderView(sliderView);


        }
    }



















}
