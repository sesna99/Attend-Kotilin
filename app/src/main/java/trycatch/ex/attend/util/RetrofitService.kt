package trycatch.ex.attend.util

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.QueryMap
import trycatch.ex.attend.model.AttendCheck
import trycatch.ex.attend.model.AttendInfo
import trycatch.ex.attend.model.LoginInfo

/**
 * Created by trycatch on 2017. 9. 10..
 */

interface RetrofitService {
    @FormUrlEncoded
    @POST("/api/login_access")
    fun login(@Field("idno") idno: String?, @Field("pass") pass: String?, @Field("uuid") uuid: String?): Call<LoginInfo>

    @POST("/api/track_list")
    fun getTrack(@QueryMap query: Map<String?, String?>): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/api/atdc_info")
    fun getAtdcInfo(@Field("idno") idno: String?, @Field("date") date: String?): Call<AttendInfo>

    @FormUrlEncoded
    @POST("/api/atdc_chk")
    fun getAtdcChk(@Field("idno") idno: String?, @Field("psco") psco: String?, @Field("sjco") sjco: String?, @Field("iden") iden: String?, @Field("mac") mac: String?, @Field("date") date: String?, @Field("uuid") uuid: String?, @Field("check") check: String?): Call<AttendCheck>

}
