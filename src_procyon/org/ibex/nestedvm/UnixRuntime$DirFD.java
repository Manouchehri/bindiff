package org.ibex.nestedvm;

public abstract class UnixRuntime$DirFD extends Runtime$FD
{
    private int pos;
    
    public UnixRuntime$DirFD() {
        this.pos = -2;
    }
    
    protected abstract int size();
    
    protected abstract String name(final int p0);
    
    protected abstract int inode(final int p0);
    
    protected abstract int myDev();
    
    protected abstract int parentInode();
    
    protected abstract int myInode();
    
    public int flags() {
        return 0;
    }
    
    public int getdents(final byte[] array, int n, int n2) {
        final int n3 = n;
    Label_0247:
        while (n2 > 0 && this.pos < this.size()) {
            Label_0234: {
                int inode = 0;
                int n4 = 0;
                switch (this.pos) {
                    case -2:
                    case -1: {
                        inode = ((this.pos == -1) ? this.parentInode() : this.myInode());
                        if (inode == -1) {
                            break Label_0234;
                        }
                        n4 = 9 + ((this.pos == -1) ? 2 : 1);
                        if (n4 > n2) {
                            break Label_0247;
                        }
                        array[n + 8] = 46;
                        if (this.pos == -1) {
                            array[n + 9] = 46;
                            break;
                        }
                        break;
                    }
                    default: {
                        final byte[] bytes = Runtime.getBytes(this.name(this.pos));
                        n4 = bytes.length + 9;
                        if (n4 > n2) {
                            break Label_0247;
                        }
                        inode = this.inode(this.pos);
                        System.arraycopy(bytes, 0, array, n + 8, bytes.length);
                        break;
                    }
                }
                array[n + n4 - 1] = 0;
                final int n5 = n4 + 3 & 0xFFFFFFFC;
                UnixRuntime.access$500(array, n, n5);
                UnixRuntime.access$500(array, n + 4, inode);
                n += n5;
                n2 -= n5;
            }
            ++this.pos;
        }
        return n - n3;
    }
    
    protected Runtime$FStat _fstat() {
        return new UnixRuntime$DirFD$1(this);
    }
}
