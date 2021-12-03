// Builder design pattern
public class CustomerBuilder {
  private String firstname;
  private String lastname;
  private int age;
  private String phone;
  private String email;

  // Constructor assigns defaul value to all the fields
  public CustomerBuilder() {
    this.firstname = "Tom";
    this.lastname = "Cheng";
    this.age = 30;
    this.phone = "1111111";
    this.email= "1111111@gmail.com";
  }

  // each field has a method to set the non-default value
  public CustomerBuilder firstName(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public CustomerBuilder lastName(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public CustomerBuilder email(String email) {
    this.email = email;
    return this;
  }

  public Customer build() {
    return new Customer(this.firstname, this.lastname, this.age, this.phone, this.email);
  }

  public static void main(String[] args) {
    Customer c1 = new CustomerBuilder().firstName("Jack").email("222@gmail.com").build();
    Customer c2 = new CustomerBuilder().lastName("Cruise").build();
  }
}
