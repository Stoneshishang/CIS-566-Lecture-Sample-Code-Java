package com.ShangShi;

import java.util.ArrayList;

public class Main {

    public interface Subject {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObservers();
    }
    public interface Observer {
        public void update(float temp, float humidity, float pressure);
    }
    public interface DisplayElement {
        public void display();
    }

    public class WeatherData implements Subject {
        private ArrayList observers;
        private float temperature;
        private float humidity;
        private float pressure;

        public WeatherData() {
            observers = new ArrayList();
        }

        public void registerObserver(Observer o) {
            observers.add(o);
        }

        public void removeObserver(Observer o) {
            int i = observers.indexOf(o);
            if (i >= 0) {
                observers.remove(i);
            }
        }

        public void notifyObservers() {
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer) observers.get(i);
                observer.update(temperature, humidity, pressure);
            }
        }

        public void measurementsChanged() {
            notifyObservers();
        }

        public void setMeasurements(temperature, humidity, pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            measurementsChanged();
        }
    }


        public class ForecastDisplay implements Observer, DisplayElement {
            private float currentPressure;
            private float lastPressure;
            private WeatherData weatherData;

            public ForecastDisplay(WeatherData weatherData) {
                this.weatherData = weatherData;
// weatherData.registerObserver(this);
            }

            public void update(float temp, float humidity, float pressure) {
                lastPressure = currentPressure;
                currentPressure = pressure;
                display();
            }

            @Override
            public void display() {

            }
        }

            public static void main(String[] args) {
                WeatherData weatherData = new WeatherData();
                ForecastDisplay Forecast = new ForecastDisplay(weatherData);
                weatherData.registerObserver(Forecast);
                weatherData.setMeasurements(80, 65, 30.4f);
                weatherData.setMeasurements(82, 70, 29.2f);
                weatherData.setMeasurements(78, 90, 29.2f);
            }
}
