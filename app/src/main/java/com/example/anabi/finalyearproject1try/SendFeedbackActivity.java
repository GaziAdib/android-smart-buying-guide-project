package com.example.anabi.finalyearproject1try;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendFeedbackActivity extends AppCompatActivity implements View.OnClickListener  {


    EditText nameET, messageET;
    Button sendBtn, clearBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);

        messageET = findViewById(R.id.sendMessageFeedbackId);
        nameET  = findViewById(R.id.feedbackNameEditTextId);

        sendBtn = findViewById(R.id.sendBtnId);
        clearBtn = findViewById(R.id.clearBtnId);


            sendBtn.setOnClickListener(this);
            clearBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        try {

            String name = nameET.getText().toString().trim();
            String message = messageET.getText().toString().trim();


            if(v.getId() == R.id.sendBtnId){

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"adibcse10@gmail.com","greatadib82@gmail.com"});

                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT,"Name: "+name+ "\n Message: "+message);
                startActivity(Intent.createChooser(intent,"Feedback with"));


            } else if(v.getId() == R.id.clearBtnId){

                nameET.setText("");
                messageET.setText("");
            }


        } catch (Exception e){

            Toast.makeText(this, "Exception : "+e, Toast.LENGTH_SHORT).show();

        }

    }





}
