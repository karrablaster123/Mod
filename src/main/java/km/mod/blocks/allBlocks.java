package km.mod.blocks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class allBlocks {
	@GameRegistry.ObjectHolder("km:blockUranium")
	public static blockUranium blockUranium;
	@SideOnly(Side.CLIENT)
	public static void initModels() {
		blockUranium.initModel();
	}
}
