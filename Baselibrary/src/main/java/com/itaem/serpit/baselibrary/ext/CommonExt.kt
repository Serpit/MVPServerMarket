package com.itaem.serpit.baselibrary.ext

import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.baselibrary.rx.BaseFunc
import com.example.baselibrary.rx.BaseFuncBoolean
import com.example.baselibrary.rx.BaseSubscriber
import com.itaem.serpit.baselibrary.data.protocol.BaseResp
import com.kotlin.base.widgets.DefaultTextWatcher
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by Administrator on 2018/2/3 0003.
 */

fun  <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFunc())
}


fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(BaseFuncBoolean())
}
fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>,lifeCycleProvider:LifecycleProvider<*>) {
    this.observeOn(AndroidSchedulers.mainThread())
            .compose(lifeCycleProvider.bindToLifecycle())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)
}
fun View.onClick(listener: View.OnClickListener){
    this.setOnClickListener(listener)
}
fun View.onClick(method:()-> Unit){
    this.setOnClickListener{method()}
}

fun Button.enable(et: EditText, method : ()->Boolean){
    val btn = this
    et.addTextChangedListener(object : DefaultTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            btn.isEnabled = method()
        }
    })
}