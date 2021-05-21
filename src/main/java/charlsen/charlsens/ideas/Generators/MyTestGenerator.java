package charlsen.charlsens.ideas.Generators;

import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class MyTestGenerator {
    private static final Identifier IGLOO_TOP = new Identifier("igloo/top");

    public static void addPieces(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces) {
        pieces.add(new MyTestPiece(manager, pos, IGLOO_TOP, rotation));
    }
}
