package com.google.security.zynamics.bindiff.database;

import com.google.security.zynamics.bindiff.database.QueryBuilder;
import com.google.security.zynamics.bindiff.database.SqliteDatabase;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.io.proto.BinExportReader;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffDirectories;
import com.google.security.zynamics.bindiff.project.matches.AddressPair;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.IAddressPair;
import com.google.security.zynamics.bindiff.project.matches.InstructionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCall;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.types.Matches;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MatchesDatabase extends SqliteDatabase {
   public static int UNSAVED_BASICBLOCKMATCH_ALGORITH_ID = -1;
   private static int DEFAULT_FILE_TABLE_COLUMN_COUNT = 13;

   public MatchesDatabase(File var1) {
      super(var1);
   }

   private void addBasicblockMatches(FunctionMatchData var1) {
      int var2 = this.getFunctionMatchId(var1);
      int var3 = this.getNextBasicblockMatchId();
      PreparedStatement var4 = this.connection.prepareStatement("INSERT INTO basicblock VALUES (?, ?, ?, ?, ?, ?)");
      Throwable var5 = null;

      try {
         PreparedStatement var6 = this.connection.prepareStatement("INSERT INTO instruction VALUES (?, ?, ?)");
         Throwable var7 = null;

         try {
            int var8 = this.getAlgorithmIdForManuallyMatchedBasicblocks();

            for(Iterator var9 = var1.getBasicblockMatches().iterator(); var9.hasNext(); ++var3) {
               BasicBlockMatchData var10 = (BasicBlockMatchData)var9.next();
               int var11 = var10.getAlgorithmId();
               var4.setInt(1, var3);
               var4.setInt(2, var2);
               var4.setLong(3, var10.getAddress(ESide.PRIMARY));
               var4.setLong(4, var10.getAddress(ESide.SECONDARY));
               var4.setInt(5, var11 == UNSAVED_BASICBLOCKMATCH_ALGORITH_ID?var8:var11);
               var4.setInt(6, var11 == UNSAVED_BASICBLOCKMATCH_ALGORITH_ID?1:0);
               var4.addBatch();
               InstructionMatchData[] var12 = var10.getInstructionMatches();
               int var13 = var12.length;

               for(int var14 = 0; var14 < var13; ++var14) {
                  InstructionMatchData var15 = var12[var14];
                  var6.setInt(1, var3);
                  var6.setLong(2, var15.getAddress(ESide.PRIMARY));
                  var6.setLong(3, var15.getAddress(ESide.SECONDARY));
                  var6.addBatch();
               }
            }

            var4.executeBatch();
            var6.executeBatch();
         } catch (Throwable var37) {
            var7 = var37;
            throw var37;
         } finally {
            if(var6 != null) {
               if(var7 != null) {
                  try {
                     var6.close();
                  } catch (Throwable var36) {
                     var7.addSuppressed(var36);
                  }
               } else {
                  var6.close();
               }
            }

         }
      } catch (Throwable var39) {
         var5 = var39;
         throw var39;
      } finally {
         if(var4 != null) {
            if(var5 != null) {
               try {
                  var4.close();
               } catch (Throwable var35) {
                  var5.addSuppressed(var35);
               }
            } else {
               var4.close();
            }
         }

      }
   }

   private void alterFileTable() {
      PreparedStatement var1 = this.connection.prepareStatement("SELECT * FROM file");
      Throwable var2 = null;

      try {
         ResultSet var3 = var1.executeQuery();
         Throwable var4 = null;

         try {
            if(var3.getMetaData().getColumnCount() == DEFAULT_FILE_TABLE_COLUMN_COUNT) {
               PreparedStatement var5 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN functionname VARCHAR");
               Throwable var6 = null;

               try {
                  PreparedStatement var7 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN functiontype INT");
                  Throwable var8 = null;

                  try {
                     PreparedStatement var9 = this.connection.prepareStatement("ALTER TABLE file ADD COLUMN flowgraphoffset INT");
                     Throwable var10 = null;

                     try {
                        var5.executeUpdate();
                        var7.executeUpdate();
                        var9.executeUpdate();
                     } catch (Throwable var117) {
                        var10 = var117;
                        throw var117;
                     } finally {
                        if(var9 != null) {
                           if(var10 != null) {
                              try {
                                 var9.close();
                              } catch (Throwable var116) {
                                 var10.addSuppressed(var116);
                              }
                           } else {
                              var9.close();
                           }
                        }

                     }
                  } catch (Throwable var119) {
                     var8 = var119;
                     throw var119;
                  } finally {
                     if(var7 != null) {
                        if(var8 != null) {
                           try {
                              var7.close();
                           } catch (Throwable var115) {
                              var8.addSuppressed(var115);
                           }
                        } else {
                           var7.close();
                        }
                     }

                  }
               } catch (Throwable var121) {
                  var6 = var121;
                  throw var121;
               } finally {
                  if(var5 != null) {
                     if(var6 != null) {
                        try {
                           var5.close();
                        } catch (Throwable var114) {
                           var6.addSuppressed(var114);
                        }
                     } else {
                        var5.close();
                     }
                  }

               }
            }
         } catch (Throwable var123) {
            var4 = var123;
            throw var123;
         } finally {
            if(var3 != null) {
               if(var4 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var113) {
                     var4.addSuppressed(var113);
                  }
               } else {
                  var3.close();
               }
            }

         }
      } catch (Throwable var125) {
         var2 = var125;
         throw var125;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var112) {
                  var2.addSuppressed(var112);
               }
            } else {
               var1.close();
            }
         }

      }

   }

   private int countFunctionSimilarity(double var1, double var3) {
      PreparedStatement var5 = this.connection.prepareStatement("SELECT COUNT(*) AS intervalcount FROM function WHERE similarity >= ? AND similarity < ?");
      Throwable var6 = null;

      int var8;
      try {
         var5.setDouble(1, var1);
         var5.setDouble(2, var3);
         ResultSet var7 = var5.executeQuery();
         if(!var7.next()) {
            return 0;
         }

         var8 = var7.getInt("intervalcount");
      } catch (Throwable var18) {
         var6 = var18;
         throw var18;
      } finally {
         if(var5 != null) {
            if(var6 != null) {
               try {
                  var5.close();
               } catch (Throwable var17) {
                  var6.addSuppressed(var17);
               }
            } else {
               var5.close();
            }
         }

      }

      return var8;
   }

   private int[] countFunctionSimilarityIntervals() {
      int[] var1 = new int[11];

      for(int var2 = 0; var2 <= 10; ++var2) {
         var1[var2] = this.countFunctionSimilarity((double)var2 * 0.1D, (double)(var2 + 1) * 0.1D);
      }

      return var1;
   }

   private int countMatchedFunctions() {
      Statement var1 = this.connection.createStatement();
      Throwable var2 = null;

      try {
         ResultSet var3 = var1.executeQuery("SELECT COUNT(*) AS matchedfunctioncount FROM function");
         if(var3.next()) {
            int var4 = var3.getInt("matchedfunctioncount");
            return var4;
         }
      } catch (Throwable var14) {
         var2 = var14;
         throw var14;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var13) {
                  var2.addSuppressed(var13);
               }
            } else {
               var1.close();
            }
         }

      }

      return 0;
   }

   private void deleteBasiblockMatches(long var1, long var3) {
      PreparedStatement var5 = this.connection.prepareStatement("SELECT basicblock.id FROM function INNER JOIN basicblock ON basicblock.functionid = function.id WHERE function.address1 = ? AND function.address2 = ?");
      Throwable var6 = null;

      ResultSet var7;
      Throwable var8;
      QueryBuilder var9;
      try {
         var5.setLong(1, var1);
         var5.setLong(2, var3);
         var7 = var5.executeQuery();
         var8 = null;

         try {
            var9 = new QueryBuilder("DELETE FROM instruction WHERE basicblockid IN ");

            while(true) {
               if(!var7.next()) {
                  var9.execute(this.connection);
                  break;
               }

               var9.appendInSet(var7.getString(1));
            }
         } catch (Throwable var84) {
            var8 = var84;
            throw var84;
         } finally {
            if(var7 != null) {
               if(var8 != null) {
                  try {
                     var7.close();
                  } catch (Throwable var79) {
                     var8.addSuppressed(var79);
                  }
               } else {
                  var7.close();
               }
            }

         }
      } catch (Throwable var86) {
         var6 = var86;
         throw var86;
      } finally {
         if(var5 != null) {
            if(var6 != null) {
               try {
                  var5.close();
               } catch (Throwable var76) {
                  var6.addSuppressed(var76);
               }
            } else {
               var5.close();
            }
         }

      }

      var5 = this.connection.prepareStatement("SELECT id FROM function WHERE address1 = ? AND address2 = ?");
      var6 = null;

      try {
         var5.setLong(1, var1);
         var5.setLong(2, var3);
         var7 = var5.executeQuery();
         var8 = null;

         try {
            var9 = new QueryBuilder("DELETE FROM basicblock WHERE functionid IN ");
            if(var7.next()) {
               var9.appendInSet(var7.getString(1));
            }

            var9.execute(this.connection);
         } catch (Throwable var80) {
            var8 = var80;
            throw var80;
         } finally {
            if(var7 != null) {
               if(var8 != null) {
                  try {
                     var7.close();
                  } catch (Throwable var78) {
                     var8.addSuppressed(var78);
                  }
               } else {
                  var7.close();
               }
            }

         }
      } catch (Throwable var82) {
         var6 = var82;
         throw var82;
      } finally {
         if(var5 != null) {
            if(var6 != null) {
               try {
                  var5.close();
               } catch (Throwable var77) {
                  var6.addSuppressed(var77);
               }
            } else {
               var5.close();
            }
         }

      }

   }

   private int getAlgorithmIdForManuallyMatchedBasicblocks() {
      PreparedStatement var1 = this.connection.prepareStatement("SELECT MAX(id) AS maxid FROM basicblockalgorithm");
      Throwable var2 = null;

      Throwable var5;
      try {
         ResultSet var3 = var1.executeQuery();
         Throwable var4 = null;

         try {
            var3.next();
            var5 = var3.getInt("maxid");
         } catch (Throwable var28) {
            var5 = var28;
            var4 = var28;
            throw var28;
         } finally {
            if(var3 != null) {
               if(var4 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var27) {
                     var4.addSuppressed(var27);
                  }
               } else {
                  var3.close();
               }
            }

         }
      } catch (Throwable var30) {
         var2 = var30;
         throw var30;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var26) {
                  var2.addSuppressed(var26);
               }
            } else {
               var1.close();
            }
         }

      }

      return (int)var5;
   }

   private int getFunctionMatchId(FunctionMatchData var1) {
      PreparedStatement var2 = this.connection.prepareStatement("SELECT id FROM function WHERE address1 = ? AND address2 = ?");
      Throwable var3 = null;

      int var5;
      try {
         var2.setLong(1, var1.getAddress(ESide.PRIMARY));
         var2.setLong(2, var1.getAddress(ESide.SECONDARY));
         ResultSet var4 = var2.executeQuery();
         var5 = var4.next()?var4.getInt(1):-1;
      } catch (Throwable var14) {
         var3 = var14;
         throw var14;
      } finally {
         if(var2 != null) {
            if(var3 != null) {
               try {
                  var2.close();
               } catch (Throwable var13) {
                  var3.addSuppressed(var13);
               }
            } else {
               var2.close();
            }
         }

      }

      return var5;
   }

   private int getNextBasicblockMatchId() {
      PreparedStatement var1 = this.connection.prepareStatement("select coalesce(max(id) + 1, 1) as maxid from basicblock");
      Throwable var2 = null;

      Throwable var5;
      try {
         ResultSet var3 = var1.executeQuery();
         Throwable var4 = null;

         try {
            var5 = var3.next()?var3.getInt(1):-1;
         } catch (Throwable var28) {
            var5 = var28;
            var4 = var28;
            throw var28;
         } finally {
            if(var3 != null) {
               if(var4 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var27) {
                     var4.addSuppressed(var27);
                  }
               } else {
                  var3.close();
               }
            }

         }
      } catch (Throwable var30) {
         var2 = var30;
         throw var30;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var26) {
                  var2.addSuppressed(var26);
               }
            } else {
               var1.close();
            }
         }

      }

      return (int)var5;
   }

   private void addBinExportMetaData(File var1, DiffMetaData var2) {
      if(var1 != null) {
         File var3 = DiffDirectories.getBinExportFile(var1, var2, ESide.PRIMARY);
         if(var3.exists() && var3.canRead()) {
            BinExportReader var4 = new BinExportReader(var3, ESide.PRIMARY);
            var2.setAddressSpace(var4.getAddressSpaceBits(), ESide.PRIMARY);
            var2.setArchitectureName(var4.getArchitectureName(), ESide.PRIMARY);
            var2.setMaxMnemonicLen(var4.getMaxMnemonicLen(), ESide.PRIMARY);
         }

         File var6 = DiffDirectories.getBinExportFile(var1, var2, ESide.SECONDARY);
         if(var6.exists() && var6.canRead()) {
            BinExportReader var5 = new BinExportReader(var3, ESide.SECONDARY);
            var2.setAddressSpace(var5.getAddressSpaceBits(), ESide.SECONDARY);
            var2.setArchitectureName(var5.getArchitectureName(), ESide.SECONDARY);
            var2.setMaxMnemonicLen(var5.getMaxMnemonicLen(), ESide.SECONDARY);
         }

      }
   }

   private void setFunctionMatchCounts(long var1, long var3, FunctionMatchData var5) {
      PreparedStatement var6 = this.connection.prepareStatement("UPDATE function SET basicblocks = ?, edges = ?, instructions = ?WHERE address1 = ? and address2 = ?");
      Throwable var7 = null;

      try {
         var6.setInt(1, var5.getSizeOfMatchedBasicblocks());
         var6.setInt(2, var5.getSizeOfMatchedJumps());
         var6.setInt(3, var5.getSizeOfMatchedInstructions());
         var6.setLong(4, var1);
         var6.setLong(5, var3);
         var6.executeUpdate();
      } catch (Throwable var16) {
         var7 = var16;
         throw var16;
      } finally {
         if(var6 != null) {
            if(var7 != null) {
               try {
                  var6.close();
               } catch (Throwable var15) {
                  var7.addSuppressed(var15);
               }
            } else {
               var6.close();
            }
         }

      }

   }

   public void changeExportFilename(String var1, ESide var2) {
      PreparedStatement var3 = this.connection.prepareStatement("update file set filename = ? where id = ?");
      Throwable var4 = null;

      try {
         var3.setString(1, var1);
         var3.setInt(2, var2 == ESide.PRIMARY?1:2);
         var3.executeUpdate();
      } catch (Throwable var13) {
         var4 = var13;
         throw var13;
      } finally {
         if(var3 != null) {
            if(var4 != null) {
               try {
                  var3.close();
               } catch (Throwable var12) {
                  var4.addSuppressed(var12);
               }
            } else {
               var3.close();
            }
         }

      }

   }

   public void changeFileTable(Diff var1) {
      if(!var1.isLoaded()) {
         throw new IllegalStateException("Function diff has to be loaded before saving.");
      } else if(!var1.isFunctionDiff()) {
         throw new IllegalArgumentException("Must be a function diff.");
      } else {
         this.alterFileTable();
         RawFunction var2 = (RawFunction)var1.getCallgraph(ESide.PRIMARY).getNodes().get(0);
         RawFunction var3 = (RawFunction)var1.getCallgraph(ESide.SECONDARY).getNodes().get(0);
         PreparedStatement var4 = this.connection.prepareStatement("UPDATE file SET functionname = ?, functiontype = ?, flowgraphoffset = ? WHERE id = ?");
         Throwable var5 = null;

         try {
            var4.setString(1, var2.getName());
            var4.setInt(2, EFunctionType.getOrdinal(var2.getFunctionType()));
            var4.setInt(3, ((FunctionDiffMetaData)var1.getMetaData()).getFlowgraphOffset(ESide.PRIMARY));
            var4.setInt(4, 1);
            var4.addBatch();
            var4.setString(1, var3.getName());
            var4.setInt(2, EFunctionType.getOrdinal(var3.getFunctionType()));
            var4.setInt(3, ((FunctionDiffMetaData)var1.getMetaData()).getFlowgraphOffset(ESide.SECONDARY));
            var4.setInt(4, 2);
            var4.addBatch();
            var4.executeBatch();
         } catch (Throwable var14) {
            var5 = var14;
            throw var14;
         } finally {
            if(var4 != null) {
               if(var5 != null) {
                  try {
                     var4.close();
                  } catch (Throwable var13) {
                     var5.addSuppressed(var13);
                  }
               } else {
                  var4.close();
               }
            }

         }

      }
   }

   public void deleteBasicblockMatch(FunctionMatchData var1, BasicBlockMatchData var2) {
      // $FF: Couldn't be decompiled
   }

   public String[] getIDBNames() {
      // $FF: Couldn't be decompiled
   }

   public void loadBasicblockMatches(FunctionMatchData var1) {
      // $FF: Couldn't be decompiled
   }

   public String loadDiffDescription() {
      PreparedStatement var1 = this.connection.prepareStatement("SELECT description FROM metadata");
      Throwable var2 = null;

      Object var5;
      try {
         ResultSet var3 = var1.executeQuery();
         Throwable var4 = null;

         try {
            var5 = var3.next()?var3.getString("description"):"";
         } catch (Throwable var28) {
            var5 = var28;
            var4 = var28;
            throw var28;
         } finally {
            if(var3 != null) {
               if(var4 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var27) {
                     var4.addSuppressed(var27);
                  }
               } else {
                  var3.close();
               }
            }

         }
      } catch (Throwable var30) {
         var2 = var30;
         throw var30;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var26) {
                  var2.addSuppressed(var26);
               }
            } else {
               var1.close();
            }
         }

      }

      return (String)var5;
   }

   public DiffMetaData loadDiffMetaData(File var1) {
      // $FF: Couldn't be decompiled
   }

   public IAddressPair loadFunctionDiffAddressPair() {
      PreparedStatement var1 = this.connection.prepareStatement("SELECT function.address1, function.address2 FROM function");
      Throwable var2 = null;

      try {
         ResultSet var3 = var1.executeQuery();
         if(var3.next()) {
            long var4 = var3.getLong(1);
            long var6 = var3.getLong(2);
            if(!var3.next()) {
               AddressPair var8 = new AddressPair(var4, var6);
               return var8;
            }
         }

         throw new SQLException("Illegal BinDiff database state: Function matches must be unique.");
      } catch (Throwable var17) {
         var2 = var17;
         throw var17;
      } finally {
         if(var1 != null) {
            if(var2 != null) {
               try {
                  var1.close();
               } catch (Throwable var16) {
                  var2.addSuppressed(var16);
               }
            } else {
               var1.close();
            }
         }

      }
   }

   public FunctionDiffMetaData loadFunctionDiffMetaData(boolean var1) {
      DiffMetaData var2 = this.loadDiffMetaData((File)null);
      if(!var1) {
         IAddressPair var3 = this.loadFunctionDiffAddressPair();
         IAddress var4 = var3.getIAddress(ESide.PRIMARY);
         IAddress var5 = var3.getIAddress(ESide.SECONDARY);
         PreparedStatement var6 = this.connection.prepareStatement("SELECT functionname, functiontype, flowgraphoffset FROM file ORDER BY id");
         Throwable var7 = null;

         try {
            String var8 = null;
            String var9 = null;
            EFunctionType var10 = null;
            EFunctionType var11 = null;
            Integer var12 = null;
            Integer var13 = null;
            ResultSet var14 = var6.executeQuery();
            if(var14.next()) {
               var8 = var14.getString("functionname");
               var10 = EFunctionType.getType(var14.getInt("functiontype"));
               var12 = Integer.valueOf(var14.getInt("flowgraphoffset"));
            }

            if(var14.next()) {
               var9 = var14.getString("functionname");
               var11 = EFunctionType.getType(var14.getInt("functiontype"));
               var13 = Integer.valueOf(var14.getInt("flowgraphoffset"));
            }

            if(var8 != null && var9 != null) {
               if(var10 != null && var11 != null) {
                  FunctionDiffMetaData var15 = new FunctionDiffMetaData(var2, var4, var5, var8, var9, var10, var11, var12, var13);
                  FunctionDiffMetaData var16 = var15;
                  return var16;
               } else {
                  throw new SQLException("Failed to load function diff meta data: Primary and secondary function type must not be null.");
               }
            } else {
               throw new SQLException("Failed to load function diff meta data: Primary and secondary function must not be null.");
            }
         } catch (Throwable var25) {
            var7 = var25;
            throw var25;
         } finally {
            if(var6 != null) {
               if(var7 != null) {
                  try {
                     var6.close();
                  } catch (Throwable var24) {
                     var7.addSuppressed(var24);
                  }
               } else {
                  var6.close();
               }
            }

         }
      } else {
         return new FunctionDiffMetaData(var2, (IAddress)null, (IAddress)null, (String)null, (String)null, (EFunctionType)null, (EFunctionType)null, (Integer)null, (Integer)null);
      }
   }

   public MatchData loadFunctionMatches(Diff var1) {
      // $FF: Couldn't be decompiled
   }

   public Map loadMatchedCallAddresses(Diff var1) {
      // $FF: Couldn't be decompiled
   }

   public void saveDiffDescription(String var1) {
      PreparedStatement var2 = this.connection.prepareStatement("UPDATE metadata SET description = ?");
      Throwable var3 = null;

      try {
         var2.setString(1, var1);
         var2.executeUpdate();
      } catch (Throwable var12) {
         var3 = var12;
         throw var12;
      } finally {
         if(var2 != null) {
            if(var3 != null) {
               try {
                  var2.close();
               } catch (Throwable var11) {
                  var3.addSuppressed(var11);
               }
            } else {
               var2.close();
            }
         }

      }

   }

   public void setFunctionDiffCounts(RawFunction var1, RawFunction var2) {
      PreparedStatement var3 = this.connection.prepareStatement("SELECT basicblocks, libbasicblocks, edges, libedges, instructions, libinstructions FROM file ORDER BY id ");
      Throwable var4 = null;

      try {
         ResultSet var5 = var3.executeQuery();
         Throwable var6 = null;

         try {
            if(var5.next()) {
               var1.setSizeOfBasicblocks(var5.getInt("basicblocks") + var5.getInt("libbasicblocks"));
               var1.setSizeOfJumps(var5.getInt("edges") + var5.getInt("libedges"));
               var1.setSizeOfInstructions(var5.getInt("instructions") + var5.getInt("libinstructions"));
            }

            if(!var5.next()) {
               throw new SQLException("Invalid matches database state. File table must consist of exactly two records.");
            }

            var2.setSizeOfBasicblocks(var5.getInt("basicblocks") + var5.getInt("libbasicblocks"));
            var2.setSizeOfJumps(var5.getInt("edges") + var5.getInt("libedges"));
            var2.setSizeOfInstructions(var5.getInt("instructions") + var5.getInt("libinstructions"));
         } catch (Throwable var29) {
            var6 = var29;
            throw var29;
         } finally {
            if(var5 != null) {
               if(var6 != null) {
                  try {
                     var5.close();
                  } catch (Throwable var28) {
                     var6.addSuppressed(var28);
                  }
               } else {
                  var5.close();
               }
            }

         }
      } catch (Throwable var31) {
         var4 = var31;
         throw var31;
      } finally {
         if(var3 != null) {
            if(var4 != null) {
               try {
                  var3.close();
               } catch (Throwable var27) {
                  var4.addSuppressed(var27);
               }
            } else {
               var3.close();
            }
         }

      }

   }

   public void updateFunctionMatch(long var1, long var3, FunctionMatchData var5) {
      boolean var6 = this.connection.getAutoCommit();
      this.connection.setAutoCommit(false);

      try {
         this.deleteBasiblockMatches(var1, var3);
         this.addBasicblockMatches(var5);
         this.setFunctionMatchCounts(var1, var3, var5);
         this.connection.commit();
      } catch (SQLException var8) {
         Logger.logException(var8, "Couldn\'t update function match. Executing rollback.");
         this.connection.rollback();
      }

      this.connection.setAutoCommit(var6);
   }
}
