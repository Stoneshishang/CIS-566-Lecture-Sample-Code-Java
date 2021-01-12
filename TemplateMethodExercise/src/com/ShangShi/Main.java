package com.ShangShi;

public class Main {

    //CaffeineBeverage is abstract, just like in the class design
    public abstract class CaffeineBeverageWithHook {
        final void prepareRecipe() {
            boilWater();
            brew();
            pourInCup();
            if (customerWantsCondiments()) {
                addCondiments();
            }
        }
        abstract void brew();
        abstract void addCondiments();
        void boilWater() {
            System.out.println("Boiling water");
        }
        void pourInCup() {
            System.out.println("Pouring into cup");
        }
        boolean customerWantsCondiments() {
            return true;
        }
    }

    public class CoffeeWithHook extends CaffeineBeverageWithHook {
        public void brew() {
            System.out.println("Dripping Coffee through filter");
        }
        public void addCondiments() {
            System.out.println("Adding Sugar and Milk");
        }
        public boolean customerWantsCondiments() {
            String answer = getUserInput ();
            if (answer.toLowerCase().startsWith("y")) {
                return true;
            }
            else {
                return false;
            }
        }
        private String getUserInput () {
            String answer = null;
            System.out.print("Would you like milk (y/n)?");
            answer = in.readline();
            return answer;
        }
    }

    public class BestCafe {
        public static void main(String[] args) {
            TeaWithHook tea = new TeaWithHook();
            CoffeeWithHook coffee = new CoffeeWithHook();
            System.out.println("\nMaking tea...");
            tea.prepareRecipe();
            System.out.println("\nMaking coffee...");
            coffee.prepareRecipe();
        }
    }
}
