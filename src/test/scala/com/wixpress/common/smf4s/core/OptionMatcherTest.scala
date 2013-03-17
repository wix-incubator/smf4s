package com.wixpress.common.smf4s.core

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.Matchers._

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
class OptionMatcherTest {

  @Test
  def matchesSome() {
    assertTrue(IsSomeOption(is("value")).matches(Some("value")))
  }

  @Test
  def notMatchesSome() {
    assertFalse(IsSomeOption(is("value")).matches(Some("other")))
  }

  @Test
  def matchesNone() {
    val s: Option[String] = None
    assertTrue(IsNoneOption.matches(s))
  }

  @Test
  def notMatchesNone() {
    assertFalse(IsNoneOption.matches(Some("blah")))
  }

  @Test
  def someDescribed() {
    assertThat(IsSomeOption(is("ha")).toString, is("Some with value that is \"ha\""))
  }

  @Test
  def noneDescribed() {
    assertThat(IsNoneOption.toString, is("None"))
  }
}
