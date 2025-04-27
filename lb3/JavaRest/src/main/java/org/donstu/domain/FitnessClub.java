package org.donstu.domain;

import java.io.Serializable;
import java.util.List;

public class FitnessClub implements Serializable {
    private List<Workout> workouts;
    private List<GymZone> zones;
    private List<Membership> members;

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<GymZone> getZones() {
        return zones;
    }

    public void setZones(List<GymZone> zones) {
        this.zones = zones;
    }

    public List<Membership> getMembers() {
        return members;
    }

    public void setMembers(List<Membership> members) {
        this.members = members;
    }
}