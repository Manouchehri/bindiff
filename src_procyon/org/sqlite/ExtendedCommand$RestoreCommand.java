package org.sqlite;

import java.sql.*;
import java.util.regex.*;

public class ExtendedCommand$RestoreCommand implements ExtendedCommand$SQLExtension
{
    public final String targetDB;
    public final String srcFile;
    private static Pattern restoreCmd;
    
    public ExtendedCommand$RestoreCommand(final String targetDB, final String srcFile) {
        this.targetDB = targetDB;
        this.srcFile = srcFile;
    }
    
    public static ExtendedCommand$RestoreCommand parse(final String s) {
        if (s != null) {
            final Matcher matcher = ExtendedCommand$RestoreCommand.restoreCmd.matcher(s);
            if (matcher.matches()) {
                String removeQuotation = ExtendedCommand.removeQuotation(matcher.group(2));
                final String removeQuotation2 = ExtendedCommand.removeQuotation(matcher.group(3));
                if (removeQuotation == null || removeQuotation.length() == 0) {
                    removeQuotation = "main";
                }
                return new ExtendedCommand$RestoreCommand(removeQuotation, removeQuotation2);
            }
        }
        throw new SQLException("syntax error: " + s);
    }
    
    public void execute(final DB db) {
        db.restore(this.targetDB, this.srcFile, null);
    }
    
    static {
        ExtendedCommand$RestoreCommand.restoreCmd = Pattern.compile("restore(\\s+(\"[^\"]*\"|'[^']*'|\\S+))?\\s+from\\s+(\"[^\"]*\"|'[^']*'|\\S+)");
    }
}
