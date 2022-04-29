package io.github.thecharlsen.charlsensideas;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasBlockTags {

    public static class Blocks {

        public static final TagKey<Block> Dirtotp = createTag("dirtotp");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(Registry.BLOCK_KEY, new Identifier(Charlsensideas.MOD_ID, name));
        }
    }
}
