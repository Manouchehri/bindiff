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

public class ExtendedCommand$RestoreCommand
implements ExtendedCommand$SQLExtension {
    public final String targetDB;
    public final String srcFile;
    private static Pattern restoreCmd = Pattern.compile("restore(\\s+(\"[^\"]*\"|'[^']*'|\\S+))?\\s+from\\s+(\"[^\"]*\"|'[^']*'|\\S+)");

    public ExtendedCommand$RestoreCommand(String string, String string2) {
        this.targetDB = string;
        this.srcFile = string2;
    }

    public static ExtendedCommand$RestoreCommand parse(String string) {
        if (string == null) throw new SQLException("syntax error: " + string);
        Matcher matcher = restoreCmd.matcher(string);
        if (!matcher.matches()) throw new SQLException("syntax error: " + string);
        String string2 = ExtendedCommand.removeQuotation(matcher.group(2));
        String string3 = ExtendedCommand.removeQuotation(matcher.group(3));
        if (string2 != null) {
            if (string2.length() != 0) return new ExtendedCommand$RestoreCommand(string2, string3);
        }
        string2 = "main";
        return new ExtendedCommand$RestoreCommand(string2, string3);
    }

    @Override
    public void execute(DB dB2) {
        dB2.restore(this.targetDB, this.srcFile, null);
    }
}

