package com.mio.githubaccess.injection.modules

import android.app.Activity
import com.mio.githubaccess.injection.PerActivity
import dagger.Module
import dagger.Provides

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
class ActivityModule(private val activity: Activity) {

  /**
   * Expose the activity to dependents in the graph.
   */
  @Provides
  @PerActivity
  fun activity(): Activity = this.activity
}
