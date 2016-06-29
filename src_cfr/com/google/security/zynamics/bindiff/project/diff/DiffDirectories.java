/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import java.io.File;
import java.io.IOException;

public class DiffDirectories {
    private static File getDiffsSubDirectory(Diff diff, String string) {
        File file = diff.getMatchesDatabase();
        String string2 = String.format("%s%s%s - %s", file.getParent(), File.separator, string, file.getName());
        return new File(string2);
    }

    public static File createDiffCommentsDirectory(Diff diff) {
        File file = DiffDirectories.getDiffCommentsDirectory(diff);
        if (file.exists()) return file;
        if (file.mkdir()) return file;
        Logger.logSevere("Severe: Couldn't create diffs comments folder. Save view comment failed.", new Object[0]);
        throw new IOException("Couldn't create diffs comments folder. Save view comment failed.");
    }

    public static File createDiffDirectory(File file, File file2) {
        String string = String.format("%s%s%s", file.getPath(), File.separator, file2.getName());
        File file3 = new File(string);
        file3.mkdir();
        if (file3.exists()) return file3;
        throw new IOException();
    }

    public static File createDiffReportsDirectory(Diff diff) {
        File file = DiffDirectories.getDiffReportsDirectory(diff);
        if (file.exists()) return file;
        if (file.mkdir()) return file;
        Logger.logSevere("Severe: Couldn't create diffs reports folder. Generate report failed.", new Object[0]);
        throw new IOException("Couldn't create diffs reports folder. Generate report failed.");
    }

    public static File createDiffViewsDirectory(Diff diff) {
        File file = DiffDirectories.getDiffViewsDirectory(diff);
        if (file.exists()) return file;
        if (file.mkdir()) return file;
        Logger.logSevere("Severe: Couldn't create views folder. Save view failed.", new Object[0]);
        throw new IOException("Couldn't create user views folder. Save view failed.");
    }

    public static File getBinExportFile(File file, DiffMetaData diffMetaData, ESide eSide) {
        return new File(String.format("%s%s%s.%s", file.getParent(), File.separator, diffMetaData.getIdbName(eSide), "BinExport"));
    }

    public static File getDiffCommentsDirectory(Diff diff) {
        return DiffDirectories.getDiffsSubDirectory(diff, "Comments");
    }

    public static String getDiffDestinationDirectoryName(String string, String string2) {
        String string3 = "";
        File file = new File(string);
        File file2 = new File(string2);
        String string4 = file.getName();
        int n2 = 0;
        if (string4.endsWith(".BinExport")) {
            n2 = string4.lastIndexOf(".BinExport");
        } else if (string4.endsWith(".idb")) {
            n2 = string4.lastIndexOf(".idb");
        } else {
            if (!string4.endsWith(".i64")) return "";
            n2 = string4.lastIndexOf(".i64");
        }
        String string5 = String.valueOf(string3);
        String string6 = String.valueOf(string4.substring(0, n2));
        string3 = new StringBuilder(4 + String.valueOf(string5).length() + String.valueOf(string6).length()).append(string5).append(string6).append(" vs ").toString();
        string5 = file2.getName();
        n2 = 0;
        if (string5.endsWith(".BinExport")) {
            n2 = string5.lastIndexOf(".BinExport");
        } else if (string5.endsWith(".idb")) {
            n2 = string5.lastIndexOf(".idb");
        } else if (string5.endsWith(".i64")) {
            n2 = string5.lastIndexOf(".i64");
        }
        String string7 = String.valueOf(string3);
        String string8 = String.valueOf(string5.substring(0, n2));
        return string8.length() != 0 ? string7.concat(string8) : new String(string7);
    }

    public static File getDiffDirectory(File file, File file2) {
        return new File(String.format("%s%s%s", file.getPath(), File.separator, file2.getName()));
    }

    public static File getDiffDirectoryFile(String string, String string2, String string3) {
        return new File(String.format("%s%s%s vs %s", string, File.separator, string2, string3));
    }

    public static File getDiffReportsDirectory(Diff diff) {
        return DiffDirectories.getDiffsSubDirectory(diff, "Reports");
    }

    public static File getDiffViewsDirectory(Diff diff) {
        return DiffDirectories.getDiffsSubDirectory(diff, "Views");
    }
}

