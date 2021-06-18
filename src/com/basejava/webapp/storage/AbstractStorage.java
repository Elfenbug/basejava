package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {
    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void saveResume(Resume resume, SK searchKey);

    protected abstract void deleteResume(SK searchKey);

    protected abstract void updateResume(Resume resume, SK searchKey);

    protected abstract Resume getResume(SK searchKey);

    protected abstract List<Resume> getAllResume();

    public void save(Resume resume) {
        SK searchKey = getNotExistSearchKey(resume.getUuid());
        saveResume(resume, searchKey);
    }

    public void delete(String uuid) {
        SK searchKey = getExistSearchKey(uuid);
        deleteResume(searchKey);
    }

    public void update(Resume resume) {
        SK searchKey = getExistSearchKey(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public Resume get(String uuid) {
        SK searchKey = getExistSearchKey(uuid);
        return getResume(searchKey);
    }

    private SK getExistSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getAllResume();
        Collections.sort(list);
        return list;
    }
}