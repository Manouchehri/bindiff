package org.sqlite;

public enum SQLiteErrorCode
{
    UNKNOWN_ERROR("UNKNOWN_ERROR", 0, -1, "unknown error"), 
    SQLITE_OK("SQLITE_OK", 1, 0, "Successful result"), 
    SQLITE_ERROR("SQLITE_ERROR", 2, 1, "SQL error or missing database"), 
    SQLITE_INTERNAL("SQLITE_INTERNAL", 3, 2, "Internal logic error in SQLite"), 
    SQLITE_PERM("SQLITE_PERM", 4, 3, " Access permission denied"), 
    SQLITE_ABORT("SQLITE_ABORT", 5, 4, " Callback routine requested an abort"), 
    SQLITE_BUSY("SQLITE_BUSY", 6, 5, " The database file is locked"), 
    SQLITE_LOCKED("SQLITE_LOCKED", 7, 6, " A table in the database is locked"), 
    SQLITE_NOMEM("SQLITE_NOMEM", 8, 7, " A malloc() failed"), 
    SQLITE_READONLY("SQLITE_READONLY", 9, 8, " Attempt to write a readonly database"), 
    SQLITE_INTERRUPT("SQLITE_INTERRUPT", 10, 9, " Operation terminated by sqlite3_interrupt()"), 
    SQLITE_IOERR("SQLITE_IOERR", 11, 10, " Some kind of disk I/O error occurred"), 
    SQLITE_CORRUPT("SQLITE_CORRUPT", 12, 11, " The database disk image is malformed"), 
    SQLITE_NOTFOUND("SQLITE_NOTFOUND", 13, 12, " NOT USED. Table or record not found"), 
    SQLITE_FULL("SQLITE_FULL", 14, 13, " Insertion failed because database is full"), 
    SQLITE_CANTOPEN("SQLITE_CANTOPEN", 15, 14, " Unable to open the database file"), 
    SQLITE_PROTOCOL("SQLITE_PROTOCOL", 16, 15, " NOT USED. Database lock protocol error"), 
    SQLITE_EMPTY("SQLITE_EMPTY", 17, 16, " Database is empty"), 
    SQLITE_SCHEMA("SQLITE_SCHEMA", 18, 17, " The database schema changed"), 
    SQLITE_TOOBIG("SQLITE_TOOBIG", 19, 18, " String or BLOB exceeds size limit"), 
    SQLITE_CONSTRAINT("SQLITE_CONSTRAINT", 20, 19, " Abort due to constraint violation"), 
    SQLITE_MISMATCH("SQLITE_MISMATCH", 21, 20, " Data type mismatch"), 
    SQLITE_MISUSE("SQLITE_MISUSE", 22, 21, " Library used incorrectly"), 
    SQLITE_NOLFS("SQLITE_NOLFS", 23, 22, " Uses OS features not supported on host"), 
    SQLITE_AUTH("SQLITE_AUTH", 24, 23, " Authorization denied"), 
    SQLITE_FORMAT("SQLITE_FORMAT", 25, 24, " Auxiliary database format error"), 
    SQLITE_RANGE("SQLITE_RANGE", 26, 25, " 2nd parameter to sqlite3_bind out of range"), 
    SQLITE_NOTADB("SQLITE_NOTADB", 27, 26, " File opened that is not a database file"), 
    SQLITE_ROW("SQLITE_ROW", 28, 100, " sqlite3_step() has another row ready"), 
    SQLITE_DONE("SQLITE_DONE", 29, 101, " sqlite3_step() has finished executing");
    
    public final int code;
    public final String message;
    
    private SQLiteErrorCode(final String s, final int n, final int code, final String message) {
        this.code = code;
        this.message = message;
    }
    
    public static SQLiteErrorCode getErrorCode(final int n) {
        for (final SQLiteErrorCode sqLiteErrorCode : values()) {
            if (n == sqLiteErrorCode.code) {
                return sqLiteErrorCode;
            }
        }
        return SQLiteErrorCode.UNKNOWN_ERROR;
    }
    
    public String toString() {
        return String.format("[%s] %s", this.name(), this.message);
    }
}
