package com.google.common.hash;

class Hashing$Sha256Holder
{
    static final HashFunction SHA_256;
    
    static {
        SHA_256 = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");
    }
}
