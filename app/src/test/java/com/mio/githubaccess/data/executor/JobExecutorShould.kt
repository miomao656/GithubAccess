package com.mio.githubaccess.data.executor

import org.hamcrest.MatcherAssert
import org.hamcrest.core.Is
import org.hamcrest.core.IsNull
import org.junit.Test

class JobExecutorShould {

  private val jobExecutor: JobExecutor = JobExecutor()

  @Test fun execute() {
    // figure out how to test or refactor this to support testing
    var ex: Exception? = null
    val runnable = { }
    try {
      jobExecutor.execute(runnable)
    } catch (e: Exception) {
      ex = e
    }

    MatcherAssert.assertThat(ex, Is.`is`(IsNull.nullValue()))
  }
}