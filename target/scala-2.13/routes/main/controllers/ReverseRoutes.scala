// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/PlayProject/conf/routes
// @DATE:Sat Jan 25 19:12:58 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers {

  // @LINE:24
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:14
  class ReverseQandAController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def getRecentQandA(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "reecentQandA")
    }
  
    // @LINE:18
    def getRecentlyAddedQuestions(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "recentQuestion")
    }
  
    // @LINE:17
    def answerQuestion(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "answerQuestion")
    }
  
    // @LINE:14
    def insertQuestion(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "askQuestion")
    }
  
  }

  // @LINE:7
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:7
    def loginRegister(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "loginRegister")
    }
  
  }


}
