package com.github.mzebib.common.data;

import com.github.mzebib.common.util.SetDescription;

/**
 * @author mzebib
 */
public interface Phone
        extends SetDescription {

    PhoneType getType();

    void setType(PhoneType type);


    String getCountryCode();

    void setCountryCode();


    String getNumber();

    void setNumber(String number);

}
