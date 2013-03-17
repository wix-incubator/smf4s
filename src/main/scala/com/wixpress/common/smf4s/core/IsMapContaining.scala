package com.wixpress.common.smf4s.core

import org.hamcrest.{Description, Matcher, TypeSafeMatcher}

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
case class IsMapContaining[K, V](keyMatcher: Matcher[K], valueMatcher: Matcher[V]) extends TypeSafeMatcher[Iterable[(K, V)]] {

  def matchesSafely(item: Iterable[(K, V)]) =
    item exists { case (key, value) => keyMatcher.matches(key) && valueMatcher.matches(value) }

  def describeTo(description: Description) {
    description.appendText("map containing [")
      .appendDescriptionOf(keyMatcher)
      .appendText(" -> ")
      .appendDescriptionOf(valueMatcher)
      .appendText("]")
  }
}
