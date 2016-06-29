package com.google.security.zynamics.bindiff.utils;

import java.io.*;
import java.util.*;

public class CFileUtils
{
    public static String addLastFileSeparator(final String s) {
        final String value = String.valueOf(removeLastFileSeparator(s));
        final String value2 = String.valueOf(File.separator);
        return (value2.length() != 0) ? value.concat(value2) : new String(value);
    }
    
    public static String concatToFileName(final String... array) {
        String s = "";
        for (final String s2 : array) {
            final String value = String.valueOf(s);
            final String value2 = String.valueOf(s2);
            final String value3 = String.valueOf((value2.length() != 0) ? value.concat(value2) : new String(value));
            final String value4 = String.valueOf(File.separator);
            s = ((value4.length() != 0) ? value3.concat(value4) : new String(value3));
        }
        return s.substring(0, s.length() - 1);
    }
    
    public static void deleteDirectory(final File file) {
        if (file == null) {
            return;
        }
        if (!file.isDirectory() || !file.exists()) {
            return;
        }
        try {
            for (final File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    deleteDirectory(file2);
                }
                else if (!file2.delete()) {
                    throw new IOException("Error while deleting file.");
                }
            }
            if (!file.delete()) {
                throw new IOException("Error while deleting directory.");
            }
        }
        catch (SecurityException ex) {
            final String s = "Error while deleting directory or subtree.\n ";
            final String value = String.valueOf(ex.getMessage());
            throw new IOException((value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
    
    public static List findFiles(final File file, final List list) {
        final ArrayList<String> list2 = new ArrayList<String>();
        if (file == null) {
            return list2;
        }
        if (!file.isDirectory() || !file.exists()) {
            return list2;
        }
        for (final File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                list2.addAll((Collection<?>)findFiles(file2, list));
            }
            for (final String s : list) {
                final String s2 = ".";
                final String value = String.valueOf(s);
                if (file2.getPath().endsWith((value.length() != 0) ? s2.concat(value) : new String(s2))) {
                    list2.add(file2.getPath());
                }
            }
        }
        return list2;
    }
    
    public static String forceFilenameEndsNotWithExtension(final String s, final String s2) {
        String substring = s;
        final String lowerCase = substring.toLowerCase();
        final String s3 = ".";
        final String value = String.valueOf(s2);
        if (lowerCase.endsWith(((value.length() != 0) ? s3.concat(value) : new String(s3)).toLowerCase())) {
            final int n = 0;
            final int length = s.length();
            final String s4 = ".";
            final String value2 = String.valueOf(s2);
            substring = s.substring(n, length - ((value2.length() != 0) ? s4.concat(value2) : new String(s4)).length());
        }
        return substring;
    }
    
    public static String forceFilenameEndsWithExtension(final String s, final String s2) {
        final String lowerCase = s.toLowerCase();
        final String s3 = ".";
        final String value = String.valueOf(s2);
        if (lowerCase.endsWith(((value.length() != 0) ? s3.concat(value) : new String(s3)).toLowerCase())) {
            return s;
        }
        return new StringBuilder(1 + String.valueOf(s).length() + String.valueOf(s2).length()).append(s).append(".").append(s2).toString();
    }
    
    public static String forceFileSeparators(final String s) {
        return s.replace(File.separator.equals("/") ? "\\" : "/", File.separator);
    }
    
    public static String getFileExtension(final String s) {
        final int lastIndex = s.lastIndexOf(".");
        if (lastIndex < 1 || lastIndex == s.length() - 1) {
            return "";
        }
        return s.substring(lastIndex + 1);
    }
    
    public static boolean hasFileExtension(final String s, final String s2) {
        return getFileExtension(s).equals(s2);
    }
    
    public static void moveFile(final File file, final File file2) {
        if (!file.exists()) {
            throw new IOException("Source file does not exist.");
        }
        if (!file2.exists()) {
            throw new IOException("Destination directory does not exist.");
        }
        if (!file.renameTo(new File(file2, file.getName()))) {
            throw new IOException("Move file failed.");
        }
    }
    
    public static String removeFileExtension(final String s) {
        final int lastIndex = s.lastIndexOf(".");
        if (lastIndex < 1) {
            return s;
        }
        return s.substring(0, lastIndex);
    }
    
    public static String removeLastFileSeparator(final String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        final String forceFileSeparators = forceFileSeparators(s);
        final int lastIndex = forceFileSeparators.lastIndexOf(File.separator);
        if (lastIndex == forceFileSeparators.length() - 1) {
            return forceFileSeparators.substring(lastIndex, forceFileSeparators.length() - 1);
        }
        return forceFileSeparators;
    }
}
