package com.example.e;

public class Laptop extends Device {
    private int ramSize;
    private String processorType;

    public Laptop(String name, double price, double weight, int ramSize, String processorType) {
        super(DeviceType.LAPTOP, name, price, weight);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    @Override
    public String toString() {
        return super.toString() + ", RAM: " + ramSize + " GB, Processor: " + processorType;
    }
}
