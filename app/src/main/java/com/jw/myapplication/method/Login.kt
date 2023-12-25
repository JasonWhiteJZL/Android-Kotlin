package com.jw.myapplication.method

import android.content.Intent
import androidx.compose.ui.platform.LocalContext
import com.jw.myapplication.MainActivity

/**
 * Created with IntelliJ IDEA.
 * @Author: jzl
 * @Date: 2023/12/25/10:17 PM
 * @Description:
 */
class Login {
    open fun login(account : String,pwd : String):Boolean
    {
        if(account.equals("123456") && pwd.equals("123456"))
        {
            return true
        }else{
            return false
        }
    }
}

