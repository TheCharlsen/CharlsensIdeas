package charlsen.charlsens.ideas;

import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Identifier;

public class Charlsensideas implements ModInitializer {

	@Override
	public void onInitialize() {

        CharlsensideasBlocks.blocksInit();
        CharlsensideasItems.itemsInit();
        CharlsensideasFluids.fluidsInit();
        CharlsensideasSoundEvents.soundEventsInit();
        CharlsensideasEnchantments.enchantmentsInit();
        CharlsensideasTools.toolsInit();
        CharlsensideasStatusEffects.statusEffectsInit();
        CharlsensideasBiomes.biomesInit();
        CharlsensideasConfiguredFeatures.configuredFeaturesInit();
        CharlsensideasCallbackEvents.callbackEventsInit();
        CharlsensideasStructures.structuresInit();

        CustomPortalApiRegistry.addPortal(CharlsensideasBlocks.Adrian_Block, PortalIgnitionSource.FluidSource(Fluids.LAVA), new Identifier("charlsensideas", "void"), 51, 52, 49);
        CustomPortalApiRegistry.addPortal(Blocks.DIAMOND_BLOCK, PortalIgnitionSource.FluidSource(Fluids.WATER), new Identifier("charlsensideas", "testdim"), 0, 255, 255);
        CustomPortalApiRegistry.addPortal(CharlsensideasBlocks.WeirdlyDeepStone, PortalIgnitionSource.FluidSource(CharlsensideasFluids.Still_Weird_Water), new Identifier("charlsensideas","farlands"), 1, 42, 54);

	}

}
