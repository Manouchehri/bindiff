package com.google.common.hash;

class Hashing$Sha512Holder
{
    static final HashFunction SHA_512;
    
    static {
        SHA_512 = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
    }
}
