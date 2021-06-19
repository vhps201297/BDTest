package com.example.bdtest.room

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import com.example.bdtest.R
import com.example.bdtest.components.DataFragment

class AddTaskActivity : AppCompatActivity() {

    lateinit var datePicker: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
    }

    fun initComponents(){
        datePicker = findViewById(R.id.edtxt_date_picker)
    }

    fun onClickFragmentDate(view: View) {
        var dateFragment = DataFragment.newInstance(this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val dateSelected = "${dayOfMonth.toString()}/${month+1}/${year}"
                datePicker.setText(dateSelected)
            })
        dateFragment.show(supportFragmentManager, "datePicker")
    }
}