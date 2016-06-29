package org.ibex.nestedvm;

public class UnixRuntime$DevFS extends UnixRuntime$FS
{
    private static final int ROOT_INODE = 1;
    private static final int NULL_INODE = 2;
    private static final int ZERO_INODE = 3;
    private static final int FD_INODE = 4;
    private static final int FD_INODES = 32;
    private Runtime$FD devZeroFD;
    private Runtime$FD devNullFD;
    
    public UnixRuntime$DevFS() {
        this.devZeroFD = new UnixRuntime$DevFS$1(this);
        this.devNullFD = new UnixRuntime$DevFS$2(this);
    }
    
    public Runtime$FD open(final UnixRuntime unixRuntime, final String s, final int n, final int n2) {
        if (s.equals("null")) {
            return this.devNullFD;
        }
        if (s.equals("zero")) {
            return this.devZeroFD;
        }
        if (s.startsWith("fd/")) {
            int int1;
            try {
                int1 = Integer.parseInt(s.substring(4));
            }
            catch (NumberFormatException ex) {
                return null;
            }
            if (int1 < 0 || int1 >= 64) {
                return null;
            }
            if (unixRuntime.fds[int1] == null) {
                return null;
            }
            return unixRuntime.fds[int1].dup();
        }
        else {
            if (s.equals("fd")) {
                int n3 = 0;
                for (int i = 0; i < 64; ++i) {
                    if (unixRuntime.fds[i] != null) {
                        ++n3;
                    }
                }
                final int[] array = new int[n3];
                int n4 = 0;
                for (int j = 0; j < 64; ++j) {
                    if (unixRuntime.fds[j] != null) {
                        array[n4++] = j;
                    }
                }
                return new UnixRuntime$DevFS$3(this, array);
            }
            if (s.equals("")) {
                return new UnixRuntime$DevFS$4(this);
            }
            return null;
        }
    }
    
    public Runtime$FStat stat(final UnixRuntime unixRuntime, final String s) {
        if (s.equals("null")) {
            return this.devNullFD.fstat();
        }
        if (s.equals("zero")) {
            return this.devZeroFD.fstat();
        }
        if (s.startsWith("fd/")) {
            int int1;
            try {
                int1 = Integer.parseInt(s.substring(3));
            }
            catch (NumberFormatException ex) {
                return null;
            }
            if (int1 < 0 || int1 >= 64) {
                return null;
            }
            if (unixRuntime.fds[int1] == null) {
                return null;
            }
            return unixRuntime.fds[int1].fstat();
        }
        else {
            if (s.equals("fd")) {
                return new UnixRuntime$DevFS$5(this);
            }
            if (s.equals("")) {
                return new UnixRuntime$DevFS$6(this);
            }
            return null;
        }
    }
    
    public void mkdir(final UnixRuntime unixRuntime, final String s, final int n) {
        throw new Runtime$ErrnoException(30);
    }
    
    public void unlink(final UnixRuntime unixRuntime, final String s) {
        throw new Runtime$ErrnoException(30);
    }
}
