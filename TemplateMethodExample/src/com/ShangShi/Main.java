package com.ShangShi;

public class Main {
    //CaffeineBeverage is abstract, just like in the class design
    public abstract class CaffeineBeverage {
        final void prepareRecipe() {
            boilWater();
            brew();
            pourInCup();
            addCondiments();
        }
        abstract void brew();
        abstract void addCondiments();
        void boilWater() {
            System.out.println("Boiling water");
        }
        void pourInCup() {
            System.out.println("Pouring into cup");
        }
    }

    public class Coffee extends CaffeineBeverage {
        public void brew() {
            System.out.println("Dripping Coffee through filter");
        }
        public void addCondiments() {
            System.out.println("Adding Sugar and Milk");
        }
    }
    public class Tea extends CaffeineBeverage {
        public void brew() {
            System.out.println("Steeping the tea");
        }
        public void addCondiments() {
            System.out.println("Adding Lemon");
        }
    }

    public class BestCafe {
        public static void main(String[] args) {
            CaffeineBeverage tea = new Tea();
            CaffeineBeverage coffee = new Coffee();
            System.out.println("\nMaking tea...");
            tea.prepareRecipe();
            System.out.println("\nMaking coffee...");
            coffee.prepareRecipe();
        }
    }
}
