package com.mio.githubaccess.injection

/**
 * Interface representing a contract for clients that contains a component for dependency
 * injection.
 */
interface HasComponent<out C> {
  val component: C
}
