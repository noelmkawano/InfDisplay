package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.Live;
import views.html.Canvas;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));

  }

  /**
   * Returns Live, a simple example of a second page to illustrate navigation.
   * @return The Live.
   */
  public static Result live() {
    return ok(Live.render("Welcome to live."));

  }

  /**
   * Returns the play page.
   * @return the play page.
   */
  public static Result canvas() {
    return ok(Canvas.render("Welcome to canvas."));
  }

}
