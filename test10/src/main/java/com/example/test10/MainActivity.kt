package com.example.test10

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.test10.databinding.ActivityMainBinding
import java.time.Month
import java.time.Year

class MainActivity : AppCompatActivity() {

    //얼럿창에서 버튼 기능 추가 함수
    val eventHandler = object  : DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            if (which == DialogInterface.BUTTON_POSITIVE){
                Toast.makeText(this@MainActivity, "토스트 띄우기", Toast.LENGTH_SHORT).show()
            }else if(which == DialogInterface.BUTTON_NEGATIVE){
                Toast.makeText(this@MainActivity, "취소 토스트 띄우기", Toast.LENGTH_SHORT).show()
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.R)
    fun showTest(){
        val toast3 = Toast.makeText(this,"메세지 내용", Toast.LENGTH_SHORT)
        toast3.addCallback(
            object : Toast.Callback() {
                override fun onToastHidden() {
                    super.onToastHidden()
                    Log.d("홍길동", "toast hidden, 숨겨진 후 추가 기능 동작")
                }
                override fun onToastShown() {
                    super.onToastShown()
                    Log.d("홍길동", "toast show, 보여진 후 추가 기능 동작")
                }
            }
        )
        toast3.show()
    }
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //퍼미션
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){
            isGranted ->
            if(isGranted){
                Log.d("홍길동", "승인됨")
            }else{
                Log.d("홍길동", "승인안됨")
            }
        }

        val status = ContextCompat.checkSelfPermission(this,"android.permission.ACCESS_FINE_LOCATION")
        if(status == PackageManager.PERMISSION_GRANTED){
            Log.d("홍길동", "status 승인됨")
        }else{
            requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")
        }

        //토스트 알림 방식1
        val toast = Toast.makeText(this,"메세지 내용", Toast.LENGTH_SHORT)
        binding.toastbtn.setOnClickListener {
            toast.show()
        }

        //토스트 알림 방식2
        val toast2 = Toast.makeText(this,"메세지 내용", Toast.LENGTH_SHORT)
        binding.toastbtn2.setOnClickListener {
            Toast.makeText(this,"메세지 내용2", Toast.LENGTH_SHORT).show()
        }

        binding.toastbtn3.setOnClickListener {
            showTest()
        }

        //날짜 다이얼 로그 띄우기, 콘솔 또는 토스트 메세지
        binding.btnDate.setOnClickListener {
            //DatePickerDialog(this, 리스너, 년도, 월, 일).show
            DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int){
                    Log.d("홍길동", "year $year, month : ${month+1}, dayOfMonth: $dayOfMonth")
                    Toast.makeText(this@MainActivity, "$year 년 ${month+1} 월 $dayOfMonth 일", Toast.LENGTH_SHORT).show()
                }
            }, 2023, 5, 15).show()
        }

        //시간 다이얼그램 띄우기, 토스트 메세지
        binding.btnTime.setOnClickListener {
            TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Log.d("홍길동", "$hourOfDay 시 $minute 분")
                    Toast.makeText(this@MainActivity, "$hourOfDay 시 $minute 분", Toast.LENGTH_SHORT).show()
                }
            }, 15,30, true).show()
        }

        //얼럿 창 띄우기
        binding.btnAlert.setOnClickListener{
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("테스트 제목")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("토스트 메세지 띄울까요?")
                setPositiveButton("확인", eventHandler)
                setNegativeButton("취소", eventHandler)
                show()
            }
        }

        //메뉴선택 다이얼로그
        binding.btnMenu.setOnClickListener{
            val items = arrayOf<String>("사과", "복숭아", "딸기", "수박")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("과일 메뉴 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setItems(
                    items,
                    object : DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("홍길동", "선택한 과일 : ${items[which]}")
                        }
                    }
                )
                setPositiveButton("닫기", null)
                show()

            }
        }

        //다중선택 다이얼로그
        binding.btnCheck.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "딸기", "수박")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("check 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setMultiChoiceItems(
                    items,
                    booleanArrayOf(true, false, false, false),
                    object : DialogInterface.OnMultiChoiceClickListener{
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            Log.d(
                                "홍길동", "선택한 과일 : ${items[which]} ${if (isChecked)"선택" else "선택해제"}"
                            )
                        }
                    }
                )
                setPositiveButton("닫기", null)
                setCancelable(true)
                show()
            }.setCanceledOnTouchOutside(true)
        }

        binding.btnSingle.setOnClickListener {
            val items = arrayOf<String>("사과", "복숭아", "딸기", "수박")
            AlertDialog.Builder(this@MainActivity).run {
                setTitle("Single 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setSingleChoiceItems(
                    items,
                    1,
                    object : DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Log.d("홍길동", "선택한 과일 : ${items[which]} 선택 되었습니다")
                        }
                    }
                )
                show()
            }
        }
        
        //소리 확인
        binding.btnSound.setOnClickListener {
            val notification : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val ringtone = RingtoneManager.getRingtone(applicationContext,notification)
            ringtone.play()
        }

    }
}