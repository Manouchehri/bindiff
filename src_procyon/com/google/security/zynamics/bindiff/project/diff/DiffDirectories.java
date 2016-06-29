package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.bindiff.log.*;
import java.io.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.enums.*;

public class DiffDirectories
{
    private static File getDiffsSubDirectory(final Diff diff, final String s) {
        final File matchesDatabase = diff.getMatchesDatabase();
        return new File(String.format("%s%s%s - %s", matchesDatabase.getParent(), File.separator, s, matchesDatabase.getName()));
    }
    
    public static File createDiffCommentsDirectory(final Diff diff) {
        final File diffCommentsDirectory = getDiffCommentsDirectory(diff);
        if (!diffCommentsDirectory.exists() && !diffCommentsDirectory.mkdir()) {
            Logger.logSevere("Severe: Couldn't create diffs comments folder. Save view comment failed.", new Object[0]);
            throw new IOException("Couldn't create diffs comments folder. Save view comment failed.");
        }
        return diffCommentsDirectory;
    }
    
    public static File createDiffDirectory(final File file, final File file2) {
        final File file3 = new File(String.format("%s%s%s", file.getPath(), File.separator, file2.getName()));
        file3.mkdir();
        if (!file3.exists()) {
            throw new IOException();
        }
        return file3;
    }
    
    public static File createDiffReportsDirectory(final Diff diff) {
        final File diffReportsDirectory = getDiffReportsDirectory(diff);
        if (!diffReportsDirectory.exists() && !diffReportsDirectory.mkdir()) {
            Logger.logSevere("Severe: Couldn't create diffs reports folder. Generate report failed.", new Object[0]);
            throw new IOException("Couldn't create diffs reports folder. Generate report failed.");
        }
        return diffReportsDirectory;
    }
    
    public static File createDiffViewsDirectory(final Diff diff) {
        final File diffViewsDirectory = getDiffViewsDirectory(diff);
        if (!diffViewsDirectory.exists() && !diffViewsDirectory.mkdir()) {
            Logger.logSevere("Severe: Couldn't create views folder. Save view failed.", new Object[0]);
            throw new IOException("Couldn't create user views folder. Save view failed.");
        }
        return diffViewsDirectory;
    }
    
    public static File getBinExportFile(final File file, final DiffMetaData diffMetaData, final ESide eSide) {
        return new File(String.format("%s%s%s.%s", file.getParent(), File.separator, diffMetaData.getIdbName(eSide), "BinExport"));
    }
    
    public static File getDiffCommentsDirectory(final Diff diff) {
        return getDiffsSubDirectory(diff, "Comments");
    }
    
    public static String getDiffDestinationDirectoryName(final String s, final String s2) {
        final String s3 = "";
        final File file = new File(s);
        final File file2 = new File(s2);
        final String name = file.getName();
        int n;
        if (name.endsWith(".BinExport")) {
            n = name.lastIndexOf(".BinExport");
        }
        else if (name.endsWith(".idb")) {
            n = name.lastIndexOf(".idb");
        }
        else {
            if (!name.endsWith(".i64")) {
                return "";
            }
            n = name.lastIndexOf(".i64");
        }
        final String value = String.valueOf(s3);
        final String value2 = String.valueOf(name.substring(0, n));
        final String string = new StringBuilder(4 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(value2).append(" vs ").toString();
        final String name2 = file2.getName();
        int n2 = 0;
        if (name2.endsWith(".BinExport")) {
            n2 = name2.lastIndexOf(".BinExport");
        }
        else if (name2.endsWith(".idb")) {
            n2 = name2.lastIndexOf(".idb");
        }
        else if (name2.endsWith(".i64")) {
            n2 = name2.lastIndexOf(".i64");
        }
        final String value3 = String.valueOf(string);
        final String value4 = String.valueOf(name2.substring(0, n2));
        return (value4.length() != 0) ? value3.concat(value4) : new String(value3);
    }
    
    public static File getDiffDirectory(final File file, final File file2) {
        return new File(String.format("%s%s%s", file.getPath(), File.separator, file2.getName()));
    }
    
    public static File getDiffDirectoryFile(final String s, final String s2, final String s3) {
        return new File(String.format("%s%s%s vs %s", s, File.separator, s2, s3));
    }
    
    public static File getDiffReportsDirectory(final Diff diff) {
        return getDiffsSubDirectory(diff, "Reports");
    }
    
    public static File getDiffViewsDirectory(final Diff diff) {
        return getDiffsSubDirectory(diff, "Views");
    }
}
