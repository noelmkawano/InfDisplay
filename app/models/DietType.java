package models;

import java.util.ArrayList;
import java.util.List;

/**
 * The Diet Type class holds various Diet Types such as Chicken, Beef, etc.
 */
public class DietType {
  private long id;
  private String dietType;
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Get the id.
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Set the id for the dietType.
   * @param id The new id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the diet type.
   * @return the dietType String.
   */
  public String getDietType() {
    return dietType;
  }

  /**
   * Set the diet type String.
   * @param dietType The diet type to set.
   */
  public void setDietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Gets the list of Contacts.
   * @return The list of Contacts.
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * Set the list of contacts.
   * @param contacts The contacts.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Add the contact.
   * @param contact the contact.
   */
  public void addContact(Contact contact) {
    contacts.add(contact);
  }

  /**
   * Create a new dietType.
   * @param dietType The dietType.
   */
  public DietType(String dietType) {
    this.dietType = dietType;
  }
}
