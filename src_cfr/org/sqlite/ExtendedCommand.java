/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import org.sqlite.ExtendedCommand$BackupCommand;
import org.sqlite.ExtendedCommand$RestoreCommand;
import org.sqlite.ExtendedCommand$SQLExtension;

public class ExtendedCommand {
    public static ExtendedCommand$SQLExtension parse(String string) {
        if (string == null) {
            return null;
        }
        if (string.startsWith("backup")) {
            return ExtendedCommand$BackupCommand.parse(string);
        }
        if (!string.startsWith("restore")) return null;
        return ExtendedCommand$RestoreCommand.parse(string);
    }

    public static String removeQuotation(String string) {
        if (string == null) {
            return string;
        }
        if (string.startsWith("\"")) {
            if (string.endsWith("\"")) return string.substring(1, string.length() - 1);
        }
        if (!string.startsWith("'")) return string;
        if (!string.endsWith("'")) return string;
        return string.substring(1, string.length() - 1);
    }
}

