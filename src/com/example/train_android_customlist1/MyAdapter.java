package com.example.train_android_customlist1;

import java.util.ArrayList;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.train_android_customlist1.Employee;

public class MyAdapter extends ArrayAdapter<Employee> {

	Activity context = null;
	int mLayout;
	ArrayList<Employee>myArrayList = null;

	public MyAdapter(Activity context, int resource,ArrayList<Employee>arr) {
		super(context, resource,arr);
		this.context = (Activity) context;
		this.myArrayList = arr;
		this.mLayout = resource;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = context.getLayoutInflater();

		convertView = inflater.inflate(mLayout,null);
		final TextView name = (TextView) convertView.findViewById(R.id.txtitem);
		final ImageView imag = (ImageView) convertView.findViewById(R.id.imgitem);

		Employee emp = myArrayList.get(position);
		 name.setText(emp.getHoten());
		if (emp.isGioitinh()) {
			imag.setImageResource(R.drawable.lu);
		} else {
			imag.setImageResource(R.drawable.na);
		}

		return convertView;
	}
}
