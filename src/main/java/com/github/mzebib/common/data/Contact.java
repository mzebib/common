package com.github.mzebib.common.data;

import com.github.mzebib.common.util.NVPair;
import com.github.mzebib.common.util.SetNameDescription;

import java.util.List;

/**
 * @author mzebib
 */
public interface Contact<P extends Phone,A extends Address>
        extends SetNameDescription {

    String getEmail();

    void setEmail(String email);


    P getPhoneNumber();

    void setPhoneNumber(P phoneNumber);


    A getAddress();

    void setAddress(A address);


    String getCompany();

    void setCompany(String company);


    String getDepartment();

    void setDepartment(String department);


    String getPosition();

    void setPosition(String position);


    String getWebsite();

    void setWebsite(String website);


    List<NVPair> getAdditionalInfo();

    void setAdditionalInfo(List<NVPair> additionalInfo);

}