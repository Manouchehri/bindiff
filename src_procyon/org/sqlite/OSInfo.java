package org.sqlite;

public class OSInfo
{
    public static void main(final String[] array) {
        if (array.length >= 1) {
            if ("--os".equals(array[0])) {
                System.out.print(getOSName());
                return;
            }
            if ("--arch".equals(array[0])) {
                System.out.print(getArchName());
                return;
            }
        }
        System.out.print(getNativeLibFolderPathForCurrentOS());
    }
    
    public static String getNativeLibFolderPathForCurrentOS() {
        return getOSName() + "/" + getArchName();
    }
    
    public static String getOSName() {
        return translateOSNameToFolderName(System.getProperty("os.name"));
    }
    
    public static String getArchName() {
        return translateArchNameToFolderName(System.getProperty("os.arch"));
    }
    
    public static String translateOSNameToFolderName(final String s) {
        if (s.contains("Windows")) {
            return "Windows";
        }
        if (s.contains("Mac")) {
            return "Mac";
        }
        if (s.contains("Linux")) {
            return "Linux";
        }
        return s.replaceAll("\\W", "");
    }
    
    public static String translateArchNameToFolderName(final String s) {
        return s.replaceAll("\\W", "");
    }
}
