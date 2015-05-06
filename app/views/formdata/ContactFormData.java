package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactFormData allows for the storage of Form Data that is input by the user.
 */
public class ContactFormData {

  /**
   * Input data id hidden field.
   */
  public long id;

  /**
   * Input data first name field.
   */
  public String firstName = "";

  /**
   * Input diet Type string.
   */
  public List<String> dietTypes = new ArrayList<String>();

  /**
   * Default no-arg constructor required by Play.
   */
  public ContactFormData() {
    // No content.
  }

  /**
   * Constructor that builds the ContactFormData object from a Contact.
   *
   * @param contact The contact object passed to the constructor.
   */
  public ContactFormData(Contact contact) {
    this.id = contact.getId();
    this.firstName = contact.getFirstName();
    this.dietTypes = contact.getDietTypesList();
  }

  /**
   * Testing Initialization constructor, does not include ID.
   * @param firstName The First Name.
   * @param dietTypes The selected Diet Types.
   */
  public ContactFormData(String firstName, List<String> dietTypes) {
    this.firstName = firstName;
    this.dietTypes = dietTypes;
  }


  /**
   * Validate that all fields are non-empty and that telephone field is 12 characters.
   *
   * @return Either null if no errors, or a List of errors.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "A First Name must be provided."));
    }
    for (String diet : dietTypes) {
      if (!DietTypes.isType(diet)) {
        errors.add(new ValidationError("dietType", "Invalid type passed in."));
      }
    }
    return errors.isEmpty() ? null : errors;
  }
}
