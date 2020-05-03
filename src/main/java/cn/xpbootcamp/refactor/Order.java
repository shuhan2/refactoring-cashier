package cn.xpbootcamp.refactor;

import java.util.List;

public class Order {

  private Customer customer;
  private List<LineItem> lineItems;

  public Order(String customerName, String customerAddress, List<LineItem> lineItems) {
    customer = new Customer(customerName, customerAddress);
    this.lineItems = lineItems;
  }


  public String getState() {
    StringBuilder result = new StringBuilder();
    result.append(stateCustomer());
    result.append(stateLineItems());
    result.append(stateTotalSalesTax());
    result.append(stateTotalAmountWithTax());
    return result.toString();
  }

  private String stateCustomer() {
    StringBuilder result = new StringBuilder();
    result.append(customer.getCustomerName());
    result.append(customer.getCustomerAddress());
    return result.toString();
  }

  private String stateLineItems() {
    StringBuilder result = new StringBuilder();
    for (LineItem lineItem : lineItems) {
      result.append(lineItem.getState());
    }
    return result.toString();
  }

  private String stateTotalSalesTax() {
    StringBuilder result = new StringBuilder();
    result.append("Sales Tax").append('\t').append(calculateTotalSalesTax());
    return result.toString();
  }

  private double calculateTotalSalesTax() {
    double totalSalesTax = 0d;
    for (LineItem lineItem : lineItems) {
      totalSalesTax += lineItem.calculateSalesTax();
    }
    return totalSalesTax;
  }

  private String stateTotalAmountWithTax() {
    StringBuilder result = new StringBuilder();
    result.append("Total Amount").append('\t').append(calculateTotalAmountWithTax());
    return result.toString();
  }

  private double calculateTotalAmountWithTax() {
    double totalAmountWithTax = 0d;
    for (LineItem lineItem : lineItems) {
      totalAmountWithTax += lineItem.calculateTotalAmountWithTax();
    }
    return totalAmountWithTax;
  }
}
