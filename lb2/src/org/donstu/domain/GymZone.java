package org.donstu.domain;

import java.io.Serializable;

public class GymZone implements Serializable {
    private String zoneName;
    private int capacity;

    // Добавьте этот конструктор
    public GymZone(String zoneName, int capacity) {
        this.zoneName = zoneName;
        this.capacity = capacity;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}