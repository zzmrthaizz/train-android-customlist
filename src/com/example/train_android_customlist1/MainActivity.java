package com.example.train_android_customlist1;

import java.util.ArrayList;

import android.os.Bundle;

import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.train_android_customlist1.Employee;
import com.example.train_android_customlist1.MyAdapter;

public class MainActivity extends Activity {

	MyAdapter adapter;
	ArrayList<Employee> arrayList = new ArrayList<Employee>();
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button nhap = (Button) findViewById(R.id.btnNhap);
		ImageButton xoa = (ImageButton) findViewById(R.id.btndelete);
		listView = (ListView) findViewById(R.id.lvnhanvien);
		
		final EditText ten = (EditText) findViewById(R.id.editTen);
		final EditText ma = (EditText) findViewById(R.id.editMa);
		final RadioGroup gtbButton = (RadioGroup) findViewById(R.id.radioGroup1);

		adapter = new MyAdapter(this, R.layout.item_list, arrayList);
		
		
		adapter.addAll(arrayList);
		listView.setAdapter(adapter);

		nhap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String hoten = String.valueOf(ten.getText() + "");
				String manv = String.valueOf(ma.getText() + "");

				boolean gioitinh;
				if (gtbButton.getCheckedRadioButtonId() == R.id.radNu) {
					
					gioitinh = true;
					Employee employee = new Employee();
					employee.setHoten(hoten);
					employee.setMaso(manv);
					employee.setGioitinh(gioitinh);
					arrayList.add(employee);
					adapter.notifyDataSetChanged();

					ten.setText("");
					ma.setText("");
					ma.requestFocus();
				}

				else if (gtbButton.getCheckedRadioButtonId() == R.id.radNam) {
					gioitinh = false;
					Employee employee = new Employee();
					employee.setHoten(hoten);
					employee.setMaso(manv);
					employee.setGioitinh(gioitinh);
					
					arrayList.add(employee);
					adapter.notifyDataSetChanged();

					ten.setText("");
					ma.setText("");
					ma.requestFocus();
				}

			}
		});
		
		xoa.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				for (int i = 0; i < listView.getChildCount(); i++) {
					View v = listView.getChildAt(i);
					CheckBox checkBox = (CheckBox) v.findViewById(R.id.chkitem);
					if (checkBox.isChecked()) {
						arrayList.remove(i);
					}
				}
				adapter.notifyDataSetChanged();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
