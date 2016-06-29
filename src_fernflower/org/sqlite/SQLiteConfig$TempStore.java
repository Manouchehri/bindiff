package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$TempStore implements SQLiteConfig$PragmaValue {
   DEFAULT,
   FILE,
   MEMORY;

   public String getValue() {
      return this.name();
   }
}
