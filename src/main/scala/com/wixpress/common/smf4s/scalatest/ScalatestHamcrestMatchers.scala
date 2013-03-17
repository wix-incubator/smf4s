package com.wixpress.common.smf4s.scalatest

import org.hamcrest.Matcher
import org.scalatest.matchers.{Matcher => STMatcher, MatchResult}
import com.wixpress.common.smf4s.core._
import org.scalatest.matchers
import ScalaHamcrestMatchers._

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
trait ScalatestHamcrestMatchers {

  def HaveItem[T](m: Matcher[T]): STMatcher[Iterable[T]] = haveItem(m)
  def HaveItem[T](v: T): STMatcher[Iterable[T]] = haveItem(v)

  def HaveItems[T](i: T*): STMatcher[Iterable[T]] = haveItems(i: _*)

  def HaveKey[K](m: Matcher[K]): STMatcher[Iterable[(K, Any)]] = haveKey(m)
  def HaveKey[K](k: K): STMatcher[Iterable[(K, Any)]] = haveKey(k)

  def HaveKeys[K](k: K*): STMatcher[Iterable[(K, Any)]] = haveKeys(k: _*)

  def HaveValue[V](m: Matcher[V]): STMatcher[Iterable[(Any, V)]] = haveValue(m)
  def HaveValue[V](v: V): STMatcher[Iterable[(Any, V)]] = haveValue(v)

  def HaveEntry[K, V](p: (K, V)): STMatcher[Iterable[(K, V)]] = haveEntry(p)
  def HaveEntry[K, V](k: Matcher[K], v: Matcher[V]): STMatcher[Iterable[(K, V)]] = haveEntry(k, v)

  def BeNone[T]: STMatcher[Option[Nothing]] = beNone
  def BeSome[T](m: Matcher[T]): STMatcher[Option[T]] = beSome(m)
  def BeSome[T](v: T): STMatcher[Option[T]] = beSome(v)

  implicit def hamcrestMatcher2ScalatestMatcher[T](m: Matcher[T]): STMatcher[T] = new matchers.Matcher[T] {
    def apply(value: T) = MatchResult(m.matches(value), m.toString, "is not " + m.toString)
  }
}
