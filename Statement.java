import java.util.Enumeration;

public abstract class Statement {

  public abstract String initialResultString(Customer aCustomer);

  public abstract String eachRentalString(Rental each);

  public abstract String footerString(Customer aCustomer);

  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = this.initialResultString(aCustomer);
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      //show figures for this rental
      result += this.eachRentalString(each);
    }
    //add footer lines
    result += this.footerString(aCustomer);
    return result;
  }
}
