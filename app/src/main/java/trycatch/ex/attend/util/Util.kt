package trycatch.ex.attend.util

import android.util.Log
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import trycatch.ex.attend.model.AttendCheck
import trycatch.ex.attend.model.AttendInfo
import trycatch.ex.attend.model.LoginInfo
import java.text.SimpleDateFormat
import java.util.*

object Util: AnkoLogger {
    private val retrofit: Retrofit
    private val retrofitService: RetrofitService
    private val simpleDateFormat: SimpleDateFormat
    private var id: String? = null

    val date: String?
        get() {
            return simpleDateFormat.format(Calendar.getInstance().time)
        }

    init {
        retrofit = Retrofit.Builder().baseUrl("https://smart.hansung.ac.kr").addConverterFactory(GsonConverterFactory.create()).build()
        retrofitService = retrofit.create<RetrofitService>(RetrofitService::class.java)

        simpleDateFormat = SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault())
    }

    fun login(login_id: String, login_pw: String, callback: (LoginInfo?) -> Unit) {
        val login = retrofitService.login(login_id, login_pw, "")
        login.enqueue(object : Callback<LoginInfo> {
            override fun onResponse(call: Call<LoginInfo>, response: Response<LoginInfo>) {
                val loginInfo = response.body()
                info("Login ${loginInfo?.state ?: "F"}")
                id = loginInfo?.idno
                callback(loginInfo)
            }

            override fun onFailure(call: Call<LoginInfo>, t: Throwable) {
                callback(null)
            }
        })
    }

    fun atdcInfo(callback: (AttendInfo?) -> Unit) {
        val atdcInfo = retrofitService.getAtdcInfo(id, date)
        atdcInfo.enqueue(object : Callback<AttendInfo> {
            override fun onResponse(call: Call<AttendInfo>, response: Response<AttendInfo>) {
                info("Atdc ${response.isSuccessful}")
                callback(response.body())
            }

            override fun onFailure(call: Call<AttendInfo>, t: Throwable) {
                Log.i("RetrofitAtdc", t.toString())
                callback(null)
            }
        })
    }

    fun atdcChk(info: AttendInfo, callback: (AttendCheck?) -> Unit) {
        val data = info?.data
        val atdcChk = retrofitService.getAtdcChk(id, data?.psco, data?.sjco, data?.iden, info?.result?.get(0)?.msc, date, "", "1")
        atdcChk.enqueue(object : Callback<AttendCheck> {
            override fun onResponse(call: Call<AttendCheck>, response: Response<AttendCheck>) {
                info("RetrofitChk ${response.isSuccessful}")
                callback(response.body())
            }

            override fun onFailure(call: Call<AttendCheck>, t: Throwable) {
                callback(null)
            }
        })
    }
}
