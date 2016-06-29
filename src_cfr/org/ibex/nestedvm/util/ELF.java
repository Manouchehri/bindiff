/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.ibex.nestedvm.util.ELF$ELFException;
import org.ibex.nestedvm.util.ELF$ELFHeader;
import org.ibex.nestedvm.util.ELF$ELFIdent;
import org.ibex.nestedvm.util.ELF$PHeader;
import org.ibex.nestedvm.util.ELF$SHeader;
import org.ibex.nestedvm.util.ELF$Symtab;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public class ELF {
    private static final int ELF_MAGIC = 2135247942;
    public static final int ELFCLASSNONE = 0;
    public static final int ELFCLASS32 = 1;
    public static final int ELFCLASS64 = 2;
    public static final int ELFDATANONE = 0;
    public static final int ELFDATA2LSB = 1;
    public static final int ELFDATA2MSB = 2;
    public static final int SHT_SYMTAB = 2;
    public static final int SHT_STRTAB = 3;
    public static final int SHT_NOBITS = 8;
    public static final int SHF_WRITE = 1;
    public static final int SHF_ALLOC = 2;
    public static final int SHF_EXECINSTR = 4;
    public static final int PF_X = 1;
    public static final int PF_W = 2;
    public static final int PF_R = 4;
    public static final int PT_LOAD = 1;
    public static final short ET_EXEC = 2;
    public static final short EM_MIPS = 8;
    private Seekable data;
    public ELF$ELFIdent ident;
    public ELF$ELFHeader header;
    public ELF$PHeader[] pheaders;
    public ELF$SHeader[] sheaders;
    private byte[] stringTable;
    private boolean sectionReaderActive;
    private ELF$Symtab _symtab;

    private void readFully(byte[] arrby) {
        int n2 = arrby.length;
        int n3 = 0;
        while (n2 > 0) {
            int n4 = this.data.read(arrby, n3, n2);
            if (n4 == -1) {
                throw new IOException("EOF");
            }
            n3 += n4;
            n2 -= n4;
        }
    }

    private int readIntBE() {
        byte[] arrby = new byte[4];
        this.readFully(arrby);
        return (arrby[0] & 255) << 24 | (arrby[1] & 255) << 16 | (arrby[2] & 255) << 8 | (arrby[3] & 255) << 0;
    }

    private int readInt() {
        int n2 = this.readIntBE();
        if (this.ident == null) return n2;
        if (this.ident.data != 1) return n2;
        return n2 << 24 & -16777216 | n2 << 8 & 16711680 | n2 >>> 8 & 65280 | n2 >> 24 & 255;
    }

    private short readShortBE() {
        byte[] arrby = new byte[2];
        this.readFully(arrby);
        return (short)((arrby[0] & 255) << 8 | (arrby[1] & 255) << 0);
    }

    private short readShort() {
        short s2 = this.readShortBE();
        if (this.ident == null) return s2;
        if (this.ident.data != 1) return s2;
        return (short)((s2 << 8 & 65280 | s2 >> 8 & 255) & 65535);
    }

    private byte readByte() {
        byte[] arrby = new byte[1];
        this.readFully(arrby);
        return arrby[0];
    }

    public ELF(String string) {
        this(new Seekable$File(string, false));
    }

    public ELF(Seekable seekable) {
        int n2;
        this.data = seekable;
        this.ident = new ELF$ELFIdent(this);
        this.header = new ELF$ELFHeader(this);
        this.pheaders = new ELF$PHeader[this.header.phnum];
        for (n2 = 0; n2 < this.header.phnum; ++n2) {
            seekable.seek(this.header.phoff + n2 * this.header.phentsize);
            this.pheaders[n2] = new ELF$PHeader(this);
        }
        this.sheaders = new ELF$SHeader[this.header.shnum];
        for (n2 = 0; n2 < this.header.shnum; ++n2) {
            seekable.seek(this.header.shoff + n2 * this.header.shentsize);
            this.sheaders[n2] = new ELF$SHeader(this);
        }
        if (this.header.shstrndx < 0) throw new ELF$ELFException(this, "Bad shstrndx");
        if (this.header.shstrndx >= this.header.shnum) {
            throw new ELF$ELFException(this, "Bad shstrndx");
        }
        seekable.seek(this.sheaders[this.header.shstrndx].offset);
        this.stringTable = new byte[this.sheaders[this.header.shstrndx].size];
        this.readFully(this.stringTable);
        n2 = 0;
        while (n2 < this.header.shnum) {
            ELF$SHeader eLF$SHeader = this.sheaders[n2];
            eLF$SHeader.name = this.getString(eLF$SHeader.nameidx);
            ++n2;
        }
    }

    private String getString(int n2) {
        return this.getString(n2, this.stringTable);
    }

    private String getString(int n2, byte[] arrby) {
        StringBuffer stringBuffer = new StringBuffer();
        if (n2 < 0) return "<invalid strtab entry>";
        if (n2 >= arrby.length) {
            return "<invalid strtab entry>";
        }
        while (n2 >= 0) {
            if (n2 >= arrby.length) return stringBuffer.toString();
            if (arrby[n2] == 0) return stringBuffer.toString();
            stringBuffer.append(arrby[n2++]);
        }
        return stringBuffer.toString();
    }

    public ELF$SHeader sectionWithName(String string) {
        int n2 = 0;
        while (n2 < this.sheaders.length) {
            if (this.sheaders[n2].name.equals(string)) {
                return this.sheaders[n2];
            }
            ++n2;
        }
        return null;
    }

    public ELF$Symtab getSymtab() {
        if (this._symtab != null) {
            return this._symtab;
        }
        if (this.sectionReaderActive) {
            throw new ELF$ELFException(this, "Can't read the symtab while a section reader is active");
        }
        ELF$SHeader eLF$SHeader = this.sectionWithName(".symtab");
        if (eLF$SHeader == null) return null;
        if (eLF$SHeader.type != 2) {
            return null;
        }
        ELF$SHeader eLF$SHeader2 = this.sectionWithName(".strtab");
        if (eLF$SHeader2 == null) return null;
        if (eLF$SHeader2.type != 3) {
            return null;
        }
        byte[] arrby = new byte[eLF$SHeader2.size];
        DataInputStream dataInputStream = new DataInputStream(eLF$SHeader2.getInputStream());
        dataInputStream.readFully(arrby);
        dataInputStream.close();
        this._symtab = new ELF$Symtab(this, eLF$SHeader.offset, eLF$SHeader.size, arrby);
        return this._symtab;
    }

    private static String toHex(int n2) {
        return new StringBuffer().append("0x").append(Long.toString((long)n2 & 0xFFFFFFFFL, 16)).toString();
    }

    static int access$000(ELF eLF) {
        return eLF.readIntBE();
    }

    static byte access$100(ELF eLF) {
        return eLF.readByte();
    }

    static short access$200(ELF eLF) {
        return eLF.readShort();
    }

    static int access$300(ELF eLF) {
        return eLF.readInt();
    }

    static String access$400(int n2) {
        return ELF.toHex(n2);
    }

    static boolean access$500(ELF eLF) {
        return eLF.sectionReaderActive;
    }

    static boolean access$502(ELF eLF, boolean bl2) {
        eLF.sectionReaderActive = bl2;
        return eLF.sectionReaderActive;
    }

    static Seekable access$600(ELF eLF) {
        return eLF.data;
    }

    static String access$700(ELF eLF, int n2, byte[] arrby) {
        return eLF.getString(n2, arrby);
    }
}

