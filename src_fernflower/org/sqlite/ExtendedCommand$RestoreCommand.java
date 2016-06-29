package org.sqlite;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.sqlite.DB;
import org.sqlite.DB$ProgressObserver;
import org.sqlite.ExtendedCommand;
import org.sqlite.ExtendedCommand$SQLExtension;

public class ExtendedCommand$RestoreCommand implements ExtendedCommand$SQLExtension {
   public final String targetDB;
   public final String srcFile;
   private static Pattern restoreCmd = Pattern.compile("restore(\\s+(\"[^\"]*\"|\'[^\']*\'|\\S+))?\\s+from\\s+(\"[^\"]*\"|\'[^\']*\'|\\S+)");

   public ExtendedCommand$RestoreCommand(String var1, String var2) {
      this.targetDB = var1;
      this.srcFile = var2;
   }

   public static ExtendedCommand$RestoreCommand parse(String var0) {
      if(var0 != null) {
         Matcher var1 = restoreCmd.matcher(var0);
         if(var1.matches()) {
            String var2 = ExtendedCommand.removeQuotation(var1.group(2));
            String var3 = ExtendedCommand.removeQuotation(var1.group(3));
            if(var2 == null || var2.length() == 0) {
               var2 = "main";
            }

            return new ExtendedCommand$RestoreCommand(var2, var3);
         }
      }

      throw new SQLException("syntax error: " + var0);
   }

   public void execute(DB var1) {
      var1.restore(this.targetDB, this.srcFile, (DB$ProgressObserver)null);
   }
}
