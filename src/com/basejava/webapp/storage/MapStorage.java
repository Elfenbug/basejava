package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Integer getStorageIndex(String uuid) {
        return null;
    }

    @Override
    protected boolean isExist(Object storageIndex) {
        return false;
    }

    @Override
    protected void saveResume(Resume resume, Object storageIndex) {

    }

    @Override
    protected void deleteResume(Object storageIndex) {

    }

    @Override
    protected void updateResume(Resume resume, Object storageIndex) {

    }

    @Override
    protected Resume getResume(Object storageIndex) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }
}
