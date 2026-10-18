package com.yftech.service.upgrade.g;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static Map<String, File> a(String[] strArr, String[] strArr2) throws Throwable {
        if (strArr == null || strArr.length == 0) {
            b.e("findUpgradeFile, pathList is empty");
            return new HashMap(0);
        }
        if (strArr2 == null || strArr2.length == 0) {
            b.e("findUpgradeFile, upgradeFileNames is empty");
            return new HashMap(0);
        }
        HashMap map = new HashMap();
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists()) {
                b.e("findUpgradeFile, path(" + str + ") not exists");
            } else if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    b.e("findUpgradeFile, directory(" + str + ") is empty");
                } else {
                    for (File file2 : fileArrListFiles) {
                        if (file2.isFile()) {
                            for (String str2 : strArr2) {
                                if (str2.equals(file2.getName())) {
                                    map.put(str2, file2);
                                    break;
                                }
                            }
                        }
                    }
                }
            } else {
                b.e("findUpgradeFile, path(" + str + ") is not directory");
            }
        }
        return map;
    }
}
