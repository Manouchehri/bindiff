package org.sqlite;

import org.sqlite.SQLiteConfig$PragmaValue;

public enum SQLiteConfig$JournalMode implements SQLiteConfig$PragmaValue {
   DELETE,
   TRUNCATE,
   PERSIST,
   MEMORY,
   OFF;

   public String getValue() {
      return this.name();
   }
}
