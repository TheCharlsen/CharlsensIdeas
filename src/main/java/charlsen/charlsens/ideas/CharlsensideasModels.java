package charlsen.charlsens.ideas;

import net.minecraft.data.client.model.Model;
import net.minecraft.data.client.model.TextureKey;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CharlsensideasModels {

    public static final Model TEMPLATE_ALPINE_BUSH;
    public static final Model TEMPLATER_ALPINE_BUSH_STAGE_0;
    public static final Model TEMPLATE_ALPINE_BUSH_STAGE_1;
    public static final Model VERTICAL_SLAB;

    private static Model block(String parent, TextureKey... requiredTextures) {
        return new Model(Optional.of(new Identifier("charlsensideas", "block/" + parent)), Optional.empty(), requiredTextures);
    }

    static {
        TEMPLATE_ALPINE_BUSH = block("template_alpine_bush", TextureKey.TOP, TextureKey.SIDE);
        TEMPLATER_ALPINE_BUSH_STAGE_0 = block("template_alpine_bush_stage_0", TextureKey.TOP, TextureKey.SIDE);
        TEMPLATE_ALPINE_BUSH_STAGE_1 = block("template_alpine_bush_stage_1", TextureKey.TOP, TextureKey.SIDE);
        VERTICAL_SLAB = block("vertical_slab", TextureKey.TOP, TextureKey.SIDE);
    }
}
