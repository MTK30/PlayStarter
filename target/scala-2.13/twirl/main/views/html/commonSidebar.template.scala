
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._

object commonSidebar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/defining(play.core.PlayVersion.current)/*2.41*/ { version =>_display_(Seq[Any](format.raw/*2.54*/("""
"""),format.raw/*3.1*/("""<h3>Table of Contents</h3>
<ul>

</ul>
<h3>Related Resources</h3>
<ul>
  <li><a href="https://playframework.com/documentation/"""),_display_(/*9.57*/version),format.raw/*9.64*/("""" target="_blank">Play documentation</a></li>
  <li><a href="https://discuss.lightbend.com/c/play/" target="_blank">Forum</a></li>
  <li><a href="https://gitter.im/playframework/playframework" target="_blank">Gitter Channel</a></li>
  <li><a href="https://stackoverflow.com/questions/tagged/playframework" target="_blank">Stackoverflow</a></li>
  <li><a href="https://lightbend.com/how" target="_blank">Professional support</a></li>
</ul>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-01-16T01:36:16.248196
                  SOURCE: /home/mtk/WorkSpace/PlayProject/app/views/commonSidebar.scala.html
                  HASH: 82e566c4689226315063ed4b63bbfc2aeffe7844
                  MATRIX: 909->1|1005->5|1052->44|1102->57|1129->58|1282->185|1309->192
                  LINES: 27->1|32->2|32->2|32->2|33->3|39->9|39->9
                  -- GENERATED --
              */
          