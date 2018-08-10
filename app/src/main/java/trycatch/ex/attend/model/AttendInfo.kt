package trycatch.ex.attend.model

import java.util.ArrayList

/**
 * Created by trycatch on 2017. 9. 12..
 */

data class AttendInfo(
        val result: ArrayList<Result>?,
        val data: Data?,
        val state: String?,
        val ssid: ArrayList<Any>?,
        val atrs: String?,
        val date: String?,
        val msg: String?,
        val idno: String?
)

data class Result(
    val ssid: String?,
    val `object`: String?,
    val msc: String? = null
)

data class Data(
    val idx: Any?,
    val yyse: String?,
    val camp: String?,
    val psco: String?,
    val sjco: String?,
    val sjnm: String?,
    val iden: String?,
    val prco: String?,
    val prnm: String?,
    val pont: String?,
    val hour: String?,
    val date: String?,
    val rmco: String?,
    val rmnm: String?,
    val path: Any?,
    val cnt: String?,
    val time: Any?,
    val type: String?
)
