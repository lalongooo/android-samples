package com.lalongooo.shareintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShareTextActivity extends Activity implements View.OnClickListener {

	private EditText editext;
	private Button btnShareText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_text);
		
		setUI();
	}
	private void setUI(){
		editext = (EditText) findViewById(R.id.editText);
		btnShareText = (Button) findViewById(R.id.btnShareText);
		
		// Set listeners
		btnShareText.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		shareText();
	}
	
	private void shareText() {
		
		String textToShare = editext.getText().toString();
		
		if(textToShare.length() > 0){
			Intent sendIntent = new Intent();
			sendIntent.setAction(Intent.ACTION_SEND);
			sendIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
			sendIntent.setType("text/plain");
			startActivity(Intent.createChooser(sendIntent, "Share to..."));			
		}else{
			Toast.makeText(getApplicationContext(), getString(R.string.share_text_not_empty_content_message), Toast.LENGTH_LONG).show();
		}

	}
	

	
}
