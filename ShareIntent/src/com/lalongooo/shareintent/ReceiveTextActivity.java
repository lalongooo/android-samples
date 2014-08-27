package com.lalongooo.shareintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveTextActivity extends Activity {

	private TextView txtReceiveText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_receive_text);
		
	    Intent intent = getIntent();
	    String action = intent.getAction();
	    String type = intent.getType();
	    
	    setUI();

	    if (Intent.ACTION_SEND.equals(action) && type != null) {
	        if ("text/plain".equals(type)) {
	            handleSendText(intent); // Handle text being sent
	        } else {
				Toast.makeText(getApplicationContext(), getString(R.string.receive_text_mime_type_null), Toast.LENGTH_LONG).show();
	        }
	    } else {
			Toast.makeText(getApplicationContext(), getString(R.string.receive_text_action_unsupported_mime_type_null), Toast.LENGTH_LONG).show();
	    }

	}

	private void setUI() {
		txtReceiveText = (TextView) findViewById(R.id.txtReceiveText);
	}
	
	private void handleSendText(Intent intent) {
	    String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
	    if (sharedText != null) {
	    	txtReceiveText.setText(sharedText);
	    }
	}


}
