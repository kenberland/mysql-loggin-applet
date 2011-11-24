package com.reputationdefender.dataret.util.log_receiver;

import java.applet.Applet;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogReceiver extends Applet {

	private static final long serialVersionUID = -742503856365951964L;
	private static String myFileName  = "/tmp/log-receiver.log";
	private static BufferedWriter myBufferedWriter = null;
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

	
	public boolean writeStringToLog(String message) {
		try {
			myBufferedWriter.write(now() + " " + message + "\n");
			myBufferedWriter.flush();
			return true;
		} catch (IOException e) {
			System.err.println("Could not write to file: " + myFileName);
			e.printStackTrace();
		}
		return false;
	}

	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}

	public String getLogFileName(){
		return myFileName;
	}
	
	public void init() {
		try {
			myBufferedWriter = new BufferedWriter(new FileWriter(myFileName));
		} catch (IOException e) {
			System.err.println("Could not write to file: " + myFileName);
			e.printStackTrace();
		}
		
		try {
			myBufferedWriter.write("2BEGIN" + "\n");
			myBufferedWriter.flush();
		} catch (IOException e) {
			System.err.println("Could not write to file: " + myFileName);
			e.printStackTrace();
		}
		
		
	}
} 
