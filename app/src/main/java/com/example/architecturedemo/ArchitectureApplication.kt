package com.example.architecturedemo

//import com.example.architecturedemo.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ArchitectureApplication : DaggerApplication() {
//    override fun applicationInjector() =
//        DaggerApplicationComponent.builder().application(this).build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}