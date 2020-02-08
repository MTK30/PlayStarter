// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/PlayProject/conf/routes
// @DATE:Sun Feb 09 02:50:38 IST 2020

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
  QandAController_1: controllers.QandAController,
  // @LINE:22
  FeedbackController_0: controllers.FeedbackController,
  // @LINE:26
  UserController_3: controllers.UserController,
  // @LINE:32
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    AdminController_2: controllers.AdminController,
    // @LINE:14
    QandAController_1: controllers.QandAController,
    // @LINE:22
    FeedbackController_0: controllers.FeedbackController,
    // @LINE:26
    UserController_3: controllers.UserController,
    // @LINE:32
    Assets_4: controllers.Assets
  ) = this(errorHandler, AdminController_2, QandAController_1, FeedbackController_0, UserController_3, Assets_4, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AdminController_2, QandAController_1, FeedbackController_0, UserController_3, Assets_4, prefix)
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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateFeedBack""", """controllers.FeedbackController.updateFeedback(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """canAnswer""", """controllers.UserController.userCanAnswer(userId:java.lang.Long ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """alreadyAnswered""", """controllers.UserController.getAlreadyAnswered(userId:java.lang.Long ?= null)"""),
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
      QandAController_1.insertQuestion(fakeValue[play.mvc.Http.Request]),
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
      QandAController_1.answerQuestion(fakeValue[play.mvc.Http.Request]),
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
    QandAController_1.getRecentlyAddedQuestions(),
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
    QandAController_1.getRecentQandA(),
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

  // @LINE:22
  private[this] lazy val controllers_FeedbackController_updateFeedback6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateFeedBack")))
  )
  private[this] lazy val controllers_FeedbackController_updateFeedback6_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      FeedbackController_0.updateFeedback(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FeedbackController",
      "updateFeedback",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """updateFeedBack""",
      """FeedBack Response""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_UserController_userCanAnswer7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("canAnswer")))
  )
  private[this] lazy val controllers_UserController_userCanAnswer7_invoker = createInvoker(
    UserController_3.userCanAnswer(fakeValue[java.lang.Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "userCanAnswer",
      Seq(classOf[java.lang.Long]),
      "GET",
      this.prefix + """canAnswer""",
      """User Routes""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_UserController_getAlreadyAnswered8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("alreadyAnswered")))
  )
  private[this] lazy val controllers_UserController_getAlreadyAnswered8_invoker = createInvoker(
    UserController_3.getAlreadyAnswered(fakeValue[java.lang.Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAlreadyAnswered",
      Seq(classOf[java.lang.Long]),
      "GET",
      this.prefix + """alreadyAnswered""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
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
          req => QandAController_1.insertQuestion(req))
      }
  
    // @LINE:17
    case controllers_QandAController_answerQuestion3_route(params@_) =>
      call { 
        controllers_QandAController_answerQuestion3_invoker.call(
          req => QandAController_1.answerQuestion(req))
      }
  
    // @LINE:18
    case controllers_QandAController_getRecentlyAddedQuestions4_route(params@_) =>
      call { 
        controllers_QandAController_getRecentlyAddedQuestions4_invoker.call(QandAController_1.getRecentlyAddedQuestions())
      }
  
    // @LINE:19
    case controllers_QandAController_getRecentQandA5_route(params@_) =>
      call { 
        controllers_QandAController_getRecentQandA5_invoker.call(QandAController_1.getRecentQandA())
      }
  
    // @LINE:22
    case controllers_FeedbackController_updateFeedback6_route(params@_) =>
      call { 
        controllers_FeedbackController_updateFeedback6_invoker.call(
          req => FeedbackController_0.updateFeedback(req))
      }
  
    // @LINE:26
    case controllers_UserController_userCanAnswer7_route(params@_) =>
      call(params.fromQuery[java.lang.Long]("userId", Some(null))) { (userId) =>
        controllers_UserController_userCanAnswer7_invoker.call(UserController_3.userCanAnswer(userId))
      }
  
    // @LINE:27
    case controllers_UserController_getAlreadyAnswered8_route(params@_) =>
      call(params.fromQuery[java.lang.Long]("userId", Some(null))) { (userId) =>
        controllers_UserController_getAlreadyAnswered8_invoker.call(UserController_3.getAlreadyAnswered(userId))
      }
  
    // @LINE:32
    case controllers_Assets_versioned9_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
