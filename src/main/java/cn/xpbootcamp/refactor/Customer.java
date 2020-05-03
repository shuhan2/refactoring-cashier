package cn.xpbootcamp.refactor;

public class Customer {
    String name;
    String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    String state() {
      return getName() + getAddress();
    }
}
