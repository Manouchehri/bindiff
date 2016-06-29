package com.google.common.hash;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.security.*;
import javax.crypto.spec.*;
import com.google.common.base.*;
import java.util.*;

class Hashing$Crc32Holder
{
    static final HashFunction CRC_32;
    
    static {
        CRC_32 = checksumHashFunction(Hashing$ChecksumType.CRC_32, "Hashing.crc32()");
    }
}
