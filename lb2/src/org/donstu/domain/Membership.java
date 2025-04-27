package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class Membership implements Serializable {
    private String clientName;

    private List<Workout> bookedWorkouts;


    public List<Workout> getBookedWorkouts() {
        return bookedWorkouts;
    }

    public void setBookedWorkouts(List<Workout> bookedWorkouts) {
        this.bookedWorkouts = bookedWorkouts;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}