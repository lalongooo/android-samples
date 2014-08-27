package com.lalongooo.shareintent;

import com.lalongooo.shareintent.constants.Samples;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
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
				Samples.SHARE_TEXT
				};

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		
		lvSamplesList.setAdapter(adapter);
		lvSamplesList.setOnItemClickListener(oicl);
	}
	
	OnItemClickListener oicl = new  OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			
			String text = (String) ( (TextView) view ).getText();
			
			if(text.equals(Samples.SHARE_TEXT)){
				startActivity(ShareTextActivity.class);
			}
		}

	};
	
	private void startActivity(Class<? extends Activity> c) {
		Intent intent = new Intent(this, c);
		startActivity(intent);	
	}
	
	
}
