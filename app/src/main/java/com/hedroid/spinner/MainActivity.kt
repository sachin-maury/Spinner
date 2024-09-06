package com.hedroid.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)
        val spinnerList:List<String> =listOf("Apple 🍏","Banana 🍌","Grapes 🍇","Guava 🥝","Juice 🥤","Cake 🎂")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,spinnerList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter =arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem:Any =parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity,"You're Selected $selectedItem",Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}