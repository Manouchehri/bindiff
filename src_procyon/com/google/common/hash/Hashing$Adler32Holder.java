package com.google.common.hash;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.security.*;
import javax.crypto.spec.*;
import com.google.common.base.*;
import java.util.*;

class Hashing$Adler32Holder
{
    static final HashFunction ADLER_32;
    
    static {
        ADLER_32 = checksumHashFunction(Hashing$ChecksumType.ADLER_32, "Hashing.adler32()");
    }
}
