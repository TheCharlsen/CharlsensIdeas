package io.github.thecharlsen.charlsensideas.Blocks.Enums;

import net.minecraft.util.StringIdentifiable;

public enum Tilt implements StringIdentifiable {
        NONE("none", true),
        UNSTABLE("unstable", false),
        UNDERSTABLE("understable", true),
        UNDERESTIMATED("underestimated", true),
        PARTIAL("partial", true),
        UNACCEPTABLE("unacceptable", true),
        UNPARTIAL("unpartial", true),
        FULL("full", true);

        private final String name;
        private final boolean stable;

        Tilt(String name, boolean stable) {
        this.name = name;
        this.stable = stable;
        }

        public String asString() {
        return this.name;
        }

        public boolean isStable() {
        return this.stable;
        }
}