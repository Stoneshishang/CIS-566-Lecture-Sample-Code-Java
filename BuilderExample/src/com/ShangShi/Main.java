package com.ShangShi;
package builder;

public class Main {
    /** "Director" */
    public class AerospaceEngineer {
        public void constructAirplane(AirplaneBuilder airplaneBuilder) {
            airplaneBuilder.buildWings();
            airplaneBuilder.buildPowerplant();
            airplaneBuilder.buildSeats();
        }
    }

    /** "AbstractBuilder" */
    public abstract class AirplaneBuilder {
        public abstract void buildWings();
        public abstract void buildPowerplant();
        public abstract void buildSeats();
        public abstract Airplane GetAirplane();
    }

    /** "Product" */
    public class Airplane {
        public float wingspan;
        public String powerplant;
        public int crewSeats;
        public int passengerSeats;
        public show {
            System.out.println(wingspan);
            System.out.println(Powerplant);
            System.out.println(crewSeats);
            System.out.println(passengerSeats);
        }
    }

    /** "ConcreteBuilder" */
    public class CropDuster extends AirplaneBuilder {
        Private Airplane airplane = new Airplane();
        public void buildWings() {
            airplane.Wingspan = 9f;
        }
        public void buildPowerplant() {
            airplane.Powerplant="single piston";
        }
        public void buildSeats() {
            airplane.crewSeats = 1;
            airplane.passengerSeats = 1;
        }
        public Airplance GetAirplane() {
            Return airplane;
        }
    }


    /** "ConcreteBuilder" */
    public class FighterJet extends AirplaneBuilder {
        Private Airplane airplane = new Airplane();
        public void buildWings() {
            airplane.Wingspan = 35.0f;
        }
        public void buildPowerplant() {
            airplane.Powerplant="dual thrust vectoring";
        }
        public void buildSeats() {
            airplane.crewSeats = 1;
            airplane.passengerSeats = 0;
        }
        public Airplance GetAirplane() {
            Return airplane;
        }
    }


    /** "ConcreteBuilder" */
    public class Glider extends AirplaneBuilder {
        Private Airplane airplane = new Airplane();
        public void buildWings() {
            airplane.Wingspan = 57.1f;
        }
        public void buildPowerplant() {
            airplane.Powerplant="No Engine";
        }
        public void buildSeats() {
            airplane.crewSeats = 1;
            airplane.passengerSeats = 0;
        }
        public Airplance GetAirplane() {
            Return airplane;
        }
    }


    /** Application in which given types of airplanes are being
     constructed. */
    public class BuilderExample {
        public static void main(String[] args) {
// instantiate the director (hire the engineer)
            AerospaceEngineer mydirector = new AerospaceEngineer();
// instantiate each concrete builder (take orders)
            AirplaneBuilder crop = new CropDuster();
            AirplaneBuilder fighter = new FighterJet();
            AirplaneBuilder glider = new Glider();
// build a CropDuster
            mydirector.constructAirplane(crop);
            Airplane completedCropDuster = crop.getAirplane();
            commpletedCropDuster.show();
// build a FlghterJet
            mydirector.constructAirplane(fighter);
            Airplane completedFighterJet = fighter.getAirplane();
            commpletedFighterJet.show();
        }
    }
}
