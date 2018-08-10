package trycatch.ex.attend.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import trycatch.ex.attend.R
import trycatch.ex.attend.util.Util

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Util.atdcInfo {
            it?.let { info ->
                if(info.state == "T"){
                    info.data.let {
                        Glide.with(applicationContext).load("https://smart.hansung.ac.kr/profile_image?u=${it?.prco}").into(profile)
                        lec_name.text = it?.sjnm
                        lec_room.text = it?.rmnm
                        lec_time.text = it?.date
                        lec_pro.text = it?.prnm
                    }
                    attend.setOnClickListener {
                        Util.atdcChk(info) {
                            toast("${it?.message}")
                        }
                    }
                }
                else {
                    null
                }
            } ?: toast("수업 정보가 없습니다.")
        }

    }
}