package com.newsoft.rate.model;

import java.io.Serializable;

/**
 * Currency rate.
 * <p/>
 * Date: Feb 20, 2011
 *
 * @author Anton Kozak
 */
public interface CurrencyRate extends Serializable {
    /**
     * Returns id.
     *
     * @return id.
     */
    Long getId();

    /**
     * Sets id.
     *
     * @param id id.
     */
    void setId(Long id);

    /**
     * Returns code.
     *
     * @return numCode.
     */
    String getCode();

    /**
     * Sets code.
     *
     * @param code code.
     */
    void setCode(String code);

    /**
     * Returns name.
     *
     * @return name.
     */
    String getName();

    /**
     * Sets name.
     *
     * @param name name.
     */
    void setName(String name);

    /**
     * Returns rate.
     *
     * @return rate.
     */
    Double getRate();

    /**
     * Sets rate.
     *
     * @param rate rate.
     */
    void setRate(Double rate);
}
