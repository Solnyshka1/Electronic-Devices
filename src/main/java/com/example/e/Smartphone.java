package com.example.e;

public class Smartphone extends Device {
    private double screenSize;
    private double cameraResolution;

    public Smartphone(String name, double price, double weight, double screenSize, double cameraResolution) {
        super(DeviceType.SMARTPHONE, name, price, weight);
        this.screenSize = screenSize;
        this.cameraResolution = cameraResolution;
    }

    @Override
    public String toString() {
        return super.toString() + ", Screen Size: " + screenSize + " inches, Camera: " + cameraResolution + " MP";
    }

    public double getScreenSize() {
        return screenSize;
    }

    public double getCameraResolution() {
        return cameraResolution;
    }
}
