package org.ibex.nestedvm;

public class Runtime$SocketFStat extends Runtime$FStat
{
    public int dev() {
        return -1;
    }
    
    public int type() {
        return 49152;
    }
    
    public int inode() {
        return this.hashCode() & 0x7FFF;
    }
}
