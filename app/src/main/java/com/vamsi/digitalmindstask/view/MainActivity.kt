package com.vamsi.digitalmindstask

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var stateDistrictDataViewModel: StateDistrictDataViewModel
    private var stateDistrictList: List<StateDistricsWiseData>? = null
    private var statesDataAdapter: StatesDataAdapter? = null
    private var itemsListView: RecyclerView? = null
    var progressDialog: ProgressDialog? = null
    var progressLayout: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressLayout = findViewById(R.id.progresslayout)
        progressDialog = ProgressDialog(this@MainActivity)
        itemsListView = findViewById(R.id.listItemsView)
        stateDistrictDataViewModel =
            ViewModelProvider(this).get(StateDistrictDataViewModel::class.java)
        getAllDataFromServer()
    }

    private fun getAllDataFromServer() {
        showProgress()
        stateDistrictDataViewModel.getStateDistrictData().observe(this, Observer {
            closeProgress()
            if (it != null) {
                stateDistrictList = it
                statesDataAdapter = StatesDataAdapter()
                statesDataAdapter!!.setListToAdapter(stateDistrictList!!)
                itemsListView!!.adapter = statesDataAdapter
                itemsListView!!.layoutManager = LinearLayoutManager(this)
            }
        })
    }

    private fun showProgress() {
        progressLayout!!.visibility = View.VISIBLE
        itemsListView!!.visibility = View.GONE
    }

    private fun closeProgress() {
        progressLayout!!.visibility = View.GONE
        itemsListView!!.visibility = View.VISIBLE
    }
}