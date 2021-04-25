package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    protected abstract int getStorageIndex(String uuid);

    protected abstract void insert(Resume resume, int index);

    protected abstract boolean isExist(Object index);

    protected abstract void saveResume(Resume resume, Object getStorageIndex);

    protected abstract void deleteResume(Object getStorageIndex);

    protected abstract void updateResume(Resume resume, Object getStorageIndex);

    protected abstract Resume getResume(Object getStorageIndex);

    public void save(Resume resume) {
        Object getStorageIndex = getNotExistIndex(resume.getUuid());
        saveResume(resume, getStorageIndex);
    }

    public void delete(String uuid) {
        Object getStorageIndex = getExistIndex(uuid);
        deleteResume(getStorageIndex);
    }

    public void update(Resume resume) {
        Object getStorageIndex = getExistIndex(resume.getUuid());
        updateResume(resume, getStorageIndex);
    }

    public Resume get(String uuid) {
        Object getStorageIndex = getExistIndex(uuid);
        return getResume(getStorageIndex);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    private Object getExistIndex(String uuid) {
        Object index = getStorageIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private Object getNotExistIndex(String uuid) {
        Object index = getStorageIndex(uuid);
        if (isExist(index)) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }


}
