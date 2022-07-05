package com.example.gads_lp1dd_afm_vp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.PopupMenu
import android.widget.Toast
import com.example.gads_lp1dd_afm_vp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.button)
//        popMenu()


    }


    ////////////////////////////

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater

        inflater.inflate(R.menu.context_menu_floating, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.cm1 -> {
                Toast.makeText(applicationContext, "CM1", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.cm2 -> {
                Toast.makeText(applicationContext, "CM2", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.cm3 -> {
                Toast.makeText(applicationContext, "CM3", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }


    }

//    private fun popMenu() {
//        val popupMenu = PopupMenu(applicationContext, binding.button)
//        popupMenu.inflate(R.menu.context_menu_floating)
//        popupMenu.setOnMenuItemClickListener {
//
//          when(it.itemId){
//
//              R.id.cm1 -> {
//                  Toast.makeText(applicationContext, "CM1", Toast.LENGTH_SHORT).show()
//                  true
//              }
//
//              R.id.cm2 -> {
//                  Toast.makeText(applicationContext, "CM2", Toast.LENGTH_SHORT).show()
//                  true
//              }
//
//              R.id.cm3 -> {
//                  Toast.makeText(applicationContext, "CM3", Toast.LENGTH_SHORT).show()
//                  true
//              }
//              else -> true
//          }
//
//
//
//        }
//
//        binding.button.setOnLongClickListener {
//
//            try {
//
//                val popup = PopupMenu::class.java.getDeclaredField("mPopup")
//                popup.isAccessible = true
//                val menu = popup.get(popupMenu)
//                menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
//                    .invoke(menu, true)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }finally {
//                popupMenu.show()
//            }
//
//            true
//        }
//
//    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.first -> {
                Toast.makeText(this, "0000", Toast.LENGTH_SHORT).show()

                item.isChecked = !item.isChecked
            }
            R.id.second -> {
                Toast.makeText(this, "0000", Toast.LENGTH_SHORT).show()

                item.isChecked = !item.isChecked
            }
            R.id.third -> {
                Toast.makeText(this, "0000", Toast.LENGTH_SHORT).show()

                item.isChecked = !item.isChecked
            }
            R.id.fourth -> {
                Toast.makeText(this, "0000", Toast.LENGTH_SHORT).show()

                item.isChecked = !item.isChecked
            }


            else -> super.onOptionsItemSelected(item)

        }

        return super.onOptionsItemSelected(item)
    }


}