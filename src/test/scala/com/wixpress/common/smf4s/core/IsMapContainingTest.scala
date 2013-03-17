package com.wixpress.common.smf4s.core

import scala.collection.mutable
import org.hamcrest.Matchers._
import org.junit.Assert._
import org.junit.Test
import org.hamcrest.core.IsAnything

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
class IsMapContainingTest {

  private val im = Map("key1" -> "val1")
  private val mm = mutable.Map("key2" -> "val2")

  @Test
  def positive() {
    assertThat(im, containsKey("key1"))
    assertThat(im, containsValue("val1"))
    assertThat(im, containsEntry("key1" -> "val1"))

    assertThat(mm, containsKey("key2"))
    assertThat(mm, containsValue("val2"))
    assertThat(mm, containsEntry("key2" -> "val2"))
  }

  @Test
  def negative() {
    assertThat(im, not(containsKey("key3")))
    assertThat(im, not(containsValue("val3")))
    assertThat(im, not(containsEntry("key1" -> "val2")))
  }

  @Test
  def describes() {
    assertThat(containsEntry("a" -> "b").toString, is("map containing [is \"a\" -> is \"b\"]"))
  }

  private def containsEntry[K, V](p: (K, V)) = new IsMapContaining[K, V](is(p._1), is(p._2))
  private def containsKey[K](k: K) = new IsMapContaining[K, Any](is(k), anything)
  private def containsValue[V](v: V) = new IsMapContaining[Any, V](anything, is(v))
  private val anything = new IsAnything[Any]()

}
