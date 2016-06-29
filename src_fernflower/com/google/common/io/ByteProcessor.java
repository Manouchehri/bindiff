package com.google.common.io;

import com.google.common.annotations.Beta;

@Beta
public interface ByteProcessor {
   boolean processBytes(byte[] var1, int var2, int var3);

   Object getResult();
}
