// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/PlayProject/conf/routes
// @DATE:Sat Jan 25 19:12:58 IST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  AdminController_2: controllers.AdminController,
  // @LINE:14
  QandAController_0: controllers.QandAController,
  // @LINE:24
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    AdminController_2: controllers.AdminController,
    // @LINE:14
    QandAController_0: controllers.QandAController,
    // @LINE:24
    Assets_1: controllers.Assets
  ) = this(errorHandler, AdminController_2, QandAController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AdminController_2, QandAController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """loginRegister""", """controllers.AdminController.loginRegister(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.AdminController.login(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """askQuestion""", """controllers.QandAController.insertQuestion(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """answerQuestion""", """controllers.QandAController.answerQuestion(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """recentQuestion""", """controllers.QandAController.getRecentlyAddedQuestions()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """reecentQandA""", """controllers.QandAController.getRecentQandA()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_AdminController_loginRegister0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("loginRegister")))
  )
  private[this] lazy val controllers_AdminController_loginRegister0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AdminController_2.loginRegister(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "loginRegister",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """loginRegister""",
      """ loginRegister""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AdminController_login1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_AdminController_login1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AdminController_2.login(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "login",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """login""",
      """loginUser""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_QandAController_insertQuestion2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("askQuestion")))
  )
  private[this] lazy val controllers_QandAController_insertQuestion2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      QandAController_0.insertQuestion(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QandAController",
      "insertQuestion",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """askQuestion""",
      """Ask Question""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_QandAController_answerQuestion3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("answerQuestion")))
  )
  private[this] lazy val controllers_QandAController_answerQuestion3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      QandAController_0.answerQuestion(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QandAController",
      "answerQuestion",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """answerQuestion""",
      """Answer Question""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_QandAController_getRecentlyAddedQuestions4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("recentQuestion")))
  )
  private[this] lazy val controllers_QandAController_getRecentlyAddedQuestions4_invoker = createInvoker(
    QandAController_0.getRecentlyAddedQuestions(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QandAController",
      "getRecentlyAddedQuestions",
      Nil,
      "GET",
      this.prefix + """recentQuestion""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_QandAController_getRecentQandA5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("reecentQandA")))
  )
  private[this] lazy val controllers_QandAController_getRecentQandA5_invoker = createInvoker(
    QandAController_0.getRecentQandA(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.QandAController",
      "getRecentQandA",
      Nil,
      "GET",
      this.prefix + """reecentQandA""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_AdminController_loginRegister0_route(params@_) =>
      call { 
        controllers_AdminController_loginRegister0_invoker.call(
          req => AdminController_2.loginRegister(req))
      }
  
    // @LINE:10
    case controllers_AdminController_login1_route(params@_) =>
      call { 
        controllers_AdminController_login1_invoker.call(
          req => AdminController_2.login(req))
      }
  
    // @LINE:14
    case controllers_QandAController_insertQuestion2_route(params@_) =>
      call { 
        controllers_QandAController_insertQuestion2_invoker.call(
          req => QandAController_0.insertQuestion(req))
      }
  
    // @LINE:17
    case controllers_QandAController_answerQuestion3_route(params@_) =>
      call { 
        controllers_QandAController_answerQuestion3_invoker.call(
          req => QandAController_0.answerQuestion(req))
      }
  
    // @LINE:18
    case controllers_QandAController_getRecentlyAddedQuestions4_route(params@_) =>
      call { 
        controllers_QandAController_getRecentlyAddedQuestions4_invoker.call(QandAController_0.getRecentlyAddedQuestions())
      }
  
    // @LINE:19
    case controllers_QandAController_getRecentQandA5_route(params@_) =>
      call { 
        controllers_QandAController_getRecentQandA5_invoker.call(QandAController_0.getRecentQandA())
      }
  
    // @LINE:24
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
