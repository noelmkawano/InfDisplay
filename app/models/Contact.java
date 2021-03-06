package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * A contact object that holds a First Name, Last Name, and Telephone Number.
 */
@Entity
public class Contact extends Model {
  @Id
  private long id;
  private String firstName;
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<DietType> dietTypes;


  /**
   * Create new Contact object.
   *
   * @param firstName the user first name.
   * @param dietTypes A list of dietary preferences.
   */
  public Contact(String firstName, List<DietType> dietTypes) {

    this.firstName = firstName;
    this.dietTypes = dietTypes;
  }

  /**
   * The EBean ORM finder method for database queries.
   *
   * @return The finder method for Contacts.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }

  /**
   * Sets the id.
   *
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Sets the first name.
   *
   * @param firstName The first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set the diet types.
   *
   * @param dietTypes The diet types.
   */
  public void setDietTypes(List<DietType> dietTypes) {
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
  public List<DietType> getDietTypes() {
    return dietTypes;
  }

  /**
   * Returns a single string contains a comma-separated list of diet types.
   *
   * @return The string containing diet types.
   */
  public String getDietTypesString() {
    String diets = "";
    for (DietType diet : dietTypes) {
      diets += diet.getDietType() + ",";
    }
    return diets.substring(0, (diets.length() == 0 ? 0 : (diets.length() - 1)));
  }

  /**
   * Returns a list of diet type strings.
   *
   * @return The list of diet type strings.
   */
  public List<String> getDietTypesList() {
    List<String> dietList = new ArrayList<>();
    for (DietType dietType : this.dietTypes) {
      dietList.add(dietType.getDietType());
    }
    return dietList;
  }
}

