package com.github.mzebib.common.data;

import com.github.mzebib.common.util.SetDescription;

import java.util.Date;

/**
 * @author mzebib
 */
public interface CreditCard
        extends SetDescription {

    CreditCardType getCardType();

    void setCardType(CreditCardType type);


    String getCardholderName();

    void setCardholderName(String name);


    String getCardNumber();

    void setCardNumber(String number);


    Date getExpirationDate();

    void setExpirationDate(Date date);


    String getSecurityCode();

    void setSecurityCode(String code);

}
