package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    protected abstract Integer getStorageIndex(String uuid);

    protected abstract void insert(Resume resume, int storageIndex);

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    public void saveResume(Resume resume, Object storageIndex) {
        if (count == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insert(resume, (int) storageIndex);
            count++;
        }
    }

    @Override
    public void deleteResume(Object storageIndex) {
        System.arraycopy(storage, (int) storageIndex + 1, storage, (int) storageIndex, count - (int) storageIndex);
        count--;
    }

    @Override
    public void updateResume(Resume resume, Object storageIndex) {
        storage[(int) storageIndex] = resume;
    }

    @Override
    public Resume getResume(Object storageIndex) {
        return storage[(int) storageIndex];
    }

    @Override
    protected boolean isExist(Object storageIndex) {
        return (Integer) storageIndex >= 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }
}