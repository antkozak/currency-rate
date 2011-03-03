package com.newsoft.rate.repository;

import java.util.List;

/**
 * Base repository interface.
 */
public interface Repository<T, K extends java.io.Serializable>{
    /**
     * Returns all entries.
     *
     * @return list of enries.
     */
    List<T> findAll();

    /**
     * Adds or updates entry.
     *
     * @param entry entry.
     * @return udpated entry.
     */
    T save(T entry);

    /**
     * Returns entry by id.
     *
     * @param id id.
     * @return  entry
     */
    T findById(K id);

    /**
     * Removes entry.
     *
     * @param entry entry to remove.
     */
    void remove(T entry);

}
