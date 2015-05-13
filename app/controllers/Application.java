package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.DietTypes;
import views.html.Directions;
import views.html.Index;
import views.html.Live;
import views.html.Canvas;
import views.html.Theory;

import java.util.Map;

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
   * Returns the theory page.
   * @return The resulting theory page.
   */
  public static Result theory() {
    return ok(Theory.render("Welcome to the home page."));
  }

  /**
   * Returns the directions page.
   * @return The resulting directions page.
   */
  public static Result directions() {
    return ok(Directions.render("Welcome to the home page."));

  }

  /**
   * Returns Live, a simple example of a second page to illustrate navigation.
   *
   * @return The Live.
   */
  public static Result live() {
    return ok(Live.render(ContactDB.getContacts()));

  }



  /**
   * Renders the newContact page with a form to add new contacts if the ID is 0; otherwise updates the existing contact.
   *
   * @param id The ID value passed in.
   * @return The newContact page.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> dietTypes = DietTypes.getDietTypes(data.dietTypes);
    return ok(Canvas.render(formData, dietTypes));
  }

  /**
   * Handles the request to post form data from the newContact page.
   *
   * @return The newContact page, either with errors or with form data.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("HTTP Form Error.");
      return badRequest(Canvas.render(formData, DietTypes.getDietTypes()));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContacts(data);
      System.out.printf("HTTP OK; Form Data:  %s, %n", data.firstName);
      System.out.println(data.dietTypes);
      return ok(Canvas.render(formData, DietTypes.getDietTypes()));
  }
  }
}