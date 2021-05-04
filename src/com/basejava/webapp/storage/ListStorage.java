package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object storageIndex) {
        return storageIndex != null;
    }

    @Override
    protected void saveResume(Resume resume, Object storageIndex) {
        list.add(resume);
    }

    @Override
    protected void deleteResume(Object storageIndex) {
        list.remove(((Integer) storageIndex).intValue());
    }

    @Override
    protected void updateResume(Resume resume, Object storageIndex) {
        list.set((Integer) storageIndex, resume);
    }

    @Override
    protected Resume getResume(Object storageIndex) {
        return list.get((Integer) storageIndex);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
