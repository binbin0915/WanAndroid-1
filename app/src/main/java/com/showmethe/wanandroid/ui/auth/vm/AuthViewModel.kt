package com.ken.materialwanandroid.ui.auth.vm

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.ken.materialwanandroid.entity.Auth
import com.ken.materialwanandroid.entity.Empty
import com.showmethe.wanandroid.ui.auth.repository.AuthRepository
import showmethe.github.core.base.BaseViewModel
import showmethe.github.core.base.InjectOwner
import showmethe.github.core.http.coroutines.Result



class AuthViewModel(application: Application) : BaseViewModel(application) {

    @InjectOwner
    val repository = AuthRepository()

    val register = MutableLiveData<Result<Empty>>()
    val auth = MutableLiveData<Result<Auth>>()

    override fun onViewModelCreated(owner: LifecycleOwner) {

    }

    /**
     * 登录
     */
    fun login(username:String,password:String){
        repository.login(username, password, auth)
    }

    /**
     * 注册
     */
    fun register(username:String,password:String){
        repository.register(username, password, register)
    }
}