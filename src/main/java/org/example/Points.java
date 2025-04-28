package org.example;

import java.util.Objects;

public class Points extends RewardSystem {
    int requiredPoints;
    int currentPoints;

    public Points(int requiredPoints, int currentPoints) {
        this.requiredPoints = requiredPoints;
        this.currentPoints = currentPoints;
    }


    @Override
    public String toString() {
        return "Points{" +
                "requiredPoints=" + requiredPoints +
                ", currentPoints=" + currentPoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return requiredPoints == points.requiredPoints && currentPoints == points.currentPoints;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requiredPoints, currentPoints);
    }

    public int getRequiredPoints() {
        return requiredPoints;
    }

    public void setRequiredPoints(int requiredPoints) {
        this.requiredPoints = requiredPoints;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }
}
