package org.example;

import java.util.Objects;

public class Badges extends RewardSystem {
    private String BadgeName;
    private String description;


    public Badges(String badgeName, String description) {
        BadgeName = badgeName;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Badges{" +
                "BadgeName='" + BadgeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Badges badges = (Badges) o;
        return Objects.equals(BadgeName, badges.BadgeName) && Objects.equals(description, badges.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(BadgeName, description);
    }

    public String getBadgeName() {
        return BadgeName;
    }

    public void setBadgeName(String badgeName) {
        BadgeName = badgeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
