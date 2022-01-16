package io.github.thecharlsen.charlsensideas.Blocks;

import io.github.thecharlsen.charlsensideas.Blocks.Enums.Tilt;
import net.minecraft.state.property.EnumProperty;

public class BlockProperties {

    public static final EnumProperty<Tilt> TILT;

    public BlockProperties(){

    }

    static {
        TILT = EnumProperty.of("tilt", Tilt.class);
    }
}
