package com.a0109.sneha.contactsapplication;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.*;
import java.lang.String;
import java.lang.Object;

import static android.R.attr.data;
import static android.content.ContentValues.TAG;
import static com.a0109.sneha.contactsapplication.R.id.plain_text_input;

/**
 * Created by sneha on 21-09-2017.
 */

public class NewActivity extends Activity {
    static final int PICK_CONTACT_REQUEST = 1;
    Button myButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from new_activity.xml
        setContentView(R.layout.new_activity);
        myButton = (Button) findViewById(R.id.SaveButton);

        // Capture button clicks
        myButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

//</ create intent Contact-add >

//< get entered-data >
        /*EditText mEmailAddress = (EditText) findViewById(R.id.txtEmail);*
        EditText mPhoneNumber = (EditText) findViewById(R.id.txtTelephone);*/
                EditText mName = (EditText) findViewById(R.id.plain_text_input);
//</ get entered-data >

// Inserts an email address
                intent.putExtra(ContactsContract.Intents.Insert.NAME, mName.getText().toString());
                intent.putExtra("finishActivityOnSaveCompleted", true);
                String myInput  = String.valueOf(mName.getText().toString());
                 myInput = myInput.replace(",","");
                if (myInput.length()==0 || myInput== null ){

                    mName.setError("Name cannot be empty!");
                }

//< start form >
                startActivityForResult(intent, PICK_CONTACT_REQUEST);
//</ start form >
//--------------</ btnAdd_Contact_onClick() --------------------
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        TextView textView = (TextView) findViewById(R.id.simpleTextView);
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                textView.setText("Contact Created");
                // Do something with the contact here (bigger example below)
            }
            else{
                textView.setText("Contact Not Created");
            }
        }
    }


    // Capture button clicks

}
