package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new LinkedHashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey((String) uuid);
    }

    @Override
    protected void saveResume(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected void deleteResume(Object uuid) {
        map.remove((String) uuid);
    }

    @Override
    protected void updateResume(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected Resume getResume(Object uuid) {
        return map.get((String) uuid);
    }

    @Override
    public List<Resume> getAllResume() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}