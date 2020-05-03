package cn.xpbootcamp.refactor;

public class LineItem {

  private String description;
  private double price;
  private int quantity;

  public LineItem(String description, double price, int quantity) {
    this.description = description;
    this.price = price;
    this.quantity = quantity;
  }

  String getState() {
    StringBuilder result = new StringBuilder();
    result.append(description)
        .append('\t')
        .append(price)
        .append('\t')
        .append(quantity)
        .append('\t')
        .append(calculateTotalAmount())
        .append('\n');
    return result.toString();
  }

  double calculateTotalAmountWithTax() {
    return calculateTotalAmount() + calculateSalesTax();
  }

  double calculateSalesTax() {
    return calculateTotalAmount() * .10;
  }

  private double calculateTotalAmount() {
    return price * quantity;
  }
}