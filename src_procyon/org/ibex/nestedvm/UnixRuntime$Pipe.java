package org.ibex.nestedvm;

class UnixRuntime$Pipe
{
    private final byte[] pipebuf;
    private int readPos;
    private int writePos;
    public final Runtime$FD reader;
    public final Runtime$FD writer;
    
    UnixRuntime$Pipe() {
        this.pipebuf = new byte[2048];
        this.reader = new UnixRuntime$Pipe$Reader(this);
        this.writer = new UnixRuntime$Pipe$Writer(this);
    }
    
    static int access$100(final UnixRuntime$Pipe unixRuntime$Pipe) {
        return unixRuntime$Pipe.writePos;
    }
    
    static int access$200(final UnixRuntime$Pipe unixRuntime$Pipe) {
        return unixRuntime$Pipe.readPos;
    }
    
    static byte[] access$300(final UnixRuntime$Pipe unixRuntime$Pipe) {
        return unixRuntime$Pipe.pipebuf;
    }
    
    static int access$212(final UnixRuntime$Pipe unixRuntime$Pipe, final int n) {
        return unixRuntime$Pipe.readPos += n;
    }
    
    static int access$202(final UnixRuntime$Pipe unixRuntime$Pipe, final int readPos) {
        return unixRuntime$Pipe.readPos = readPos;
    }
    
    static int access$102(final UnixRuntime$Pipe unixRuntime$Pipe, final int writePos) {
        return unixRuntime$Pipe.writePos = writePos;
    }
    
    static int access$112(final UnixRuntime$Pipe unixRuntime$Pipe, final int n) {
        return unixRuntime$Pipe.writePos += n;
    }
}
