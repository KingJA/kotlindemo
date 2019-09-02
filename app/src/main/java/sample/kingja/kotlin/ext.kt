package sample.kingja.kotlin

import android.content.Context
import android.widget.TextView
import android.widget.Toast

/**
 * Description:TODO
 * Create Time:2019/9/2 0002 下午 3:24
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun TextView.showText(value: String) {
    this.text = value
}