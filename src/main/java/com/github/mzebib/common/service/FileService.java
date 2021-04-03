package com.github.mzebib.common.service;

import com.github.mzebib.common.util.NVPair;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author mzebib
 */
public interface FileService<F> extends Service {

    F createFile(F fileInfo, InputStream is)
            throws NullPointerException, IllegalArgumentException, ServiceException, IOException;

    F readFile(F fileInfo, OutputStream os)
            throws NullPointerException, IllegalArgumentException, ServiceException, IOException;

    F updateFile(F fileInfo, InputStream is)
            throws NullPointerException, IllegalArgumentException, ServiceException, IOException;

    void deleteFile(F fileInfo)
            throws NullPointerException, IllegalArgumentException, ServiceException, IOException;

    List<F> searchFiles(List<NVPair> criteria)
            throws NullPointerException, IllegalArgumentException, ServiceException, IOException;


}
