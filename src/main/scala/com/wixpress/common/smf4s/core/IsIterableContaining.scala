package com.wixpress.common.smf4s.core

import org.hamcrest.{TypeSafeDiagnosingMatcher, Description, Matcher}

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 11/03/13
 */
case class IsIterableContaining[V](v: Matcher[V]) extends TypeSafeDiagnosingMatcher[Iterable[V]] {

  def matchesSafely(item: Iterable[V], mismatchDescription: Description) = {
    val result = item exists { v.matches(_) }
    if (!result) {
      mismatchDescription
        .appendText(" didn't contain element that ")
        .appendDescriptionOf(v)
    }
    result
  }

  def describeTo(description: Description) {
    description.appendText("an iterable containing ")
      .appendDescriptionOf(v)
  }
}
