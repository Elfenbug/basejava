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

    protected abstract void insert(Resume resume, int index);

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    public void saveResume(Resume resume, Object index) {
        if (count == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insert(resume, (int) index);
            count++;
        }
    }

    @Override
    public void deleteResume(Object index) {
        System.arraycopy(storage, (int) index + 1, storage, (int) index, count - (int) index);
        count--;
    }

    @Override
    public void updateResume(Resume resume, Object index) {
        storage[(int) index] = resume;
    }

    @Override
    public Resume getResume(Object index) {
        return storage[(int) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
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