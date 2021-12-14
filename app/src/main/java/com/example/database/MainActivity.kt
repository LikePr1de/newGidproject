package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var myadapter = MyAdapter()
    private lateinit var appDatabase: AppDatabase
    private lateinit var dao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.adapter = myadapter
        appDatabase = Room.databaseBuilder(this,
            AppDatabase::class.java,
        "users.db"
        )
            .createFromAsset("users.db")
            .allowMainThreadQueries()
            .build()

        dao = appDatabase.userDao()
        setmodel()

        btnsearch.setOnClickListener{
            if (edtsearch.text.toString().isEmpty()){
                var dialog = AlertDialog.Builder(
                    this,
                ).setTitle("Error")
                    .setPositiveButton("Yes"){
                        dialog, which->{
                        dialog.dismiss()
                        }
                    }
                    .setMessage("Id kiriting")
                    .show()
            }else {
                var user = dao.getData(edtsearch.text.toString().toInt())
                var list:MutableList<User> = mutableListOf()
                list.add(user)
                myadapter.model = list
            }
        }

    }
    fun setmodel(){
        myadapter.model = dao.getAll().toMutableList()
    }
}