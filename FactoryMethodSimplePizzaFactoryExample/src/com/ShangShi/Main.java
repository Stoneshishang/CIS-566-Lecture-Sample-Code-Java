package com.ShangShi;

public class Main {
        public class PizzaStore
        { // give PizzaStore a reference to a SimplePizzaFactory
            SimplePizzaFactory factory;
            // PizzaStore gets the factory passed to it in the constructor
            public PizzaStore(SimplePizzaFactory factory)
            {
                this.factory = factory;
            }
            public orderPizza(String type)
            {
                Pizza pizza;
                //use factory to create its pizza by simply passing on the type of the order
                pizza = factory.createPizza(type);

                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                return pizza;
            }
        }




        Public class SimplePizzaFactory
    {
        Public Pizza createPizza(String type)
    {
        Pizza pizza = null;
        if (type.equals("cheese"))
        {
            pizza = new CheesePizza();
        }
        else if (type.equals("pepperoni") {
        pizza = new PepperoniPizza();
    }
            else if (type.equals("clam") {
        pizza = new ClamPizza();
    }
            else if (type.equals("veggie") {
        pizza = new VeggiePizza();
    }
        return pizza;
    }
    }
    }




    abstract public class Pizza
    {
        String name;
        String dough;
        String sauce;
        ArrayList toppings = new ArrayList();
        public String getName()
        {
            return name;
        }
        public void prepare()
        {
            System.out.println("Preparing " + name);
        }
        public void bake()
        {
            System.out.println("Baking " + name);
        }
        public void cut()
        {
            System.out.println("Cutting " + name);
        }
        public void box()
        {
            System.out.println("Boxing " + name);
        }


        public class CheesePizza extends Pizza
        {
            public CheesePizza()
            {
                name = "Cheese Pizza";
                dough = "Regular Crust";
                sauce = "Marinara Pizza Sauce";
                toppings.add("Fresh Mozzarella");
                toppings.add("Parmesan");
            }

            public static void main(String[] args)
            {
                SimplePizzaFactory factory = new SimplePizzaFactory();
                PizzaStore store = new PizzaStore(factory);
                Pizza pizza = store.orderPizza("cheese");
                System.out.println("We ordered a " + pizza.getName() + "\n");
                pizza = store.orderPizza("veggie");
                System.out.println("We ordered a " + pizza.getName() + "\n");
                //
                // TODO: Add code to start application here
                //
            }
        }
}


