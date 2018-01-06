package km.mod;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import km.util.*;
import org.apache.logging.log4j.Logger;

import km.proxy.*;
@Mod(modid = Reference.MODID, version = Reference.VERSION, name = Reference.NAME)
public class Main {
	@Instance 
	public static Main main;
	
	public static Logger logger;
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	}
	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
