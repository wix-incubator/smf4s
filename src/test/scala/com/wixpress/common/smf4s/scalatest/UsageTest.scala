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

  "An iterable matcher" should "be matched" in {
    val i = Seq("a", "b")
    i should HaveItem("a")
    i should HaveItem(startsWith("b"))
    i should not(HaveItem("c"))
  }
}
