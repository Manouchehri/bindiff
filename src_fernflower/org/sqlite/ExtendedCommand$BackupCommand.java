package org.sqlite;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.sqlite.DB;
import org.sqlite.DB$ProgressObserver;
import org.sqlite.ExtendedCommand;
import org.sqlite.ExtendedCommand$SQLExtension;

public class ExtendedCommand$BackupCommand implements ExtendedCommand$SQLExtension {
   public final String srcDB;
   public final String destFile;
   private static Pattern backupCmd = Pattern.compile("backup(\\s+(\"[^\"]*\"|\'[^\']*\'|\\S+))?\\s+to\\s+(\"[^\"]*\"|\'[^\']*\'|\\S+)");

   public ExtendedCommand$BackupCommand(String var1, String var2) {
      this.srcDB = var1;
      this.destFile = var2;
   }

   public static ExtendedCommand$BackupCommand parse(String var0) {
      if(var0 != null) {
         Matcher var1 = backupCmd.matcher(var0);
         if(var1.matches()) {
            String var2 = ExtendedCommand.removeQuotation(var1.group(2));
            String var3 = ExtendedCommand.removeQuotation(var1.group(3));
            if(var2 == null || var2.length() == 0) {
               var2 = "main";
            }

            return new ExtendedCommand$BackupCommand(var2, var3);
         }
      }

      throw new SQLException("syntax error: " + var0);
   }

   public void execute(DB var1) {
      var1.backup(this.srcDB, this.destFile, (DB$ProgressObserver)null);
   }
}
