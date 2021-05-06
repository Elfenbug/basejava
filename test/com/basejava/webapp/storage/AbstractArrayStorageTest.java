package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 0; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("FirstName" + i));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("Nan"));
    }
}