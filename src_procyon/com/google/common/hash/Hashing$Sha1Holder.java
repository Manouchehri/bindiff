package com.google.common.hash;

class Hashing$Sha1Holder
{
    static final HashFunction SHA_1;
    
    static {
        SHA_1 = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
    }
}
