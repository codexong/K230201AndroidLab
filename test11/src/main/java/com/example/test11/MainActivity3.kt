package com.example.test11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //참고 -> MainActivity338 , OneFragment, fragment_one.xml, activity_main338.xml
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        val fragment = OneFragment()
        // 각 프래그먼트들이 보여주는 하나의 틀, 프래그먼트들이 부품처럼 교체되어 보여지게 됨
        transaction.add(R.id.fragment_content, fragment)
        transaction.commit()
    }
}