// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/PlayProject/conf/routes
// @DATE:Sat Jan 25 19:12:58 IST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {

  // @LINE:24
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
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


}
