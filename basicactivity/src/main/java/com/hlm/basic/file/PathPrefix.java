package com.hlm.basic.file;

import com.hlm.basic.file.ExceptionFile.FilePathError;

class PathPrefix {

    private String mPathPrefix;

    private String pathDefinite(Index index) {

        try {
            switch (index) {
                case SD:
                    mPathPrefix = "sdcard/";
                    break;
                case COM_C:
                    mPathPrefix = "C://";
                    break;
                case COM_D:
                    mPathPrefix = "D://";
                    break;
                case COM_E:
                    mPathPrefix = "E://";
                    break;
                case COM_F:
                    mPathPrefix = "F://";
                    break;
                case COM_G:
                    mPathPrefix = "G://";
                    break;
                case COM_H:
                    mPathPrefix = "H://";
                    break;
                default:
                    throw new FilePathError(getClass().getName());
            }
        } catch (FilePathError e) {
            e.printStackTrace();
        }
        return mPathPrefix;

    }

    protected String setPrefix(Index index) {
        return pathDefinite(index);
    }

}
