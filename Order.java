package edu.psu.ist;
import java.util.Scanner;
import java.util.ArrayList;

public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private Customer cust;
    private ArrayList<Menu> menuItem = new ArrayList<>();
    double total;

    //Constructor MethodO
    public Order(int _orderId) {
        this.orderId = _orderId;
    }

    //Setters and Getters
    public int getorderId() {
        return orderId;
    }

    public void setorderId(int _orderId) {
        this.orderId = _orderId;
    }

    public double getTotal(){
        return total;
    }
    //added printOrder
    public void printOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("_____________________________");
        for (int i = 0; i < menuItem.size(); i++) {
            System.out.println("Item: " + menuItem.get(i).getmenuItem());
            System.out.println("Price: " + menuItem.get(i).getMenuPrice());
        }
        System.out.println("Grand Total: " + total);
    }

    //added a method to add menu items with their quantity
    public void addMenuItem(Menu item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.menuItem.add(item);
            //gathers total as quantity is added
            total+=item.getMenuPrice();
        }


        }

    }


