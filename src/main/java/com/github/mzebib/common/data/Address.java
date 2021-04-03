package com.github.mzebib.common.data;

import com.github.mzebib.common.util.GetDescription;

/**
 * @author mzebib
 */
public interface Address
        extends GetDescription {

    String getStreet();

    void setStreet(String street);


    String getCity();

    void setCity(String city);


    String getState();

    void setState(String state);


    String getCountry();

    void setCountry(String country);


    String getZipCode();

    void setZipCode(String zipCode);

}
