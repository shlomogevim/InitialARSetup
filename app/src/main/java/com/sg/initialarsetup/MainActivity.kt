package com.sg.initialarsetup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

private const val BOOTOM_SHEET_PEEK_HIGHT = 50f

class MainActivity : AppCompatActivity() {
    private val models= mutableListOf(
        Model(R.drawable.chair,"Chair",R.raw.chair),
        Model(R.drawable.oven,"Oven",R.raw.oven),
        Model(R.drawable.piano,"Piano",R.raw.piano),
        Model(R.drawable.table,"Table",R.raw.table)



    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomSheet()
        setupRecyclerView()
    }
    private fun setupRecyclerView(){
        rvModels.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvModels.adapter=ModelAdapter(models)
    }

    private fun setupBottomSheet() {
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.peekHeight =
            TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                BOOTOM_SHEET_PEEK_HIGHT,
                resources.displayMetrics
            ).toInt()
        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {


            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                bottomSheet.bringToFront()
            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
        })
    }
}