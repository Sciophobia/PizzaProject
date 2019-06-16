package edu.psu.ist;

import java.util.ArrayList;

public class Menu {

    //Class Level Variables - Protect the data
    private int menuId;
    private String menuItem;
    private double menuPrice;

    //Constructor Method
    public Menu(int _menuId, String _menuItem){
        this.menuId = _menuId;
        this.menuItem = _menuItem;
    }

    public Menu(){

    }

public int getMenuId(){
        return this.menuId;
}

    //created a constructor that includes a double menuprice option
    public Menu(int _menuId, String _menuItem, double _menuPrice){
        this.menuId = _menuId;
        this.menuItem = _menuItem;
        this.menuPrice = _menuPrice;
    }


    //created the ability to retrieve menu price
    public double getMenuPrice(){
        return menuPrice;
    }

    //Setters and Getters
    public int getmenuId() { return menuId; }
    public void setmenuId(int _menuId) {this.menuId = _menuId;}

    public String getmenuItem() { return menuItem; }

    public void setmenuItem(String _menuItem) {this.menuItem = _menuItem;}

    public static void listMenu(ArrayList<Menu> mList){
        for (Menu menu: mList){
            //I added the menu ID to the print function
            System.out.println(menu.getmenuId() + ". "+menu.getmenuItem());
        }
    }
}
