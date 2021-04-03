package com.github.mzebib.common.data.security;

import com.github.mzebib.common.util.SetNameDescription;

/**
 * @author mzebib
 */
public interface Permission
        extends SetNameDescription {

    String getPattern();

    void setPattern(String pattern);

}
