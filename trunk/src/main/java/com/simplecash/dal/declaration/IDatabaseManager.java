package com.simplecash.dal.declaration;

/**
 *
 */
public interface IDatabaseManager {
    public void createDatabaseSchema();
    public void updateDatabaseSchema();
    public void populateWithTestData();
}
