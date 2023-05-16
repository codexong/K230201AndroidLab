package com.example.test11

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test11.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    // 뷰바인딩 기법으로 해당 뷰 객체를 선택하기 위한 도구
    //함수 밖에 선언만 되었고 실제로 onCreateView함수로 화면을 그릴 때  binding을 사용할 때 초기화 됨
    lateinit var binding: FragmentOneBinding
    //실제로 프래그먼트가 화면에 그려지는 함수
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }
}