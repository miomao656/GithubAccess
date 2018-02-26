package com.mio.githubaccess.view.ui.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.ConnectivityManager.CONNECTIVITY_ACTION
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.mio.githubaccess.injection.components.AppComponent
import com.mio.githubaccess.injection.modules.ActivityModule
import com.mio.githubaccess.view.GitHubAccessApp


/**
 * Base [android.app.Activity] class for every Activity in this application.
 */
abstract class BaseActivity : AppCompatActivity() {

  private val connectionReceiver: BroadcastReceiver = object : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
      if (intent?.action == CONNECTIVITY_ACTION && isInitialStickyBroadcast.not()) {
        onConnectionChange(isNetworkAvailable(this@BaseActivity))
      }
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    registerReceiver(connectionReceiver, IntentFilter(CONNECTIVITY_ACTION))
  }

  abstract fun onConnectionChange(isOnline: Boolean)

  override fun onDestroy() {
    super.onDestroy()
    unregisterReceiver(connectionReceiver)
  }

  /**
   * Get the Main Application component for dependency injection.

   * @return [AppComponent]
   */
  protected val appComponent: AppComponent get() = (application as GitHubAccessApp).appComponent

  /**
   * Replace current Fragment with new one.
   */
  protected fun replaceFragment(newFragmentLayoutId: Int, newFragment: Fragment) {
    // Add the getOptionsDrawerFragment to the activity, pushing this transaction on to the
    // back stack.
    supportFragmentManager.beginTransaction().apply {
      setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
      replace(newFragmentLayoutId, newFragment)
    }.commit()
  }

  fun isNetworkAvailable(context: Context): Boolean {
    val cm: ConnectivityManager = context.getSystemService(
        Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = cm.activeNetworkInfo
    return activeNetwork?.isConnectedOrConnecting == true
  }

  /**
   * Get an Activity module for dependency injection.

   * @return [ActivityModule]
   */
  protected val activityModule: ActivityModule get() = ActivityModule(this)
}