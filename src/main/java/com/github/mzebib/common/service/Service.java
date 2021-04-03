package com.github.mzebib.common.service;

import com.github.mzebib.common.util.ConfigInfo;

/**
 * @author mzebib
 */
public interface Service {

    ConfigInfo getConfigInfo();

    void setConfigInfo(ConfigInfo configInfo);

    void init()
            throws NullPointerException, IllegalArgumentException, ServiceException;

    void shutdown()
            throws NullPointerException, IllegalArgumentException, ServiceException;

}
