package cn.xpbootcamp.refactor;

import java.util.List;
import java.util.stream.Collectors;

public class Order {

  private Customer customer;
  private List<LineItem> lineItems;

  public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
    customer = new Customer(customerName, customerAddress);
    this.lineItems = lineItems;
  }

  String getState() {
    StringBuilder result = new StringBuilder();
    result.append(customer.state())
        .append(stateLineItems())
        .append(stateTotalSalesTax())
        .append(stateTotalAmountWithTax());
    return result.toString();
  }

  private String stateLineItems() {
    return lineItems.stream()
        .map(LineItem::getState)
        .collect(Collectors.joining());
  }

  private String stateTotalSalesTax() {
    return "Sales Tax" + '\t' + lineItems.stream()
        .map(LineItem::calculateSalesTax)
        .reduce(0d, Double::sum);
  }

  private String stateTotalAmountWithTax() {
    return "Total Amount" + '\t' + lineItems.stream()
        .map(LineItem::calculateTotalAmountWithTax)
        .reduce(0d, Double::sum);
  }

}
