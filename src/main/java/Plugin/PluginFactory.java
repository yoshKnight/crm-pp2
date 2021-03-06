package Plugin;

import java.util.Properties;

class PluginFactory
{
	private static Properties props = new Properties();
	
	static{
		try
		{
			props.load(PluginFactory.class.getResourceAsStream("/plugins.properties"));
		}
		catch(Exception e)
		{
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Object getPlugin(Class iface) 
	{
		String implName = props.getProperty(iface.getName());
		if (implName == null) {
			throw new RuntimeException("implementation not specified for " + iface.getName() + " in PluginFactory propeties.");
		}
		try {
			return Class.forName(implName).newInstance();
		} catch (Exception ex) {
			throw new RuntimeException("factory unable to construct instance of " + iface.getName());
		}
	}
}