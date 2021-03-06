package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    protected abstract Integer getSearchKey(String uuid);

    protected abstract void insert(Resume resume, int searchKey);

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    @Override
    public void saveResume(Resume resume, Object searchKey) {
        if (count == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insert(resume, (int) searchKey);
            count++;
        }
    }

    @Override
    public void deleteResume(Object searchKey) {
        System.arraycopy(storage, (int) searchKey + 1, storage, (int) searchKey, count - (int) searchKey);
        count--;
    }

    @Override
    public void updateResume(Resume resume, Object searchKey) {
        storage[(int) searchKey] = resume;
    }

    @Override
    public Resume getResume(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    @Override
    protected List<Resume> getAllResume() {
        return Arrays.asList(Arrays.copyOf(storage, count));
    }

    public int size() {
        return count;
    }
}
