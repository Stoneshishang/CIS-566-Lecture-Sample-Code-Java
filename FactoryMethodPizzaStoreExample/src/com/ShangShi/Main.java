package com.ShangShi;

import java.util.ArrayList;

public class Main {

    public abstract class PizzaStore {
        abstract Pizza createPizza(String type);
        public Pizza orderPizza(String type) {
            Pizza pizza;
            pizza = createPizza(type);
            System.out.println("--- Making a " + pizza.getName() + " ---");
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            return pizza;
        }
    }

    public class NYPizzaStore extends PizzaStore {
        Pizza createPizza(String item) {
            if (item.equals("cheese")) {
                return new NYStyleCheesePizza();
            } else if (item.equals("veggie")) {
                return new NYStyleVeggiePizza();
            } else if (item.equals("clam")) {
                return new NYStyleClamPizza();
            } else if (item.equals("pepperoni")) {
                return new NYStylePepperoniPizza();
            } else return null;
        }
    }

    public abstract static class Pizza {
        String name;
        String dough;
        String sauce;
        ArrayList toppings = new ArrayList();
        void prepare() {
            System.out.println("Preparing " + name);
            System.out.println("Tossing dough...");
            System.out.println("Adding sauce...");
            System.out.println("Adding toppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                System.out.println(" " +
                        toppings.get(i));
            }
        }
        void bake() {
            System.out.println("Bake for 25 minutes at 350");
        }
        void cut() {
            System.out.println("Cutting the pizza into diagonal slices");
        }
        void box() {
            System.out.println("Place pizza in official PizzaStore box");
        }
        public String getName() {
            return name;
        }
        public String toString() {
            StringBuffer display = new StringBuffer();
            display.append("---- " + name + " ----\n");
            display.append(dough + "\n");
            display.append(sauce + "\n");
            for (int i = 0; i < toppings.size(); i++) {
                display.append((String )toppings.get(i) + "\n");
            }
            return display.toString();
        }

        public class NYStyleClamPizza extends Pizza {
            public NYStyleClamPizza() {
                name = "NY Style Clam Pizza";
                dough = "Thin Crust Dough";
                sauce = "Marinara Sauce";
                toppings.add("Grated Reggiano Cheese");
                toppings.add("Fresh Clams from Long Island Sound");
            }
        }

        public static void main(String[] args)
        {
            PizzaStore nyStore = new NYPizzaStore();
            PizzaStore chicagoStore = new ChicagoPizzaStore();
            pizza = nyStore.orderPizza("clam");
            System.out.println("Ethan ordered a " +
                    pizza.getName() + "\n");
        }

}
