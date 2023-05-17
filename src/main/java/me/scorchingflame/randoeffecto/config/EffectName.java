package me.scorchingflame.randoeffecto.config;

import java.util.Objects;

public class EffectName {
    private final String name;
    private final String description;
    private final int type;

    public EffectName(String name, String description, int type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EffectName that = (EffectName) o;
        return type == that.type && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, type);
    }
}
