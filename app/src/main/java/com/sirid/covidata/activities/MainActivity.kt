package com.sirid.covidata.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sirid.covidata.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.data_list)

        fun replaceFragment(fragment: Fragment, cleanBackStack: Boolean = false) {
            if(cleanBackStack) {

            }
        }

    }
}
