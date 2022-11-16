package commonLibs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

	public static Properties readProperties(String filename) throws Exception {
		filename = filename.trim();

		File file = new File(filename);

		InputStream io = new FileInputStream(file);

		Properties property = new Properties();
		property.load(io);

		return property;
	}

}
