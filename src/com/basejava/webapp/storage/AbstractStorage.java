package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected abstract Object getStorageIndex(String uuid);

    protected abstract boolean isExist(Object storageIndex);

    protected abstract void saveResume(Resume resume, Object storageIndex);

    protected abstract void deleteResume(Object storageIndex);

    protected abstract void updateResume(Resume resume, Object storageIndex);

    protected abstract Resume getResume(Object storageIndex);

    public void save(Resume resume) {
        Object storageIndex = getNotExistIndex(resume.getUuid());
        saveResume(resume, storageIndex);
    }

    public void delete(String uuid) {
        Object storageIndex = getExistIndex(uuid);
        deleteResume(storageIndex);
    }

    public void update(Resume resume) {
        Object storageIndex = getExistIndex(resume.getUuid());
        updateResume(resume, storageIndex);
    }

    public Resume get(String uuid) {
        Object storageIndex = getExistIndex(uuid);
        return getResume(storageIndex);
    }

    private Object getExistIndex(String uuid) {
        Object storageIndex = getStorageIndex(uuid);
        if (!isExist(storageIndex)) {
            throw new NotExistStorageException(uuid);
        }
        return storageIndex;
    }

    private Object getNotExistIndex(String uuid) {
        Object storageIndex = getStorageIndex(uuid);
        if (isExist(storageIndex)) {
            throw new ExistStorageException(uuid);
        }
        return storageIndex;
    }


}
