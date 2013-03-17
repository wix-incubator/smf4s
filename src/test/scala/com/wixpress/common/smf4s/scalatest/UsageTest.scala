package com.wixpress.common.smf4s.scalatest

import org.scalatest.FlatSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.ShouldMatchers
import org.hamcrest.Matchers._

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
@RunWith(classOf[JUnitRunner])
class UsageTest extends FlatSpec with ShouldMatchers with ScalatestHamcrestMatchers {

  "examples" should "be self-explainable" in {

    // iterable
    Set("a", "b").toSeq should HaveItem(startsWith("b"))
    Seq("a", "b") should HaveItem(startsWith("b"))
    List("a", "b") should HaveItem(startsWith("b"))
    Iterable("a", "b").toSeq should HaveItem(startsWith("b"))
    Array("a", "b").toSeq should HaveItem(startsWith("b"))

    // map
    Map("key1" -> "value1") should HaveKey("key1")
    Map("key1" -> "value1") should HaveValue("value1")
    Map("key1" -> "value1") should HaveEntry("key1" -> "value1")
    Map("key1" -> "value1") should HaveEntry(is("key1"), containsString("value1"))

    // option
    None should BeNone
    Some("haha") should BeSome(startsWith("ha"))
  }
}
