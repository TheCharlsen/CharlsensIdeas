package io.github.thecharlsen.charlsensideas;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class CharlsensideasSoundEvents {

    public static SoundEvent Dog_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.Dog);
    public static SoundEvent Discord_Special_Call_Music_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.Discord_Special_Call_Music);
    public static final SoundEvent Da_Coconut_nut_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.Da_Coconut_nut);
    public static SoundEvent Revenge_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.Revenge);
    public static SoundEvent Adrian_Sound_Event = new SoundEvent(CharlsensideasIdentifiers.ADRIAN_BLOCK_SOUND);

    public static void soundEventsInit(){

        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.Dog, Dog_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.Discord_Special_Call_Music, Discord_Special_Call_Music_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.Revenge, Revenge_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.Da_Coconut_nut, Da_Coconut_nut_Sound_Event);
        Registry.register(Registry.SOUND_EVENT, CharlsensideasIdentifiers.ADRIAN_BLOCK_SOUND, Adrian_Sound_Event);

    }
}
