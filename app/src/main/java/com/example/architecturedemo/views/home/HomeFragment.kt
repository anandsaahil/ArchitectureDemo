package com.example.architecturedemo.views.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

import com.example.architecturedemo.R
import com.example.architecturedemo.utils.getViewModel
import com.example.architecturedemo.utils.ResourceState
import dagger.android.support.DaggerFragment
import androidx.lifecycle.Observer
import com.example.architecturedemo.ActivityIndicatorListener
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : DaggerFragment(), HomeNavigator {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var homeViewModel: HomeViewModel
    var activityIndicator: ActivityIndicatorListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel = getViewModel(viewModelFactory)
        homeViewModel.setNavigator(this)
        if (activity!! is ActivityIndicatorListener) {
            activityIndicator = activity as ActivityIndicatorListener
        }
        initObservers()
    }

    private fun initObservers(){
        homeViewModel.getAllUsersLiveData.observe(this, Observer {
            when (it?.status) {
                ResourceState.LOADING -> {
                    showActivityIndicator()
                }
                ResourceState.SUCCESS -> {
                    dismissActivityIndicator()
                }
                ResourceState.ERROR -> {
                    dismissActivityIndicator()
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setupActions()
    }

    private fun initViews() {
        homeViewModel.getAllUsers()
    }

    private fun setupActions() {

    }

    private fun showActivityIndicator() {
        activityIndicator?.showActivityIndicator()
    }

    private fun dismissActivityIndicator() {
        activityIndicator?.dismissActivityIndicator()
    }


    override fun showErrorMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
