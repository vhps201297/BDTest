package com.example.bdtest.components

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import java.util.*

class DataFragment: DialogFragment() {
    private var listener: DatePickerDialog.OnDateSetListener? = null
    lateinit var context: AppCompatActivity

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(context, listener, year, month, day)
    }

    companion object {
        fun newInstance(context: AppCompatActivity, listener: DatePickerDialog.OnDateSetListener): DataFragment {
            val fragment = DataFragment()
            fragment.listener = listener
            fragment.context = context
            return fragment
        }
    }
}