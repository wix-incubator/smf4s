package com.wixpress.common.smf4s.core

import org.hamcrest.{Description, Matcher, TypeSafeMatcher}

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 11/03/13
 */
case class IsIterableContaining[V](v: Matcher[V]) extends TypeSafeMatcher[Iterable[V]] {

  def matchesSafely(item: Iterable[V]) = item exists { v.matches(_) }

  def describeTo(description: Description) {
    description.appendText("an iterable containing ")
      .appendDescriptionOf(v)
  }
}
