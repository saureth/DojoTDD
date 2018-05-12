package controllers

import javax.inject._
import play.api._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class Codebreaker {

    var secret = "1234"
    var xs = ""
    var underScores = ""

  def trySecret(num: String): String = {

    var result:String = ""

    var i = 0
    var j = 0

    if(num.length()>4){
        return "No ingrese mas de 4 digitos"
    }

      for(i <- 0 to 3){
        for(j <- 0 to 3){
            if(i==j && secret.charAt(i).equals(num.charAt(j))){
                xs = xs + "x"
            }
            else if (secret.charAt(i).equals(num.charAt(j))){
                underScores = underScores + "_"
            }          
        }        
      }     
      result = xs + underScores
      return result
  }
}