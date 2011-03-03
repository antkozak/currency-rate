package com.newsoft.rate.repository;

import com.newsoft.rate.model.DailyExchangeRates;
import com.newsoft.rate.model.DailyExchangeRatesImpl;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

/**
 * Repository to perform CRUD operations under {@link DailyExchangeRates}.
 */
@Repository
public class DailyExchangeRatesRepositoryImpl extends AbstractRepository<DailyExchangeRatesImpl, Long>
        /* implements DailyExchangeRatesRepository */{

    /**
     * @inheritDoc
     */
    // @Override
    public List<DailyExchangeRates> findDailyExchangeRates(String currency, Date startDate, Date endDate) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * @inheritDoc
     */
    @Override
    Class<DailyExchangeRatesImpl> getEntryClass() {
        return DailyExchangeRatesImpl.class;
    }

}
