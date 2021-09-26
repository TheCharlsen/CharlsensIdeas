package io.github.thecharlsen.charlsensideas.Gui;


import io.github.thecharlsen.charlsensideas.CharlsensideasItems;
import io.github.thecharlsen.charlsensideas.CharlsensideasSoundEvents;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Axis;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import io.github.cottonmc.cotton.gui.widget.icon.ItemIcon;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class MusicPlayerGui extends LightweightGuiDescription {

    public MusicPlayerGui() {

        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(130, 200);

        root.setInsets(Insets.ROOT_PANEL);

        WBox box = new WBox(Axis.VERTICAL);
        WScrollPanel scrollPanel = new WScrollPanel(box);
        root.add(scrollPanel, 0, 1, 8 , 10);
        scrollPanel.setScrollingVertically(TriState.TRUE);

        WLabel  musicplayerlabel = new WLabel(new TranslatableText("gui.text.label.musicplayer"));
        root.add(musicplayerlabel, 0, 0, 4, 1);

        WButton stalbutton = new WButton(new LiteralText(" Stal "));
        stalbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(STALSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Stal"), true);
        });
        stalbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_STAL));
        box.add(stalbutton, 120, 15);
        // (x, y, int width, int height)

        WButton catbutton = new WButton(new LiteralText(" Cat "));
        catbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(CATSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Cat"), true);
        });
        catbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_CAT));
        box.add(catbutton, 120, 15);


        WButton thirteenbutton = new WButton(new LiteralText(" 13 "));
        thirteenbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(THIRTEENSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - 13"), true);
        });
        thirteenbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_13));
        box.add(thirteenbutton, 120, 15);

        WButton blocksbutton = new WButton(new LiteralText(" Blocks "));
        blocksbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(BLOCKSSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Blocks"), true);
        });
        blocksbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_BLOCKS));
        box.add(blocksbutton, 120, 15);

        WButton chirpbutton = new WButton(new LiteralText(" Chirp "));
        chirpbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(CHIRPSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Chirp"), true);
        });
        chirpbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_CHIRP));
        box.add(chirpbutton, 120, 15);


        WButton farbutton = new WButton(new LiteralText(" Far "));
        farbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(FARSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Far"), true);
        });
        farbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_FAR));
        box.add(farbutton, 120, 15);


        WButton mallbutton = new WButton(new LiteralText(" Mall "));
        mallbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(MALLSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Mall"), true);
        });
        mallbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_MALL));
        box.add(mallbutton, 120, 15);


        WButton mellohibutton = new WButton(new LiteralText(" Mellohi "));
        mellohibutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(MELLOHISOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Mellohi"), true);
        });
        mellohibutton.setIcon(new ItemIcon(Items.MUSIC_DISC_MELLOHI));
        box.add(mellohibutton, 120, 15);


        WButton stradbutton = new WButton(new LiteralText(" Strad "));
        stradbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(STRADSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Strad"), true);
        });
        stradbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_STRAD));
        box.add(stradbutton, 120, 15);

        WButton wardbutton = new WButton(new LiteralText(" Ward "));
        wardbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(WARDSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Ward"), true);
        });
        wardbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_WARD));
        box.add(wardbutton, 120, 15);

        WButton elevenbutton = new WButton(new LiteralText(" 11 "));
        elevenbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(ELEVENSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - 11"), true);
        });
        elevenbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_11));
        box.add(elevenbutton, 120, 15);

        WButton waitbutton = new WButton(new LiteralText(" Wait "));
        waitbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(WAITSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Wait"), true);
        });
        waitbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_WAIT));
        box.add(waitbutton, 120, 15);

        WButton pigstepbutton = new WButton(new LiteralText(" Pigstep "));
        pigstepbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(PIGSTEPSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: Lena Raine - Pigstep"), true);
        });
        pigstepbutton.setIcon(new ItemIcon(Items.MUSIC_DISC_PIGSTEP));
        box.add(pigstepbutton, 120, 15);

        WButton dogbutton = new WButton(new LiteralText(" Dog "));
        dogbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(DOGSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: C418 - Dog"), true);
        });
        dogbutton.setIcon(new ItemIcon(CharlsensideasItems.Dog_Music_Disc));
        box.add(dogbutton, 120, 15);

        WButton discordbutton = new WButton(new LiteralText(" DiscordRemix "));
        discordbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(DISCORDSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: Discord - Discord Remix"), true);
        });
        discordbutton.setIcon(new ItemIcon(CharlsensideasItems.Discord_Remix_Music_Disc));
        box.add(discordbutton, 120, 15);

        WButton revengebutton = new WButton(new LiteralText(" Revenge "));
        revengebutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(REVENGESOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: CaptainSparklez, TryHardNinja - Revenge"), true);
        });
        revengebutton.setIcon(new ItemIcon(CharlsensideasItems.Revenge_Music_Disc));
        box.add(revengebutton, 120, 15);

        WButton coconutbutton = new WButton(new LiteralText(" The Coconut Song "));
        coconutbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().play(COCONUTSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Now Playing: Smokey Mountain - The Coconut Song"), true);
        });
        coconutbutton.setIcon(new ItemIcon(CharlsensideasItems.Da_Coconut_nut_Music_Disc));
        box.add(coconutbutton, 120, 15);

        WButton stopbutton = new WButton(new LiteralText(" StopSound "));
        stopbutton.setOnClick(() -> {
            MinecraftClient.getInstance().getSoundManager().stop(STALSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(CATSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(CATSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(THIRTEENSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(BLOCKSSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(CHIRPSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(FARSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(MALLSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(MELLOHISOUND);
            MinecraftClient.getInstance().getSoundManager().stop(STRADSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(WARDSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(ELEVENSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(WAITSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(PIGSTEPSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(DOGSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(DISCORDSOUND);
            MinecraftClient.getInstance().getSoundManager().stop(REVENGESOUND);
            MinecraftClient.getInstance().getSoundManager().stop(COCONUTSOUND);
            MinecraftClient.getInstance().inGameHud.setOverlayMessage(Text.of("Stopped"), true);
        });
        box.add(stopbutton, 120, 15);
        //(x, y, int width, int height)
    }
        private static final PositionedSoundInstance STALSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_STAL, 1.0F);

        public void playstalSound() {
        MinecraftClient.getInstance().getSoundManager().play(STALSOUND);
    }

        public void stopstalSound() {
        MinecraftClient.getInstance().getSoundManager().stop(STALSOUND);
    }


        private static final PositionedSoundInstance CATSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_CAT, 1.0F);

        public void playcatSound() {
        MinecraftClient.getInstance().getSoundManager().play(CATSOUND);
}

        public void stopcatSound() {
        MinecraftClient.getInstance().getSoundManager().stop(CATSOUND);
}


        private static final PositionedSoundInstance THIRTEENSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_13, 1.0F);

        public void playthirteenSound() {
        MinecraftClient.getInstance().getSoundManager().play(THIRTEENSOUND);
}

        public void stopthirteenSound() {
        MinecraftClient.getInstance().getSoundManager().stop(THIRTEENSOUND);
}


        private static final PositionedSoundInstance BLOCKSSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_BLOCKS, 1.0F);

        public void playblocksSound() {
        MinecraftClient.getInstance().getSoundManager().play(BLOCKSSOUND);
}

        public void stopblocksSound() {
        MinecraftClient.getInstance().getSoundManager().stop(BLOCKSSOUND);
}


        private static final PositionedSoundInstance CHIRPSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_CHIRP, 1.0F);

        public void playchirpSound() {
        MinecraftClient.getInstance().getSoundManager().play(CHIRPSOUND);
}

        public void stopchirpSound() {
        MinecraftClient.getInstance().getSoundManager().stop(CHIRPSOUND);
}


        private static final PositionedSoundInstance FARSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_FAR, 1.0F);

        public void playfarSound() {
        MinecraftClient.getInstance().getSoundManager().play(FARSOUND);
}

        public void stopfarSound() {
        MinecraftClient.getInstance().getSoundManager().stop(FARSOUND);
}


        private static final PositionedSoundInstance MALLSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_MALL, 1.0F);

        public void playmallSound() {
        MinecraftClient.getInstance().getSoundManager().play(MALLSOUND);
}

        public void stopmallSound() {
        MinecraftClient.getInstance().getSoundManager().stop(MALLSOUND);
}


        private static final PositionedSoundInstance MELLOHISOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_MELLOHI, 1.0F);

        public void playmellohiSound() {
        MinecraftClient.getInstance().getSoundManager().play(MELLOHISOUND);
}

        public void stopmellohiSound() {
        MinecraftClient.getInstance().getSoundManager().stop(MELLOHISOUND);
}


        private static final PositionedSoundInstance STRADSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_STRAD, 1.0F);

        public void playstradSound() {
        MinecraftClient.getInstance().getSoundManager().play(STRADSOUND);
}

        public void stopstradSound() {
        MinecraftClient.getInstance().getSoundManager().stop(STRADSOUND);
}


        private static final PositionedSoundInstance WARDSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_WARD, 1.0F);

        public void playwardSound() {
        MinecraftClient.getInstance().getSoundManager().play(WARDSOUND);
}

        public void stopwardSound() {
        MinecraftClient.getInstance().getSoundManager().stop(WARDSOUND);
}


        private static final PositionedSoundInstance ELEVENSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_11, 1.0F);

        public void playelevenSound() {
        MinecraftClient.getInstance().getSoundManager().play(ELEVENSOUND);
}

        public void stopelevenSound() {
        MinecraftClient.getInstance().getSoundManager().stop(ELEVENSOUND);
}


        private static final PositionedSoundInstance WAITSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_WAIT, 1.0F);

        public void playwaitSound() {
        MinecraftClient.getInstance().getSoundManager().play(WAITSOUND);
}

        public void stopwaitSound() {
        MinecraftClient.getInstance().getSoundManager().stop(WAITSOUND);
}


        private static final PositionedSoundInstance PIGSTEPSOUND = PositionedSoundInstance.master(SoundEvents.MUSIC_DISC_PIGSTEP, 1.0F);

        public void playpigstepSound() {
        MinecraftClient.getInstance().getSoundManager().play(PIGSTEPSOUND);
}

        public void stoppigstepSound() {
        MinecraftClient.getInstance().getSoundManager().stop(PIGSTEPSOUND);
}


        private static final PositionedSoundInstance DOGSOUND = PositionedSoundInstance.master(CharlsensideasSoundEvents.Dog_Sound_Event, 1.0F);

        public void playdogSound() {
        MinecraftClient.getInstance().getSoundManager().play(DOGSOUND);
    }

        public void stopdogSound() {
        MinecraftClient.getInstance().getSoundManager().stop(DOGSOUND);
    }


        private static final PositionedSoundInstance DISCORDSOUND = PositionedSoundInstance.master(CharlsensideasSoundEvents.Discord_Special_Call_Music_Sound_Event, 1.0F);

        public void playdiscordSound() {
        MinecraftClient.getInstance().getSoundManager().play(DISCORDSOUND);
    }

        public void stopdiscordSound() {
        MinecraftClient.getInstance().getSoundManager().stop(DISCORDSOUND);
    }

        private static final PositionedSoundInstance COCONUTSOUND = PositionedSoundInstance.master(CharlsensideasSoundEvents.Da_Coconut_nut_Sound_Event, 1.0F);

        private static final PositionedSoundInstance REVENGESOUND = PositionedSoundInstance.master(CharlsensideasSoundEvents.Revenge_Sound_Event, 1.0F);

}