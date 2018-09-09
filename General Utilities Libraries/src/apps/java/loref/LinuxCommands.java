package apps.java.loref;

import java.io.File;
import java.io.IOException;
import static apps.java.loref.GeneralUtilitiesLibrary.parseShellCommand;
import static apps.java.loref.GeneralUtilitiesLibrary.printErrorLog;

public class LinuxCommands {

    public static final String PUBLIC_IP_COMMAND = "curl ifconfig.co";
    public static final String LOCAL_IP_COMMAND = "hostname -I";

    public static final String ERROR = "[error]";

    public static String getUptime() {

	try {

	    return parseShellCommand("uptime").replaceAll("[\n\r]", "");

	} catch (IOException | InterruptedException e) {

	    printErrorLog(e);
	    return ERROR;

	}

    }

    public static String getLocalIPAddresses() {

	try {

	    return parseShellCommand(LOCAL_IP_COMMAND).replaceAll("[\r\n]", "");

	} catch (IOException | InterruptedException e) {

	    printErrorLog(e);
	    return ERROR;

	}

    }

    public static String getPublicIPAddresses() {

	try {

	    return parseShellCommand(PUBLIC_IP_COMMAND).replaceAll("[\r\n]", "");

	} catch (IOException | InterruptedException e) {

	    printErrorLog(e);
	    return ERROR;

	}

    }

    public static double getFreeSpace(String mountPosition) {

	long reply = new File(mountPosition).getUsableSpace();
	return (double) reply / 1024.0 / 1024.0;

    }
    
    public static double getTotalSpace(String mountPosition) {

	long reply = new File(mountPosition).getTotalSpace();
	return (double) reply / 1024.0 / 1024.0;

    }

}
