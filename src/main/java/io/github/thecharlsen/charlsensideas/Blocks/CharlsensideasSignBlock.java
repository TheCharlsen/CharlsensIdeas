package io.github.thecharlsen.charlsensideas.Blocks;

import io.github.thecharlsen.charlsensideas.Render.CharlsensideasSignTextureRenderer;
import net.minecraft.block.SignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

public class CharlsensideasSignBlock extends SignBlock implements CharlsensideasSignTextureRenderer {
    private final Identifier texture;

    public CharlsensideasSignBlock(Identifier texture, Settings settings) {
        super(settings, SignType.OAK);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }
}