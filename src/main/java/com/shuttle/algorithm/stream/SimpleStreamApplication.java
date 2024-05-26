package com.shuttle.algorithm.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Shuttle
 * @description: Simple Stream Application
 */
public class SimpleStreamApplication {

    static List<Device> devices;

    static {
        devices = new ArrayList<>();
        devices.add(new Device(101, "Smartphone", "A high-end smartphone with a 6.5-inch display and 128GB storage.", new BigDecimal("699.99")));
        devices.add(new Device(102, "Laptop", "A lightweight laptop with a 13-inch screen and 256GB SSD.", new BigDecimal("999.99")));
        devices.add(new Device(103, "Smartwatch", "A smartwatch with heart rate monitoring and GPS.", new BigDecimal("199.99")));
        devices.add(new Device(104, "Tablet", "A 10-inch tablet with a 64GB storage capacity and stylus support.", new BigDecimal("329.99")));
        devices.add(new Device(105, "Wireless Earbuds", "Noise-cancelling wireless earbuds with 24-hour battery life.", new BigDecimal("149.99")));
        devices.add(new Device(106, "Smart Speaker", "A smart speaker with voice assistant and premium sound quality.", new BigDecimal("99.99")));
        devices.add(new Device(107, "Gaming Console", "A next-gen gaming console with 4K resolution support.", new BigDecimal("499.99")));
        devices.add(new Device(108, "VR Headset", "A virtual reality headset with a wide field of view and high resolution.", new BigDecimal("399.99")));
        devices.add(new Device(109, "Smart Thermostat", "A smart thermostat with learning capabilities and remote control.", new BigDecimal("249.99")));
    }

    public static void main(String[] args) {
        // filter&collect&forEach，筛选出 price 在 [100, 500] 间的 device，并将其收集到 map 中，key->name，value->desc
        BigDecimal leftBoundary = new BigDecimal("100");
        BigDecimal rightBoundary = new BigDecimal("500");
        SimpleStream.of(devices)
                .filter(device -> device.price().compareTo(leftBoundary) >= 0 && device.price().compareTo(rightBoundary) <= 0)
                .collect(() -> new HashMap<String, String>(), (map, device) -> map.put(device.name(), device.desc()))
                .forEach((key, value) -> System.out.println("device: " + key + ", description: " + value));
        /*
            device: Gaming Console, description: A next-gen gaming console with 4K resolution support.
            device: VR Headset, description: A virtual reality headset with a wide field of view and high resolution.
            device: Tablet, description: A 10-inch tablet with a 64GB storage capacity and stylus support.
            device: Wireless Earbuds, description: Noise-cancelling wireless earbuds with 24-hour battery life.
            device: Smart Thermostat, description: A smart thermostat with learning capabilities and remote control.
            device: Smartwatch, description: A smartwatch with heart rate monitoring and GPS.
         */

        // map&reduce，计算 price 总和
        BigDecimal priceSum = SimpleStream.of(devices)
                .map(Device::price)
                .reduce(new BigDecimal("0"), BigDecimal::add);
        System.out.println(priceSum); // 3629.91
    }

}
