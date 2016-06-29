package org.ibex.nestedvm;

import org.ibex.nestedvm.util.*;
import java.net.*;
import java.io.*;

class UnixRuntime$SocketFD extends Runtime$FD
{
    public static final int TYPE_STREAM = 0;
    public static final int TYPE_DGRAM = 1;
    public static final int LISTEN = 2;
    int flags;
    int options;
    Socket s;
    ServerSocket ss;
    DatagramSocket ds;
    InetAddress bindAddr;
    int bindPort;
    InetAddress connectAddr;
    int connectPort;
    DatagramPacket dp;
    InputStream is;
    OutputStream os;
    private static final byte[] EMPTY;
    
    public int type() {
        return this.flags & 0x1;
    }
    
    public boolean listen() {
        return (this.flags & 0x2) != 0x0;
    }
    
    public UnixRuntime$SocketFD(final int flags) {
        this.bindPort = -1;
        this.connectPort = -1;
        this.flags = flags;
        if (flags == 1) {
            this.dp = new DatagramPacket(UnixRuntime$SocketFD.EMPTY, 0);
        }
    }
    
    public void setOptions() {
        try {
            if (this.s != null && this.type() == 0 && !this.listen()) {
                Platform.socketSetKeepAlive(this.s, (this.options & 0x8) != 0x0);
            }
        }
        catch (SocketException ex) {
            ex.printStackTrace();
        }
    }
    
    public void _close() {
        try {
            if (this.s != null) {
                this.s.close();
            }
            if (this.ss != null) {
                this.ss.close();
            }
            if (this.ds != null) {
                this.ds.close();
            }
        }
        catch (IOException ex) {}
    }
    
    public int read(final byte[] array, final int n, final int n2) {
        if (this.type() == 1) {
            return this.recvfrom(array, n, n2, null, null);
        }
        if (this.is == null) {
            throw new Runtime$ErrnoException(32);
        }
        try {
            final int read = this.is.read(array, n, n2);
            return (read < 0) ? 0 : read;
        }
        catch (IOException ex) {
            throw new Runtime$ErrnoException(5);
        }
    }
    
    public int recvfrom(final byte[] data, final int n, final int length, final InetAddress[] array, final int[] array2) {
        if (this.type() == 0) {
            return this.read(data, n, length);
        }
        if (n != 0) {
            throw new IllegalArgumentException("off must be 0");
        }
        this.dp.setData(data);
        this.dp.setLength(length);
        try {
            if (this.ds == null) {
                this.ds = new DatagramSocket();
            }
            this.ds.receive(this.dp);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            throw new Runtime$ErrnoException(5);
        }
        if (array != null) {
            array[0] = this.dp.getAddress();
            array2[0] = this.dp.getPort();
        }
        return this.dp.getLength();
    }
    
    public int write(final byte[] array, final int n, final int n2) {
        if (this.type() == 1) {
            return this.sendto(array, n, n2, null, -1);
        }
        if (this.os == null) {
            throw new Runtime$ErrnoException(32);
        }
        try {
            this.os.write(array, n, n2);
            return n2;
        }
        catch (IOException ex) {
            throw new Runtime$ErrnoException(5);
        }
    }
    
    public int sendto(final byte[] data, final int n, final int length, InetAddress connectAddr, int connectPort) {
        if (n != 0) {
            throw new IllegalArgumentException("off must be 0");
        }
        if (this.type() == 0) {
            return this.write(data, n, length);
        }
        if (connectAddr == null) {
            connectAddr = this.connectAddr;
            connectPort = this.connectPort;
            if (connectAddr == null) {
                throw new Runtime$ErrnoException(128);
            }
        }
        this.dp.setAddress(connectAddr);
        this.dp.setPort(connectPort);
        this.dp.setData(data);
        this.dp.setLength(length);
        try {
            if (this.ds == null) {
                this.ds = new DatagramSocket();
            }
            this.ds.send(this.dp);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            if ("Network is unreachable".equals(ex.getMessage())) {
                throw new Runtime$ErrnoException(118);
            }
            throw new Runtime$ErrnoException(5);
        }
        return this.dp.getLength();
    }
    
    public int flags() {
        return 2;
    }
    
    public Runtime$FStat _fstat() {
        return new Runtime$SocketFStat();
    }
    
    static {
        EMPTY = new byte[0];
    }
}
