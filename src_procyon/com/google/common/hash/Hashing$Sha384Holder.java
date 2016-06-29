package com.google.common.hash;

class Hashing$Sha384Holder
{
    static final HashFunction SHA_384;
    
    static {
        SHA_384 = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
    }
}
