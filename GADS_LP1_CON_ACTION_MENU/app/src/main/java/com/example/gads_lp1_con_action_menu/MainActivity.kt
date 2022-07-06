package com.example.gads_lp1_con_action_menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.*
import com.example.gads_lp1_con_action_menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding
    private var actionMode: ActionMode? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionTextview = binding.button


        var carsArray = resources.getStringArray(R.array.Cars)

        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, carsArray)

        binding.listView.adapter = arrayAdapter



        actionTextview.setOnLongClickListener { view ->
            // Called when the user long-clicks on someView
            when (actionMode) {
                null -> {
                    // Start the CAB using the ActionMode.Callback defined above
                    actionMode = startActionMode(actionModeCallback)!!
                    view.isSelected = true
                    true
                }
                else -> false
            }
        }


        val listView: ListView = binding.listView
        with(listView) {
            choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
            setMultiChoiceModeListener(object : AbsListView.MultiChoiceModeListener {
                override fun onItemCheckedStateChanged(mode: ActionMode, position: Int,
                                                       id: Long, checked: Boolean) {
                    // Here you can do something when items are selected/de-selected,
                    // such as update the title in the CAB
                }

                override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                    // Respond to clicks on the actions in the CAB
                    return when (item.itemId) {
                        R.id.delete -> {
                            //Do your functions here
                            Toast.makeText(application,"action mode delete",Toast.LENGTH_SHORT).show()
                            mode.finish() // Action picked, so close the CAB
                            true
                        }
                        R.id.share->{
                            //Do your functions here
                            Toast.makeText(application,"action mode share",Toast.LENGTH_SHORT).show()
                            mode.finish() // Action picked, so close the CAB
                            true
                        }
                        else -> false
                    }
                }

                override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                    // Inflate the menu for the CAB
                    val menuInflater: MenuInflater = mode.menuInflater
                    menuInflater.inflate(R.menu.context_menu, menu)
                    return true
                }

                override fun onDestroyActionMode(mode: ActionMode) {
                    // Here you can make any necessary updates to the activity when
                    // the CAB is removed. By default, selected items are deselected/unchecked.
                }

                override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                    // Here you can perform updates to the CAB due to
                    // an <code><a href="/reference/android/view/ActionMode.html#invalidate()">invalidate()</a></code> request
                    return false
                }
            })
        }

    }




    private val actionModeCallback = object : ActionMode.Callback {
        // Called when the action mode is created; startActionMode() was called
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            // Inflate a menu resource providing context menu items
            val inflater: MenuInflater = mode.menuInflater
            inflater.inflate(R.menu.context_menu, menu)
            mode.setTitle("Choose your option")
            return true
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.delete -> {
                    //Do your functions here
                    Toast.makeText(application,"action mode delete",Toast.LENGTH_SHORT).show()
                    mode.finish() // Action picked, so close the CAB
                    true
                }
                R.id.share->{
                    //Do your functions here
                    Toast.makeText(application,"action mode share",Toast.LENGTH_SHORT).show()
                    mode.finish() // Action picked, so close the CAB
                    true
                }
                else -> false
            }
        }

        // Called when the user exits the action mode
        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
        }
    }

}