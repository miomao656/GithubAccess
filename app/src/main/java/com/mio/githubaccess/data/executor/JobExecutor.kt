package com.mio.githubaccess.data.executor

import com.mio.githubaccess.domain.executor.ThreadExecutor
import java.util.concurrent.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Decorated [java.util.concurrent.ThreadPoolExecutor]
 */
@Singleton
class JobExecutor @Inject constructor() : ThreadExecutor {

  private val workQueue: BlockingQueue<Runnable>

  private val threadPoolExecutor: ThreadPoolExecutor

  private val threadFactory: ThreadFactory

  init {
    this.workQueue = LinkedBlockingQueue<Runnable>()
    this.threadFactory = JobThreadFactory()
    this.threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
        KEEP_ALIVE_TIME.toLong(),
        KEEP_ALIVE_TIME_UNIT, this.workQueue, this.threadFactory)
  }

  override fun execute(runnable: Runnable) {
    this.threadPoolExecutor.execute(runnable)
  }

  private class JobThreadFactory : ThreadFactory {
    private val counter = 0

    override fun newThread(runnable: Runnable): Thread {
      return Thread(runnable, THREAD_NAME + counter)
    }

    companion object {
      private val THREAD_NAME = "cd_android_"
    }
  }

  companion object {

    private const val INITIAL_POOL_SIZE = 3
    private const val MAX_POOL_SIZE = 5

    // Sets the amount of time an idle thread waits before terminating
    private const val KEEP_ALIVE_TIME = 10

    // Sets the Time Unit to seconds
    private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
  }
}