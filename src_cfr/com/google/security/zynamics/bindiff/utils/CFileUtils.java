/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CFileUtils {
    public static String addLastFileSeparator(String string) {
        String string2;
        String string3 = CFileUtils.removeLastFileSeparator(string);
        String string4 = String.valueOf(string3);
        String string5 = String.valueOf(File.separator);
        if (string5.length() != 0) {
            string2 = string4.concat(string5);
            return string2;
        }
        string2 = new String(string4);
        return string2;
    }

    public static /* varargs */ String concatToFileName(String ... arrstring) {
        String string = "";
        String[] arrstring2 = arrstring;
        int n2 = arrstring2.length;
        int n3 = 0;
        while (n3 < n2) {
            String string2 = arrstring2[n3];
            String string3 = String.valueOf(string);
            String string4 = String.valueOf(string2);
            string = string4.length() != 0 ? string3.concat(string4) : new String(string3);
            String string5 = String.valueOf(string);
            String string6 = String.valueOf(File.separator);
            string = string6.length() != 0 ? string5.concat(string6) : new String(string5);
            ++n3;
        }
        return string.substring(0, string.length() - 1);
    }

    public static void deleteDirectory(File file) {
        if (file == null) {
            return;
        }
        if (!file.isDirectory()) return;
        if (!file.exists()) {
            return;
        }
        try {
            File[] arrfile = file.listFiles();
            int n2 = arrfile.length;
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    if (file.delete()) return;
                    throw new IOException("Error while deleting directory.");
                }
                File file2 = arrfile[n3];
                if (file2.isDirectory()) {
                    CFileUtils.deleteDirectory(file2);
                } else if (!file2.delete()) {
                    throw new IOException("Error while deleting file.");
                }
                ++n3;
            } while (true);
        }
        catch (SecurityException var1_2) {
            String string;
            String string2 = String.valueOf(var1_2.getMessage());
            if (string2.length() != 0) {
                string = "Error while deleting directory or subtree.\n ".concat(string2);
                throw new IOException(string);
            }
            string = new String("Error while deleting directory or subtree.\n ");
            throw new IOException(string);
        }
    }

    public static List findFiles(File file, List list) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (file == null) {
            return arrayList;
        }
        if (!file.isDirectory()) return arrayList;
        if (!file.exists()) {
            return arrayList;
        }
        File[] arrfile = file.listFiles();
        int n2 = arrfile.length;
        int n3 = 0;
        while (n3 < n2) {
            File file2 = arrfile[n3];
            if (file2.isDirectory()) {
                arrayList.addAll(CFileUtils.findFiles(file2, list));
            }
            for (String string : list) {
                String string2;
                String string3 = String.valueOf(string);
                String string4 = string2 = string3.length() != 0 ? ".".concat(string3) : new String(".");
                if (!file2.getPath().endsWith(string2)) continue;
                arrayList.add(file2.getPath());
            }
            ++n3;
        }
        return arrayList;
    }

    public static String forceFilenameEndsNotWithExtension(String string, String string2) {
        String string3 = string;
        String string4 = String.valueOf(string2);
        if (!string3.toLowerCase().endsWith((string4.length() != 0 ? ".".concat(string4) : new String(".")).toLowerCase())) return string3;
        String string5 = String.valueOf(string2);
        return string.substring(0, string.length() - (string5.length() != 0 ? ".".concat(string5) : new String(".")).length());
    }

    public static String forceFilenameEndsWithExtension(String string, String string2) {
        String string3 = String.valueOf(string2);
        if (!string.toLowerCase().endsWith((string3.length() != 0 ? ".".concat(string3) : new String(".")).toLowerCase())) return new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".").append(string2).toString();
        return string;
    }

    public static String forceFileSeparators(String string) {
        String string2;
        if (File.separator.equals("/")) {
            string2 = "\\";
            return string.replace(string2, File.separator);
        }
        string2 = "/";
        return string.replace(string2, File.separator);
    }

    public static String getFileExtension(String string) {
        int n2 = string.lastIndexOf(".");
        if (n2 < 1) return "";
        if (n2 != string.length() - 1) return string.substring(n2 + 1);
        return "";
    }

    public static boolean hasFileExtension(String string, String string2) {
        return CFileUtils.getFileExtension(string).equals(string2);
    }

    public static void moveFile(File file, File file2) {
        if (!file.exists()) {
            throw new IOException("Source file does not exist.");
        }
        if (!file2.exists()) {
            throw new IOException("Destination directory does not exist.");
        }
        boolean bl2 = file.renameTo(new File(file2, file.getName()));
        if (bl2) return;
        throw new IOException("Move file failed.");
    }

    public static String removeFileExtension(String string) {
        int n2 = string.lastIndexOf(".");
        if (n2 >= 1) return string.substring(0, n2);
        return string;
    }

    public static String removeLastFileSeparator(String string) {
        if (string == null) return string;
        if (string.isEmpty()) {
            return string;
        }
        String string2 = CFileUtils.forceFileSeparators(string);
        int n2 = string2.lastIndexOf(File.separator);
        if (n2 != string2.length() - 1) return string2;
        return string2.substring(n2, string2.length() - 1);
    }
}

