package edu.psu.ist;
/*
Project: Lab 9
Purpose Details: Pizza ordering application
Course: IST 242
Author: Joe Oakes
Date Developed: 3/14/19
Last Date Changed: 3/13/19
Rev: 2
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    int cCount = 1;
    public static void main(String[] args) {

        Main main = new Main();
        int OrderId = 0;
        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char HELP_CODE = '?';
        char userAction;
        final String PROMPT_ACTION = "Add 'C'ustomer, 'P'rint Customer, List 'M'enu, Add 'O'rder, List 'T'ransaction or 'E'xit: ";
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();

        Order order1 = new Order(1);


        Menu menu1 = new Menu(1, "Plain", 5.00);
        Menu menu2 = new Menu(2, "Meat", 6.00);
        Menu menu3 = new Menu(3, "Extra", 7.00);
        Menu menu4 = new Menu(4, "Veg",8.00);

        mList.add(menu1);
        mList.add(menu2);
        mList.add(menu3);
        mList.add(menu4);

        oList.add(order1);
        Scanner sc = new Scanner(System.in);

        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch(userAction) {
                case CUST_CODE : cList.add(main.addCustomer());
                    break;
                case CUST_PRNT : Customer.printCustomer(cList);
                    break;
                case MENU_CODE : Menu.listMenu(mList);
                    break;
                case ORDE_CODE : {
                    Order userOrder = new Order(OrderId);
                    OrderId++;
                    Boolean OrderBool = true;

                    //begin user order prompts

                    while(OrderBool) {
                        //----menu item selection----
                        System.out.println("What item would you like? Please enter number from Menu");
                        int item;

                        Menu menuSelection = new Menu();
                        item = sc.nextInt();

                        for (int i = 0; i < mList.size(); i++) {
                            if (mList.get(i).getMenuId() == item) {
                                menuSelection = mList.get(i);
                            }
                        }


                       //----quantity----
                        System.out.println("Please enter a quantity: ");
                        int quantity;
                        quantity = sc.nextInt();
                        userOrder.addMenuItem(menuSelection, quantity);


                        //prompt user to continue ordering
                        System.out.println("Would you like to make another selection? Yes (1) or No (2)");
                        int whileLoop = sc.nextInt();
                        if(whileLoop==2)
                            OrderBool=false;


                    }
                    //end of while loop time to figure out how user is paying
                    System.out.println();
                    System.out.println("What payment will you use? cash or credit:");
                    String paymentType;
                    paymentType = sc.nextLine();
                    paymentType = sc.nextLine();

                    if(paymentType.equals("credit")){
                        Transaction userTrans = new Transaction(userOrder.getorderId(),userOrder,PaymentType.credit );
                        tList.add(userTrans);
                    }
                    else
                    if(paymentType.equals("cash")){
                        Transaction userTrans = new Transaction(userOrder.getorderId(),userOrder,PaymentType.cash );
                        tList.add(userTrans);

                    }


                    System.out.println();
                    System.out.println("Your Order:");
                    userOrder.printOrder();
                    oList.add(userOrder);
                    System.out.println();
                    break;
                }
                case TRAN_CODE : Transaction.listTransactions(tList);
                    break;
            }

            userAction = getAction(PROMPT_ACTION);
        }
    }

    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    public Customer addCustomer(){
        Customer cust = new Customer(cCount++);
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.println("Please Enter your Phone: ");
        cust.setCustomerPhoneNumber(scnr.nextLine());
        return cust;
    }
}
