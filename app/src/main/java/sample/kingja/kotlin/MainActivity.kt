package sample.kingja.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import java.net.URL

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn1 -> {
                doNetwork()
            }
            R.id.btn2 -> {
               tv.showText("hhhhh")

            }
            R.id.btn3 -> {
                showToast("按钮3")
            }
        }
    }

    private fun doNetwork() {
        var url = "https://www.wanandroid.com/banner/json"
        doAsync {
            val readText = URL(url).readText()
            Log.e("doNetwork",readText)
            var resultData=Gson().fromJson(readText,Result::class.java)
            val list = resultData.data
            Log.e("数量","数量:"+ (list?.size ?: 0))
            for (item:Banner in list!!) {
                Log.e("for","item:"+item.desc)
            }

        }

    }

    override fun onLongClick(v: View?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.text = "hello kingja"
        initEvent()
        Person("1",1.0f,"2").name
    }

    private fun initEvent() {
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }
}
