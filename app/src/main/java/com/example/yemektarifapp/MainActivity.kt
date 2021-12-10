package com.example.yemektarifapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_ekle = findViewById(R.id.add) as Button
        val clean = findViewById(R.id.clean) as Button
        val editView = findViewById(R.id.editText) as TextView
        val listView = findViewById(R.id.listView)as ListView
        val delete = findViewById(R.id.clean)as Button
        var itemlist= arrayListOf<String>()
        var adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_multiple_choice, itemlist )

        btn_ekle.setOnClickListener{

            itemlist.add(editView.text.toString())
            listView.adapter=adapter
            adapter.notifyDataSetChanged()
            editView.clearComposingText()
        }
        clean.setOnClickListener{
            itemlist.clear()
            adapter.notifyDataSetChanged()
        }
        listView.setOnItemClickListener{
                adapterView, view, i,  l->android.widget.Toast.makeText(this,
            "Seçimin : " + itemlist.get(i),
            android.widget.Toast.LENGTH_SHORT).show()

        }

        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count -1
            while (item >=0){
                if (position.get(item)){
                    adapter.remove(itemlist.get(item))
                }
                item --
            }
            position.clear()
            adapter.notifyDataSetChanged()

        }






    }
}