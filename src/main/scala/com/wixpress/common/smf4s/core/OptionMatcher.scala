package com.wixpress.common.smf4s.core

import org.hamcrest.{Description, TypeSafeMatcher, Matcher}

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
case class IsSomeOption[T](m: Matcher[T]) extends TypeSafeMatcher[Option[T]] {

  def matchesSafely(item: Option[T]) = item exists { m.matches(_) }

  def describeTo(description: Description) {
    description.appendText("Some with value that ").appendDescriptionOf(m)
  }
}

case object IsNoneOption extends TypeSafeMatcher[Option[Nothing]] {

  def matchesSafely(item: Option[Nothing]) = item.isEmpty

  def describeTo(description: Description) {
    description.appendText("None")
  }
}
