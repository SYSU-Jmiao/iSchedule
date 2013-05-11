package com.android.iSchedule;

import java.sql.Date;
import java.text.SimpleDateFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class Main extends Activity {
	
	public ImageButton menuButton;
	public Button datePickButton;
	public ImageButton addEventButton;
	public ListView eventList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		menuButton = (ImageButton) this.findViewById(R.id.Menu);
		datePickButton = (Button) this.findViewById(R.id.datePick);
		addEventButton = (ImageButton) this.findViewById(R.id.addEvent);
		eventList = (ListView) this.findViewById(R.id.Event);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy��MM��dd��");
		Date curDate = new Date(System.currentTimeMillis());
		String curDateString = formatter.format(curDate);
		
		String [] item = {curDateString+"֮ǰ���ճ�", "�ճ�1", "�ճ�1", "�ճ�1", "�ճ�1", "�ճ�1", "�ճ�1", "�ճ�1", "�ճ�1", "�ճ�1", "�ճ�2", curDateString+"֮����ճ�"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item); 
		eventList.setAdapter(adapter);
		
		datePickButton.setText(curDateString);
		
		
		addEventButton.setOnClickListener(addOnClick);
	}
	
	public OnClickListener addOnClick = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO �Զ����ɵķ������
			Intent intent=new Intent();
    		intent.setClass(Main.this,AddEvent.class);
    		startActivity(intent);
		}
	};
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
