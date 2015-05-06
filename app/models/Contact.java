package models;

import java.util.List;

/**
 * A contact object that holds a First Name, Last Name, and Telephone Number.
 */
public class Contact {
  private long id;
  private String firstName;
  private List<String> dietTypes;


  /**
   * Create new Contact object.
   *
   * @param id            the id value.
   * @param firstName     the user first name.
   * @param dietTypes     A list of dietary preferences.
   */
  public Contact(long id, String firstName, List<String> dietTypes) {

    this.id = id;
    this.firstName = firstName;
    this.dietTypes = dietTypes;
  }

  /**
   * Returns the id value to the caller.
   *
   * @return id long value.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns the first name value to the caller.
   *
   * @return firstName String.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the diet Type values to the caller.
   *
   * @return the Diet type value list.
   */
  public List<String> getDietTypes() {
    return dietTypes;
  }
}
