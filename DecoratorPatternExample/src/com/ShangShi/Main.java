package com.ShangShi;

public class Main {


    public abstract class Beverage
    {
        String description = "Beverage";
        //Beverage is an abstract class with two methods
        public String getDescription()
        {
            return description;
//getDescription is already implemented,
//but we need to implement cost()
        }
        public abstract double cost();
    }



    public abstract class CondimentDecorator extends Beverage
    {
        public abstract String getDescription();
//condiment decorators all reimplement
//the getDescription method
    }


    public class DarkRoast extends Beverage
// First we extend the Beverage class, since this is a beverage
    {
        public DarkRoast()
        {
            description = " DarkRoast ";
//to take care of description, we set this in the constructor for the class.
//remember the description instance variable is inherited from Beverage
        }
        public double cost()
        {
            return 1.99;
        }
    }

    public class Mocha extends CondimentDecorator
    {
        // Mocha is a decorator, so we extend condimentDecorator
// remember, CondimentDeorator extend Beverage
        Beverage beverage;
        public Mocha(Beverage beverage)
        {
            this.beverage = beverage;
//a way to set this instance variable to the object we are wrapping
//Here, we pass the beverage we are wrapping to the decorator's constructor.
        }
        public String getDescription()
        {
            return beverage.getDescription() + ",Mocha";
//we want our description to not only include the beverage name, but also
//to include each item decorating the beverage.
//so we first delegate to the object we are decorating to get its description
//then append "Mocha" to that description
        }
        public double cost()
        {
            return .20 + beverage.cost();
// We first delegate the call to the object we are decorating, so that it can
//compute the cost; then add the cost of Mocha to that result.
        }
    }


//Example 2

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
        Beverage beverage = new DarkRoast(); //Make a DarkRoast Object
        System.out.println(beverage.getDescription() + "$" + beverage.cost());
        beverage = new Mocha(beverage);
//Wrap it in a Mocha
        beverage = new Whip(beverage);
//Wrap it in a whip
        System.out.println(beverage.getDescription() + "$" + beverage.cost());

//Example 2
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
