package trycatch.ex.attend.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import trycatch.ex.attend.R
import trycatch.ex.attend.util.Util

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login.setOnClickListener {
            Util.login(id.text.toString(), pw.text.toString()) {
                it?.let {
                    if (it.state == "T")
                        startActivity<MainActivity>()
                    else
                        null
                } ?: toast("아이디, 비번을 확인해주세요.")
            }
        }

    }
}
