package com.wixpress.common.smf4s.core

import org.hamcrest.{TypeSafeDiagnosingMatcher, Description, Matcher}

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
case class IsSomeOption[T](m: Matcher[T]) extends TypeSafeDiagnosingMatcher[Option[T]] {

  def matchesSafely(item: Option[T], mismatchDescription: Description) = {
    val result = item exists { m.matches(_) }
    if (!result) {
      mismatchDescription
        .appendText("wasn't Some that ")
        .appendDescriptionOf(m)
    }
    result
  }

  def describeTo(description: Description) {
    description.appendText("Some with value that ").appendDescriptionOf(m)
  }
}

case object IsNoneOption extends TypeSafeDiagnosingMatcher[Option[Nothing]] {

  def matchesSafely(item: Option[Nothing], mismatchDescription: Description) = {
    val result = item.isEmpty
    if (!result)
      mismatchDescription.appendText("wasn't None")
    result
  }

  def describeTo(description: Description) {
    description.appendText("None")
  }
}
