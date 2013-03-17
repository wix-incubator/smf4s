package com.wixpress.common.smf4s.specs2

import org.hamcrest.Matcher
import org.specs2.matcher.Hamcrest
import com.wixpress.common.smf4s.core.ScalaHamcrestMatchers._

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 11/03/13
 */
trait Specs2HamcrestMatchers extends Hamcrest {

  def HaveItem[T](m: Matcher[T]): Matcher[Iterable[T]] = haveItem(m)
  def HaveItem[T](v: T): Matcher[Iterable[T]] = haveItem(v)

  def HaveItems[T](i: T*): Matcher[Iterable[T]] = haveItems(i: _*)

  def HaveKey[K](m: Matcher[K]): Matcher[Iterable[(K, Any)]] = haveKey(m)
  def HaveKey[K](k: K): Matcher[Iterable[(K, Any)]] = haveKey(k)

  def HaveKeys[K](k: K*): Matcher[Iterable[(K, Any)]] = haveKeys(k: _*)

  def HaveValue[V](m: Matcher[V]): Matcher[Iterable[(Any, V)]] = haveValue(m)
  def HaveValue[V](v: V): Matcher[Iterable[(Any, V)]] = haveValue(v)

  def HaveEntry[K, V](p: (K, V)): Matcher[Iterable[(K, V)]] = haveEntry(p)
  def HaveEntry[K, V](k: Matcher[K], v: Matcher[V]): Matcher[Iterable[(K, V)]] = haveEntry(k, v)

  def BeNone[T]: Matcher[Option[Nothing]] = beNone
  def BeSome[T](m: Matcher[T]): Matcher[Option[T]] = beSome(m)
  def BeSome[T](v: T): Matcher[Option[T]] = beSome(v)

}
