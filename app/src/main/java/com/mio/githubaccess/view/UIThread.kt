package com.mio.githubaccess.view

import com.mio.githubaccess.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * MainThread (UI Thread) implementation based on a [Scheduler] which will execute actions
 * on the Android UI thread
 */
@Singleton
class UIThread @Inject constructor() : PostExecutionThread {

  override val scheduler: Scheduler get() = AndroidSchedulers.mainThread()
}