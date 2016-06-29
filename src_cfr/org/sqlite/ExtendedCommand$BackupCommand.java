/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.sqlite.DB;
import org.sqlite.DB$ProgressObserver;
import org.sqlite.ExtendedCommand;
import org.sqlite.ExtendedCommand$SQLExtension;

public class ExtendedCommand$BackupCommand
implements ExtendedCommand$SQLExtension {
    public final String srcDB;
    public final String destFile;
    private static Pattern backupCmd = Pattern.compile("backup(\\s+(\"[^\"]*\"|'[^']*'|\\S+))?\\s+to\\s+(\"[^\"]*\"|'[^']*'|\\S+)");

    public ExtendedCommand$BackupCommand(String string, String string2) {
        this.srcDB = string;
        this.destFile = string2;
    }

    public static ExtendedCommand$BackupCommand parse(String string) {
        if (string == null) throw new SQLException("syntax error: " + string);
        Matcher matcher = backupCmd.matcher(string);
        if (!matcher.matches()) throw new SQLException("syntax error: " + string);
        String string2 = ExtendedCommand.removeQuotation(matcher.group(2));
        String string3 = ExtendedCommand.removeQuotation(matcher.group(3));
        if (string2 != null) {
            if (string2.length() != 0) return new ExtendedCommand$BackupCommand(string2, string3);
        }
        string2 = "main";
        return new ExtendedCommand$BackupCommand(string2, string3);
    }

    @Override
    public void execute(DB dB2) {
        dB2.backup(this.srcDB, this.destFile, null);
    }
}

