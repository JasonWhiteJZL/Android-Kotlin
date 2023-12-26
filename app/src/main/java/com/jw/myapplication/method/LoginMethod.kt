package com.jw.myapplication.method

/**
 * Created with IntelliJ IDEA.
 * @Author: jzl
 * @Date: 2023/12/25/10:17 PM
 * @Description:
 */
class LoginMethod {
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

