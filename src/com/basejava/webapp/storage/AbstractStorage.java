package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.List;

public abstract class AbstractStorage implements Storage {
    protected abstract Object getSearchKey(String uuid);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void saveResume(Resume resume, Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    public void save(Resume resume) {
        Object searchKey = getNotExistSearchKey(resume.getUuid());
        saveResume(resume, searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        deleteResume(searchKey);
    }

    public void update(Resume resume) {
        Object searchKey = getExistSearchKey(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        return getResume(searchKey);
    }

    private Object getExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

//    public List<Resume> getAllSorted() {
//        List<Resume> list =
//    }


}