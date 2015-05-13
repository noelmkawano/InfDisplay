package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;


/**
 * An in-memory array of Contacts that have been gathered from input form data.
 */
public class ContactDB {

  //private static Map<Long, Contact> contacts = new HashMap<>();
  //private static Map<String, DietType> dietTypes = new HashMap<>();
  //private static long currentId = 1;


  /**
   * Adds a formData input to the Contacts list.
   *
   * @param formData Input data from the form.
   */
  public static void addContacts(ContactFormData formData) {
    if (formData.id == 0) {
      // Contact does not exist, create new.
      List<DietType> dietTypes = new ArrayList<>();
      for (String diet : formData.dietTypes) {
        dietTypes.add(getDietType(diet));
      }
      Contact contactFromForm = new Contact(formData.firstName, dietTypes);
      // Make bi-directional relationships work.
      for (DietType dietType : dietTypes) {
        dietType.addContact(contactFromForm);
      }
      contactFromForm.save();
    }
  }

  /**
   * Updates db with a new diet type.
   *
   * @param dietType The diet type to add.
   */
  public static void addDietType(DietType dietType) {
    dietType.save();
  }

  /**
   * Returns the DietType associated with type string, or throws RuntimeException if not found.
   *
   * @param typeString The type string.
   * @return The instance if found.
   */
  public static DietType getDietType(String typeString) {
    DietType dietType = DietType.find().where().eq("dietType", typeString).findUnique();
    if (dietType == null) {
      throw new RuntimeException("Illegal diet type" + typeString);
    }
    return dietType;
  }

  /**
   * Gets a contact from the contacts in-memory database with a matching ID value.
   *
   * @param id The ID value to match.
   * @return the contact associated with the ID.
   */
  public static Contact getContact(long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Unable to find contact with given ID value.");
    }
    return contact;
  }

  /**
   * Gets a list of all contacts currently stored.
   *
   * @return the full list of contacts.
   */
  public static List<Contact> getContacts() {
    return Contact.find().all();
  }
}
