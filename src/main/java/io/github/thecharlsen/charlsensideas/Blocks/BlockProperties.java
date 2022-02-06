package io.github.thecharlsen.charlsensideas.Blocks;

import io.github.thecharlsen.charlsensideas.Blocks.Enums.Tilt;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;

public class BlockProperties {

    public static final EnumProperty<Tilt> TILT;
    public static final IntProperty AGE;

    public BlockProperties(){

    }

    static {
        TILT = EnumProperty.of("tilt", Tilt.class);
        AGE = IntProperty.of("age", 0, 1);
    }
}
