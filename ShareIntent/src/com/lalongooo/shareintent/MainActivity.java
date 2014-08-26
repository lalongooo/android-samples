package com.lalongooo.shareintent;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private ListView lvSamplesList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lvSamplesList = (ListView) findViewById(R.id.lvSamplesList);

		String[] values = new String[]
				{
				"Text"
				};

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		
		lvSamplesList.setAdapter(adapter);
		lvSamplesList.setOnItemClickListener(oicl);
	}
	
	OnItemClickListener oicl = new  OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			
			TextView tv = (TextView) view;
			String text = (String) tv.getText();
			
			if(text.equals("Text")){
				shareText();
			}
		}
	};

	private void shareText() {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
		sendIntent.setType("text/plain");
		startActivity(sendIntent);
	}
	
	
}