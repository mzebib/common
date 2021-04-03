package com.github.mzebib.common.data.accounting;

import java.math.BigDecimal;

/**
 * @author mzebib
 */
public interface CurrencyValue {

    Currency getCurrency();

    void setCurrency(Currency currency);


    BigDecimal getValue();

    void setValue(BigDecimal value);

}
