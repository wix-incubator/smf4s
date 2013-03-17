package com.wixpress.common.smf4s.specs2

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
class UsageTest extends SpecificationWithJUnit with Specs2HamcrestMatchers {

  "Iterable matchers" in new Scope {
    Set(1, 2, 3) must HaveItems(1, 2, 3)
    Set(1, 2, 3) must HaveItems(3, 4).not
  }
}
