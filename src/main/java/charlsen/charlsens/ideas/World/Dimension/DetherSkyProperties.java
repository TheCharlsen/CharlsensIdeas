package charlsen.charlsens.ideas.World.Dimension;


import charlsen.charlsens.ideas.Charlsensideas;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.SkyProperties;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class DetherSkyProperties extends SkyProperties{
    public DetherSkyProperties() {
        super(1000, true, SkyType.NONE, false, false);
    }


    @Override
    public Vec3d adjustFogColor(Vec3d color, float sunHeight) {
        return getFogColor().multiply(0.003921568627451); // Divide by 255 to amke values between 0 and 1
    }

    @Override
    public boolean useThickFog(int camX, int camY) {
        return true;
    }


    @Environment(EnvType.CLIENT)
    public static float REDDISH_FOG_TINT = 0;

    /**
     * Returns fog color
     * <p>
     * What I done is made it be based on the day/night cycle so the fog will darken at night but brighten during day.
     * calculateVanillaSkyPositioning returns a value which is between 0 and 1 for day/night and fogChangeSpeed is the range
     * that the fog color will cycle between.
     */
    public Vec3d getFogColor() {
        float colorFactor = 1;
        /*
         * The sky will be turned to midnight when brightness is below 50. This lets us get the
         * full range of brightness by utilizing the default brightness that the current celestial time gives.
         */

        return new Vec3d((int)(Math.min(Math.min(0.56f * colorFactor, 0.65f + REDDISH_FOG_TINT)*255, 255)),
                ((int)(Math.min(Math.max(Math.min(0.34f * colorFactor, 0.87f) - REDDISH_FOG_TINT * 0.6f, 0)*255, 255))),
                ((int)(Math.min(Math.max(Math.min((0.001f * colorFactor) * (colorFactor * colorFactor), 0.9f) - REDDISH_FOG_TINT * 1.9f, 0)*255, 255))));
    }
}
