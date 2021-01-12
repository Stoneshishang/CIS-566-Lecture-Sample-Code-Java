package com.ShangShi;

public class Main {

    public abstract class Duck {
        FlyBehavior flyBehavior;
        QuackBehavior quackBehavior;
        //each Duck has a reference to something that
        //implement the QuackBehavior and FlyBehavior
        abstract void display();
        public void performFly() {
            flyBehavior.fly();
        }
        public void performQuack() {
            quackBehavior.quack();
        }
        public void swim() {
            System.out.println("All ducks float, even decoys!");
        }
    }


    public interface QuackBehavior {
        void quack();
    }
    public static class Quack implements QuackBehavior {
        public void quack() {
            System.out.println("Quack");
        }
    }
    public static class Squeak implements QuackBehavior {
        public void quack() {
            System.out.println("Squeak");
        }
    }
    public static class FakeQuack implements QuackBehavior {
        public void quack() {
            System.out.println("Fake Quack");
        }
    }


    public interface FlyBehavior {
        void fly();
    }
    public static class FlyWithWings implements FlyBehavior {
        public void fly() {
            System.out.println("I'm flying!!");
        }
    }
    public static class FlyNoWay implements FlyBehavior {
        public void fly() {
            System.out.println("I can't fly");
        }
    }
    public static class FlyRocketPowered implements FlyBehavior {
        public void fly() {
            System.out.println("I'm flying with a rocket");
        }
    }



    public class MallardDuck extends Duck {
        public MallardDuck() {
// A MallardDuck use the Quack class to handle its quack, so when
//PerformQuack is called, the responsibility for the quack is delegated
//to the Quack object.
            quackBehavior = new Quack();
            flyBehavior = new FlyWithWings();
//MallardDuck inherits the quackBehavior and flyBehavior instance variables
//from Duck class
        }
        public void display() {
            System.out.println("I'm a real Mallard duck");
        }
    }

    public class DecoyDuck extends Duck {
        public DecoyDuck() {
            quackBehavior = new FakeQuack();
            flyBehavior = new FlyRocketPowered();
        }
        public void display() {
            System.out.println("I'm a duck Decoy");
        }
    }

    public static class MiniDuckSimulator {
        public static void main(String[] args) {
            DecoyDuck decoy = new DecoyDuck();
            MallardDuck mallard = new MallardDuck();
            mallard.performQuack();
            mallard.performFly(); }
    }
}

