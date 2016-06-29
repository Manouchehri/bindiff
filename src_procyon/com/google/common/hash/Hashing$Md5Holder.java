package com.google.common.hash;

class Hashing$Md5Holder
{
    static final HashFunction MD5;
    
    static {
        MD5 = new MessageDigestHashFunction("MD5", "Hashing.md5()");
    }
}
