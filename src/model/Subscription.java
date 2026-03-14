package model;

public class Subscription {
    boolean active = false;
    StringBuilder subscriptionName = new StringBuilder("");
    int price = 0;

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getSubscriptionName() {
        return this.subscriptionName.toString();
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = this.subscriptionName.append(subscriptionName);
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
