package com.github.thecharlsen.charlsensideas.Configs;

import com.github.thecharlsen.charlsensideas.DynamicConfiguration;
import net.minecraft.block.BlockState;

import java.util.Optional;

public class CloudBlockConfig extends DynamicConfiguration {
    public final boolean isFlat;
    public final int maxRadius;
    public final int y;

    public CloudBlockConfig(BlockState state, Optional<String> type, boolean isFlat, int segmentCount, int y) {
        super(state, type);
        this.isFlat = isFlat;
        this.maxRadius = segmentCount;
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public int cloudModifier() {
        return this.isFlat ? 3 : 1;
    }

    public int maxSegments() {
        return this.maxRadius;
    }

    public boolean isFlat() {
        return this.isFlat;
    }
}
/*
everything in CloudFeature and CloudBlockConfig and DynamicConfiguration belongs to the devs-immortal/The-Aether project.
i am not trying to steal their code i am just using it. I hope i can use it :)
 */

