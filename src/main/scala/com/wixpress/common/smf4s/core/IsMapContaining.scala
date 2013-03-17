package com.wixpress.common.smf4s.core

import org.hamcrest.{TypeSafeDiagnosingMatcher, Description, Matcher}

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
case class IsMapContaining[K, V](keyMatcher: Matcher[K], valueMatcher: Matcher[V]) extends TypeSafeDiagnosingMatcher[Iterable[(K, V)]] {


  def matchesSafely(item: Iterable[(K, V)], mismatchDescription: Description) = {
    val result = item exists { case (key, value) => keyMatcher.matches(key) && valueMatcher.matches(value) }
    if (!result) {
      mismatchDescription
        .appendText("didn't contain entry with key that ")
        .appendDescriptionOf(keyMatcher)
        .appendText(" and value that ")
        .appendDescriptionOf(valueMatcher)
    }
    result
  }

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
