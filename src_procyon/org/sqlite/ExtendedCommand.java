package org.sqlite;

public class ExtendedCommand
{
    public static ExtendedCommand$SQLExtension parse(final String s) {
        if (s == null) {
            return null;
        }
        if (s.startsWith("backup")) {
            return ExtendedCommand$BackupCommand.parse(s);
        }
        if (s.startsWith("restore")) {
            return ExtendedCommand$RestoreCommand.parse(s);
        }
        return null;
    }
    
    public static String removeQuotation(final String s) {
        if (s == null) {
            return s;
        }
        if ((s.startsWith("\"") && s.endsWith("\"")) || (s.startsWith("'") && s.endsWith("'"))) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }
}
