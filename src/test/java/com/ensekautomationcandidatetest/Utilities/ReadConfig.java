package com.ensekautomationcandidatetest.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()
	{
		File propertyFile = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(propertyFile);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {System.out.println("Exception is " + e.getMessage());}
	}

	public String getApplicationURL() {

		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getChromePath() {
		String chromePath = pro.getProperty("chromepath");
		return chromePath;
	}

	public String getEdgepath() {
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}

	public String getFirePath() {
		String firepath = pro.getProperty("firefoxpath");
		return firepath;
	}

	public String getLogFilePath() {
		String logfile = pro.getProperty("logfile");
		return logfile;
	}


}
