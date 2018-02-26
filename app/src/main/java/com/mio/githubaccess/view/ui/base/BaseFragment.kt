package com.mio.githubaccess.view.ui.base

import android.support.v4.app.Fragment
import com.mio.githubaccess.injection.HasComponent


/**
 * Base [Fragment] class for every getOptionsDrawerFragment in this application.
 */
abstract class BaseFragment : Fragment() {

  /**
   * Gets a component for dependency injection by its type.
   */
  protected fun <C> getComponent(componentType: Class<C>): C = componentType.cast(
      (activity as HasComponent<*>).component)
}
