package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import scala.concurrent.Future
import play.api.mvc._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class CodebreakerTest extends PlaySpec with Results {


  "Probando 1234" should {
    "should be exist" in {

        val c = new Codebreaker()
        val result = c.trySecret("1234")
        result mustBe "xxxx"
    }
  }

  "Probando 1235" should {
    "should be valid" in {

        val c = new Codebreaker()
        val result = c.trySecret("1235")
        result mustBe "xxx"
    }
  }

  "Probando 1246" should {
    "should be valid" in {

        val c = new Codebreaker()
        val result = c.trySecret("1246")
        result mustBe "xx_"
    }
  }

  "Probando 5678" should {
    "should be valid" in {

        val c = new Codebreaker()
        val result = c.trySecret("5678")
        result mustBe ""
    }
  }
 
  "Probando 1243" should {
    "should be valid" in {

        val c = new Codebreaker()
        val result = c.trySecret("1243")
        result mustBe "xx__"
    }
  }

  "Probando mas de cuatro numeros" should {
    "should be valid" in {

        val c = new Codebreaker()
        val result = c.trySecret("12435")
        result mustBe "No ingrese mas de 4 digitos"
    }
  }
  
}