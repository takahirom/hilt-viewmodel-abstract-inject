package com.github.takahirom.hilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityRetainedComponent

abstract class MainViewModel : ViewModel() {
    abstract fun onClick()
}

class MainViewModelImpl @ViewModelInject constructor() : MainViewModel() {
    override fun onClick() {
        TODO("Not yet implemented")
    }
}

@InstallIn(ActivityRetainedComponent::class)
@Module
interface Module {
    @Binds
    fun provideMainViewModel(viewModel: MainViewModelImpl): MainViewModel
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(viewModel)
    }
}