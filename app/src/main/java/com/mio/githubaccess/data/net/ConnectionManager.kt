package com.mio.githubaccess.data.net

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Helper class for networking
 */
@Singleton
class ConnectionManager
@Inject constructor(
    private val context: Context
) {

  /**
   * Helper method for checking if device is connected to the internet
   */
  val isNetworkAvailable: Boolean
    get() {
      val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
      val activeNetwork = cm.activeNetworkInfo
      return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}