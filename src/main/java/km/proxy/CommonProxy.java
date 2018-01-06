package km.proxy;

import java.io.File;

import km.mod.blocks.allBlocks;
import km.mod.blocks.blockUranium;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



@EventBusSubscriber
public class CommonProxy {
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent event) {
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "tutorial.cfg"));
	}
	public void init(FMLInitializationEvent event) {
		
	}
	public void postInit(FMLPostInitializationEvent event) {
		if(config.hasChanged()) {
			config.save();
		}
	}
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(new blockUranium());
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemBlock(allBlocks.blockUranium).setRegistryName(allBlocks.blockUranium.getRegistryName()));
	}
}
