package com.ev.muktaibank

import android.app.Activity
import android.content.Context
import android.database.DataSetObserver
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_menu.view.*
import kotlinx.android.synthetic.main.menu_ticket.view.*
import kotlinx.android.synthetic.main.service_ticket.view.*

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        when (intent.extras?.get("type")){
            "menu" -> {
                menu_name.text = "Menu"
                menu_lv.adapter = MyMenuViews(this, getMenu())
            }

            "services" -> {
                menu_name.text = "Services"
                menu_lv.adapter = MyServiceViews(this, getServices())
            }

            "hall_book" -> {
                menu_name.text = "Available Rooms"
                menu_lv.adapter = MyBookViews(this, getBookList())
            }
            "your_order" -> {
                menu_name.text = "Your orders"
                menu_lv.adapter = MyOrderViews(this, getOrdersList())
            }
        }




    }

    fun getMenu():Array<Items>{
        val menuList = arrayOf<Items>(
            Items("Plain Sandwitch", 75),
            Items("Grilled Sandwitch", 98),
            Items("Club Sandwitch", 100),
            Items("Spring Roll", 45),
            Items("Cheese Roll", 130),
            Items("Veg Roll", 129),
            Items("Nonveg Roll", 140),
            Items("Garlic Roll", 40),
            Items("Tandoori Paneer Tikka", 250),
            Items("Malai Paneer Tikka", 80),
            Items("Soya Tandoori Tikka", 80),
            Items("Tandoori Aloo", 180),
            Items("Punjabi Soya Chap", 180),
            Items("Hare-Bhare Kabab", 500),
            Items("Dahi ke Kabab", 200),
            Items("Shahi Paneer", 580),
            Items("Kadhai Paneer", 260),
            Items("Paneer Butter Masala", 520),
            Items("Tandoori Roti", 40),
            Items("Butter Roti", 30),
            Items("Steam Rice", 120),
            Items("Veg. Pulao", 340),
            Items("Mix Veg. Pulao", 490),
            Items("Jeera Pulao", 400),
            Items("Roti", 10),
        )
        return menuList
    }

    fun getOrdersList():Array<Items>{
        val orderList = arrayOf<Items>(
                Items("Shahi Paneer", 580),
                Items("Butter Roti", 30),
                Items("Veg. Pulao", 340),
        )
        return orderList
    }

    fun getServices():Array<Services>{
        val serviceList = arrayOf<Services>(
                Services("Book hotel for Wedding"),
                Services("Book hotel for Birthday Party"),
                Services("Book hotel for Meeting"),
                Services("Book hotel for events"),
        )
        return serviceList
    }

    fun getBookList():Array<Services>{
        val bookList = arrayOf<Services>(
                Services("Room No 103"),
                Services("Room No 202"),
                Services("Room No 300"),
                Services("Room No 409"),
                Services("Room No 606"),
                Services("Room No 709"),
                Services("Room No 708"),
        )
        return bookList
    }

    inner class MyServiceViews(private val context:Activity,private val serviceList:Array<Services>):
            ArrayAdapter<Services>(context, R.layout.service_ticket, serviceList) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = layoutInflater.inflate(R.layout.service_ticket, null, false)
            view.service_name.text = serviceList[position].serviceName.toString()
            return view
        }
    }

    inner class MyMenuViews(private val context: Activity, private val menuList:Array<Items>):
            ArrayAdapter<Items>(context, R.layout.menu_ticket, menuList){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater = LayoutInflater.from(context)
            val lsView = inflater.inflate(R.layout.menu_ticket, null, true)
            lsView.itemName.text = menuList[position].itemName.toString()
//            lsView.itemName.setOnClickListener(View.OnClickListener {
//                menu_btn.visibility = View.VISIBLE
//                Toast.makeText(this@menu, "hi", Toast.LENGTH_SHORT).show()
//            })
            lsView.price.text = menuList[position].price.toString()
            return  lsView
        }
            }

    inner class MyOrderViews(private val context:Activity,private val orderList:Array<Items>):
            ArrayAdapter<Items>(context, R.layout.service_ticket, orderList) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = layoutInflater.inflate(R.layout.menu_ticket, null, false)
            view.itemName.text = orderList[position].itemName.toString()
            view.price.text = orderList[position].price.toString()
            return view
        }
    }

    inner class MyBookViews(private val context:Activity,private val bookList:Array<Services>):
            ArrayAdapter<Services>(context, R.layout.service_ticket, bookList) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = layoutInflater.inflate(R.layout.service_ticket, null, false)
            view.service_name.text = bookList[position].serviceName.toString()
            return view
        }
    }



}