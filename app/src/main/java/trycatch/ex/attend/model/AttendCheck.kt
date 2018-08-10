package trycatch.ex.attend.model

import com.google.gson.annotations.SerializedName

/**
 * Created by trycatch on 2017. 9. 18..
 */

data class AttendCheck(
    val message: String?,
    val check: String?,
    val psco: String?,
    val state: String?,
    val mac: String?,
    val uuid: String?,
    val date: String?,
    val msg: String?,
    val iden: String?,
    val sjco: String?
)
