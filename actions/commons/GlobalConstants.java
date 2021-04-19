package commons;

import java.io.File;

public class GlobalConstants {
    // URL
    public static final String HOME_URL = "https://demo.nopcommerce.com/";

    public static final int SHORT_TIMEOUT = 5;
    public static final int LONG_TIMEOUT = 30;
    public static final int SLEEP_TIME_WAIT_FOR_PAGE_LOAD = 2;

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String ROOT_FOLDER = System.getProperty("user.dir");

    public static final String UPLOAD_FOLDER = ROOT_FOLDER + File.separator + "uploadFiles";

    public static String getDirectorySlash(String folderName) {
        if (isMac()) {
            folderName = "/" + folderName + "/";
        } else if (isWindows()) {
            folderName = "\\" + folderName + "\\";
        } else {
            folderName = null;
        }
        return folderName;
    }

    public static boolean isWindows() {
        return (OS_NAME.toLowerCase().contains("win"));
    }

    public static boolean isMac() {
        return (OS_NAME.toLowerCase().contains("mac"));
    }
}
