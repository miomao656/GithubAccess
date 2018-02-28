package com.mio.githubaccess.data.net

import junit.framework.Assert.assertNotNull
import org.junit.Test

class BaseServiceManagerShould {

  private val baseServiceManager = BaseServiceManager()

  @Test fun getRestRetrofitClient() {
    val retrofitRest = baseServiceManager.restRetrofitClient
    assertNotNull(retrofitRest)
  }
}