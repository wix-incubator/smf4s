package com.wixpress.common.smf4s.core

import org.hamcrest.Matchers._
import org.junit.Assert._
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 11/03/13
 */

class IsIterableContainingTest {

  @Test
  def positive() {
    val i = Iterable(1, 2, 3)
    assertThat(i, containsElement(1))
    assertThat(i, containsElement(2))
    assertThat(i, containsElement(3))
  }

  @Test
  def negative() {
    val i = Iterable(1, 2, 3)
    assertThat(i, not(containsElement(4)))
  }

  @Test
  def description() {
    assertThat(containsElement(2).description, is("an iterable containing is <2>"))
  }

  def containsElement[T](e: T) = IsIterableContaining(is(e))
}
