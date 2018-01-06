package km.mod;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

import km.proxy.CommonProxy;
import km.mod.*;
import net.minecraftforge.common.config.Configuration;

public class Config {
	public static final String CATEGORY_GENERAL = "general";
	public static final String CATEGORY_DIMENSIONS = "dimensions";
	
	public static boolean randombool = true;
	public static String randomboolcomment = "Random Boolean. Does nothing";
	
	public static String muhname = "Alex";
	
	
	public static void readConfig() {
		
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initGeneralConfig(cfg);
			initDimensionConfig(cfg);
		}
		catch(Exception e1) {
			Main.logger.log(Level.ERROR, "Problem reading Config File", e1 );
		}
		finally {
			if(cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	private static void initGeneralConfig(Configuration cfg) {
		
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration");
		randombool = cfg.getBoolean("Random Boolean", CATEGORY_GENERAL, randombool, randomboolcomment);
		muhname = cfg.getString("Name", CATEGORY_GENERAL, muhname , "Steve or Alex?");
	}
	
	private static void initDimensionConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension Configuration");
	}
} 
