package com.wixpress.common.smf4s

import org.hamcrest.{StringDescription, Matcher}

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 11/03/13
 */
package object core {
  implicit def matcher2matcherWithDescription(m: Matcher[_]): MatcherWithDescription = new MatcherWithDescription {
    def description = {
      val d = new StringDescription()
      m.describeTo(d)
      d.toString
    }
  }
}

trait MatcherWithDescription {
  def description: String
}
