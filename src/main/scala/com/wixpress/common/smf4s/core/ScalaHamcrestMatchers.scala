package com.wixpress.common.smf4s.core

import org.hamcrest.Matcher
import org.hamcrest.Matchers._
import org.hamcrest.core.{IsAnything, AllOf}
import scala.collection.JavaConverters._

/**
 * Created with IntelliJ IDEA.
 * User: daniels
 * Date: 17/03/13
 */
trait ScalaHamcrestMatchers {

  def haveItem[T](m: Matcher[T]): Matcher[Iterable[T]] = IsIterableContaining(m)
  def haveItem[T](v: T): Matcher[Iterable[T]] = IsIterableContaining(is(v))

  def haveItems[T](i: T*): Matcher[Iterable[T]] = {
    val s = i map { haveItem(_).asInstanceOf[Matcher[_ >: Iterable[T]]] }
    new AllOf[Iterable[T]](s.asJava)
  }

  def haveKey[K](m: Matcher[K]): Matcher[Iterable[(K, Any)]] = IsMapContaining[K, Any](m, anything)
  def haveKey[K](k: K): Matcher[Iterable[(K, Any)]] = IsMapContaining[K, Any](is(k), anything)

  def haveKeys[K](k: K*): Matcher[Iterable[(K, Any)]] = {
    val s = k map { haveKey(_).asInstanceOf[Matcher[_ >: Iterable[(K, Any)]]] }
    new AllOf[Iterable[(K, Any)]](s.asJava)
  }

  def haveValue[V](m: Matcher[V]): Matcher[Iterable[(Any, V)]] = IsMapContaining[Any, V](anything, m)
  def haveValue[V](v: V): Matcher[Iterable[(Any, V)]] = IsMapContaining[Any, V](anything, is(v))

  def haveEntry[K, V](p: (K, V)): Matcher[Iterable[(K, V)]] = IsMapContaining[K, V](is(p._1), is(p._2))
  def haveEntry[K, V](k: Matcher[K], v: Matcher[V]): Matcher[Iterable[(K, V)]] = IsMapContaining[K, V](k, v)

  def beNone[T]: Matcher[Option[Nothing]] = IsNoneOption
  def beSome[T](m: Matcher[T]): Matcher[Option[T]] = IsSomeOption(m)
  def beSome[T](v: T): Matcher[Option[T]] = IsSomeOption(is(v))

  private val anything = new IsAnything[Any]()

}

object ScalaHamcrestMatchers extends ScalaHamcrestMatchers
