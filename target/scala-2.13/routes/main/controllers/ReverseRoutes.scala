// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/PlayProject/conf/routes
// @DATE:Sun Feb 09 02:50:38 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers {

  // @LINE:32
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
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

  // @LINE:26
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def getAlreadyAnswered(userId:java.lang.Long = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "alreadyAnswered" + play.core.routing.queryString(List(if(userId == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("userId", userId)))))
    }
  
    // @LINE:26
    def userCanAnswer(userId:java.lang.Long = null): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "canAnswer" + play.core.routing.queryString(List(if(userId == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("userId", userId)))))
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

  // @LINE:22
  class ReverseFeedbackController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def updateFeedback(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateFeedBack")
    }
  
  }


}
