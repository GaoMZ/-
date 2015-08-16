package com.example.datetimepicker;

import java.util.Calendar;

import android.support.v7.app.ActionBarActivity;
import android.text.format.Time;
import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.provider.ContactsContract.RawContacts.Data;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.example.datetimepicker.*;

public class MainActivity extends  ActionBarActivity{

	private DatePicker datePicker;
	private	TimePicker timePicker;
	private Calendar cal;//Java�е�������
	private  int month;
	private int year;
	private int day;
	private int hour;
	private int minute;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ȡ������һ������
		cal=Calendar.getInstance();
		//��ȡ�����շ������Ϣ
		year=cal.get(Calendar.YEAR);
		month=cal.get(Calendar.MONTH)+1;//����Java��Calendar�����·ݴ�0��ʼ
		day=cal.get(Calendar.DAY_OF_MONTH);
		hour=cal.get(Calendar.HOUR_OF_DAY);
		minute=cal.get(Calendar.MINUTE);
		//���ñ�����
		setTitle(year+"-"+month+"-"+day+"-"+hour+":"+minute);
		datePicker=(DatePicker) findViewById(R.id.datePicker);
		timePicker=(TimePicker) findViewById(R.id.timePicker);
		//��dataPicker��timePicker���г�ʼ��
		datePicker.init(year, month, day, new OnDateChangedListener(){

			@Override
			public void onDateChanged(DatePicker view, int year,
					int monthOfYear, int dayOfMonth) {
				// TODO Auto-generated method stub
				setTitle(year+"-"+monthOfYear+"-"+dayOfMonth+"-"+hour+":"+minute);
			}
			
			
		});//���ĸ�����Ϊ�����Ƿ�仯�ļ�����

	timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
		
		@Override
		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			setTitle(hourOfDay+":"+minute);
		}
	});

	//ʹ��DatePickerDialogʵ������ѡ��Ի���
	
/*	new DatePickerDialog(this, new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			setTitle(year+"-"+monthOfYear+"-"+dayOfMonth+"-"+hour+":"+minute);
		}
	}, year, cal.get(Calendar.MONTH), day).show();
*/	
	//ʹ��TimePickerDialogʵ��ʱ��ѡ��Ի���
	new TimePickerDialog(this, new OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			setTitle(hourOfDay+":"+minute);
		}
	}, hour, minute, true).show();
	
	}
}
