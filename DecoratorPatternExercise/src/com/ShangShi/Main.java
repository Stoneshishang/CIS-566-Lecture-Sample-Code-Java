package com.ShangShi;

public class Main {
    public class Espresso extends Beverage
// First we extend the Beverage class, since this is a beverage
    {
        public Espresso()
        {
            description = " Espresso ";
//to take care of description, we set this in the constructor for the class.
//remember the description instance variableis inherited from Beverage
        }
        public double cost()
        {
            return 2.99;
//We don't need to worry about adding in condiments in this class
        }
    }
    public static void main(String[] args)
    {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + "$" + beverage.cost());
        beverage = new Mocha(beverage);
//Wrap it in a Mocha
        beverage = new Mocha(beverage);
//Wrap it in second Mocha
        beverage = new Whip(beverage);
//Wrap it in a whip
        System.out.println(beverage.getDescription() + "$" + beverage.cost());
    }
}
