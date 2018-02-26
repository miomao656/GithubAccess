package com.mio.githubaccess.view

import android.app.Application
import android.os.StrictMode
import android.webkit.WebView
import com.mio.githubaccess.BuildConfig
import com.mio.githubaccess.injection.components.AppComponent
import com.mio.githubaccess.injection.components.DaggerAppComponent
import com.mio.githubaccess.injection.modules.AppModule
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber

class GitHubAccessApp : Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    initializeDebugDetection()
  }

  /**
   * Leak canary, stetho and strict mode initialization for development/debugging purposes
   */
  private fun initializeDebugDetection() {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
      if (LeakCanary.isInAnalyzerProcess(this)) {
        // This process is dedicated to LeakCanary for heap analysis.
        // You should not initCollection your app in this process.
        return
      }
      LeakCanary.install(this)
      WebView(this) // to avoid exception from a bug in webview on some versions of android
      StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectDiskReads()
          .detectDiskWrites()
          .detectAll()
          .penaltyLog()
          .build())
      StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects()
          .detectLeakedClosableObjects()
          .penaltyLog()
          .build())
      Timber.e("initializeDebugDetection: INITIALIZED")
    }
  }
}
