package org.sqlite;

public enum SQLiteConfig$Encoding implements SQLiteConfig$PragmaValue
{
    UTF8("UTF8", 0, "UTF-8"), 
    UTF16("UTF16", 1, "UTF-16"), 
    UTF16_LITTLE_ENDIAN("UTF16_LITTLE_ENDIAN", 2, "UTF-16le"), 
    UTF16_BIG_ENDIAN("UTF16_BIG_ENDIAN", 3, "UTF-16be");
    
    public final String typeName;
    
    private SQLiteConfig$Encoding(final String s, final int n, final String typeName) {
        this.typeName = typeName;
    }
    
    public String getValue() {
        return this.typeName;
    }
}
