package org.sqlite;

import java.sql.*;
import java.util.regex.*;

public class ExtendedCommand$BackupCommand implements ExtendedCommand$SQLExtension
{
    public final String srcDB;
    public final String destFile;
    private static Pattern backupCmd;
    
    public ExtendedCommand$BackupCommand(final String srcDB, final String destFile) {
        this.srcDB = srcDB;
        this.destFile = destFile;
    }
    
    public static ExtendedCommand$BackupCommand parse(final String s) {
        if (s != null) {
            final Matcher matcher = ExtendedCommand$BackupCommand.backupCmd.matcher(s);
            if (matcher.matches()) {
                String removeQuotation = ExtendedCommand.removeQuotation(matcher.group(2));
                final String removeQuotation2 = ExtendedCommand.removeQuotation(matcher.group(3));
                if (removeQuotation == null || removeQuotation.length() == 0) {
                    removeQuotation = "main";
                }
                return new ExtendedCommand$BackupCommand(removeQuotation, removeQuotation2);
            }
        }
        throw new SQLException("syntax error: " + s);
    }
    
    public void execute(final DB db) {
        db.backup(this.srcDB, this.destFile, null);
    }
    
    static {
        ExtendedCommand$BackupCommand.backupCmd = Pattern.compile("backup(\\s+(\"[^\"]*\"|'[^']*'|\\S+))?\\s+to\\s+(\"[^\"]*\"|'[^']*'|\\S+)");
    }
}
