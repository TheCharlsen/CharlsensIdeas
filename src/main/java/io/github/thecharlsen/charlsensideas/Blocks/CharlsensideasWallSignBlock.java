package io.github.thecharlsen.charlsensideas.Blocks;

import io.github.thecharlsen.charlsensideas.Render.CharlsensideasSignTextureRenderer;
import net.minecraft.block.WallSignBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.SignType;

public class CharlsensideasWallSignBlock extends WallSignBlock implements CharlsensideasSignTextureRenderer {
    private final Identifier texture;

    public CharlsensideasWallSignBlock(Identifier texture, Settings settings) {
        super(settings, SignType.OAK); //TODO: take a look at this again
        this.texture = texture;
    }

    @Override
    public Identifier getTexture() {
        return texture;
    }
}