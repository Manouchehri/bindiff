package com.google.common.io;

import java.io.*;

class FileBackedOutputStream$MemoryOutput extends ByteArrayOutputStream
{
    byte[] getBuffer() {
        return this.buf;
    }
    
    int getCount() {
        return this.count;
    }
}
