package com.newsoft.rate.model;

import javax.jdo.annotations.*;

/**
 * Domain class for currency rate. 
 *
 * <p/>
 * Date: Mar 4, 2010
 *
 * @author Anton Kozak
 */
@PersistenceCapable(identityType= IdentityType.APPLICATION)
public class CurrencyRateImpl implements CurrencyRate{

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String encodedKey;

    @Persistent
    @Extension(vendorName="datanucleus", key="gae.pk-id", value="true")
    private Long id;

    @Persistent
    private String code;

    @Persistent
    private String name;

    @Persistent
    private Double rate;

    /**
     * Returns id.
     *
     * @return id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns code.
     *
     * @return numCode.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code code.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Returns name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns rate.
     *
     * @return rate.
     */
    public Double getRate() {
        return rate;
    }

    /**
     * Sets rate.
     *
     * @param rate rate.
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    /**
     * Equals.
     *
     * @param o object.
     * @return comparison result.
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        CurrencyRateImpl that = (CurrencyRateImpl) o;

        if(id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if(code != null ? !code.equals(that.code) : that.code != null) {
            return false;
        }
        if(rate != null ? !rate.equals(that.rate) : that.rate != null) {
            return false;
        }

        return true;
    }

    /**
     * Calculates hash code.
     *
     * @return hash code.
     */
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }
}
