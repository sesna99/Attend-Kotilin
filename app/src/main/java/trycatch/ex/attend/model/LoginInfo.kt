package trycatch.ex.attend.model

import com.google.gson.annotations.SerializedName

/**
 * Created by trycatch on 2017. 9. 19..
 */

class LoginInfo {
    @SerializedName("moco")
    val moco: String? = null
    @SerializedName("data")
    val data: Data? = null
    @SerializedName("state")
    val state: String? = null
    @SerializedName("msg")
    val msg: String? = null
    @SerializedName("idno")
    val idno: String? = null
    @SerializedName("pass")
    val pass: String? = null
    @SerializedName("info")
    val info: String? = null

    inner class Data {
        @SerializedName("idno")
        val idno: String? = null
        @SerializedName("camp")
        val camp: String? = null
        @SerializedName("iddi")
        val iddi: String? = null
        @SerializedName("idco")
        val idco: String? = null
        @SerializedName("sdco")
        val sdco: String? = null
        @SerializedName("name")
        val name: String? = null
        @SerializedName("unnm")
        val unnm: String? = null
        @SerializedName("psco")
        val psco: String? = null
        @SerializedName("psnm")
        val psnm: String? = null
        @SerializedName("dmre")
        val dmre: String? = null
        @SerializedName("phno")
        val phno: String? = null
        @SerializedName("mjor")
        val mjor: String? = null
        @SerializedName("mobc")
        val mobc: String? = null
        @SerializedName("mobd")
        val mobd: String? = null
        @SerializedName("mols")
        val mols: String? = null
        @SerializedName("uuid")
        val uuid: String? = null
        @SerializedName("moco")
        val moco: String? = null
        @SerializedName("plat")
        val plat: String? = null
        @SerializedName("isdt")
        val isdt: String? = null
        @SerializedName("wknm")
        val wknm: String? = null
        @SerializedName("updt")
        val updt: String? = null
        @SerializedName("cmnt")
        val cmnt: String? = null
        @SerializedName("byps")
        val byps: String? = null
        @SerializedName("priv")
        val priv: String? = null
        @SerializedName("time")
        val time: String? = null
        @SerializedName("total")
        val total: String? = null
    }
}
