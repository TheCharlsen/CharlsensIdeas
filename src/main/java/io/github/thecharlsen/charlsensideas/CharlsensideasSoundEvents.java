package io.github.thecharlsen.charlsensideas;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CharlsensideasSoundEvents {

    public static SoundEvent Dog_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.Dog);
    public static SoundEvent Discord_Special_Call_Music_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.Discord_Special_Call_Music);
    public static final SoundEvent Da_Coconut_nut_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.Da_Coconut_nut);
    public static SoundEvent Revenge_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.Revenge);
    public static SoundEvent Adrian_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.ADRIAN_BLOCK_SOUND);
    public static SoundEvent Block_Tenebris_Portal_Ambient = new SoundEvent(new Identifier("charlsensideas", "block.portal.ambient"));
    public static SoundEvent Block_Tenebris_Portal_Travel = new SoundEvent(new Identifier("charlsensideas", "block.portal.travel"));
    public static SoundEvent Block_Tenebris_Portal_Trigger = new SoundEvent(new Identifier("charlsensideas", "block.portal.trigger"));
    public static SoundEvent Item_Combat_Helmet_Wear = new SoundEvent(new Identifier("charlsensideas", "item.combat_helmet.wear"));

    public static SoundEvent Music_Tenebris_Game_Semi_Cold = new SoundEvent(new Identifier(Charlsensideas.MOD_ID, "music.tenebris.game.semi.cold"));

    public static void soundEventsInit(){

        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.Dog, Dog_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.Discord_Special_Call_Music, Discord_Special_Call_Music_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.Revenge, Revenge_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.Da_Coconut_nut, Da_Coconut_nut_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.ADRIAN_BLOCK_SOUND, Adrian_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, new Identifier("charlsensideas", "block.portal.ambient"), Block_Tenebris_Portal_Ambient);
        Registry.register(Registry.SOUND_EVENT, new Identifier("charlsensideas", "block.portal.travel"), Block_Tenebris_Portal_Travel);
        Registry.register(Registry.SOUND_EVENT, new Identifier("charlsensideas", "block.portal.trigger"), Block_Tenebris_Portal_Trigger);
        Registry.register(Registry.SOUND_EVENT, new Identifier("charlsensideas", "item.combat_helmet.wear"), Item_Combat_Helmet_Wear);
        Registry.register(Registry.SOUND_EVENT, new Identifier(Charlsensideas.MOD_ID, "music.tenebris.game.semi.cold"), Music_Tenebris_Game_Semi_Cold);

    }
}
