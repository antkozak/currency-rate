package com.newsoft.rate.repository;

import com.newsoft.rate.model.DailyExchangeRates;
import com.newsoft.rate.repository.jdo.PMF;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import java.util.List;

/**
 * Abstract repository.
 */
public abstract class AbstractRepository<T, K extends java.io.Serializable> implements Repository<T, K> {
    PersistenceManager persistenceManager = PMF.get().getPersistenceManager();

    /**
     * @inheritDoc
     */
    @Override
    public List<T> findAll() {
        Query query = getPersistenceManager().newQuery(getEntryClass());
        query.setOrdering("when DESC");
        List<T> entries = (List<T>) query.execute();
        return entries;
        //test
    }

    /**
     * @inheritDoc
     */
    @Override
    public T save(T entry) {
        return getPersistenceManager().makePersistent(entry);
    }

    /**
     * @inheritDoc
     */
    @Override
    public T findById(K id) {
        return getPersistenceManager().getObjectById(getEntryClass(), id);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void remove(T entry) {
        getPersistenceManager().deletePersistent(entry);
    }

    /**
     * Returns class of the entry.
     *
     * @return class of the entry.
     */
    abstract Class<T> getEntryClass();

    /**
     * Returns persist manager.
     *
     * @return persist manager.
     */
    PersistenceManager getPersistenceManager() {
        return persistenceManager;
    }
}
