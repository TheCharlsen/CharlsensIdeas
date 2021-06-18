package charlsen.charlsens.ideas.World.Dimension;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "dether-main")
public class DetherConfig {

    @ConfigEntry.Category("dimension")
    @ConfigEntry.Gui.TransitiveObject
    public DetherDimensionConfig DetherDimensionConfig = new DetherDimensionConfig();

}