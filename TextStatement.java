import java.util.Enumeration;

public class TextStatement extends Statement {

  public String initialResultString(Customer aCustomer) {
    return "Rental Record for " + aCustomer.getName() + "\n";
  }

  public String eachRentalString(Rental each) {
    return (
      "\t" +
      each.getMovie().getTitle() +
      "\t" +
      String.valueOf(each.getCharge()) +
      "\n"
    );
  }

  public String footerString(Customer aCustomer) {
    String result =
      "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
    result +=
      "You earned " +
      String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
      " frequent renter points";
    return result;
  }

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
