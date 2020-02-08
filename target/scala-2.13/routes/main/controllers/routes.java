// @GENERATOR:play-routes-compiler
// @SOURCE:/home/mtk/WorkSpace/PlayProject/conf/routes
// @DATE:Sun Feb 09 02:50:38 IST 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAdminController AdminController = new controllers.ReverseAdminController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseQandAController QandAController = new controllers.ReverseQandAController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFeedbackController FeedbackController = new controllers.ReverseFeedbackController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAdminController AdminController = new controllers.javascript.ReverseAdminController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseQandAController QandAController = new controllers.javascript.ReverseQandAController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFeedbackController FeedbackController = new controllers.javascript.ReverseFeedbackController(RoutesPrefix.byNamePrefix());
  }

}
