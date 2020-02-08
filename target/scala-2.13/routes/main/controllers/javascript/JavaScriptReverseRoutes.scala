// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/PlayProject/conf/routes
// @DATE:Sun Feb 09 02:50:38 IST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {

  // @LINE:32
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:7
    def loginRegister: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.loginRegister",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "loginRegister"})
        }
      """
    )
  
  }

  // @LINE:26
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def getAlreadyAnswered: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getAlreadyAnswered",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "alreadyAnswered" + _qS([(userId0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].javascriptUnbind + """)("userId", userId0))])})
        }
      """
    )
  
    // @LINE:26
    def userCanAnswer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.userCanAnswer",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "canAnswer" + _qS([(userId0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].javascriptUnbind + """)("userId", userId0))])})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseQandAController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def getRecentQandA: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QandAController.getRecentQandA",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reecentQandA"})
        }
      """
    )
  
    // @LINE:18
    def getRecentlyAddedQuestions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QandAController.getRecentlyAddedQuestions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recentQuestion"})
        }
      """
    )
  
    // @LINE:17
    def answerQuestion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QandAController.answerQuestion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "answerQuestion"})
        }
      """
    )
  
    // @LINE:14
    def insertQuestion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.QandAController.insertQuestion",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "askQuestion"})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseFeedbackController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def updateFeedback: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FeedbackController.updateFeedback",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateFeedBack"})
        }
      """
    )
  
  }


}
