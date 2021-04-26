package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getStorageIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object index) {
        return index != null;
    }

    @Override
    protected void saveResume(Resume resume, Object getStorageIndex) {
        list.add(resume);
    }

    @Override
    protected void deleteResume(Object getStorageIndex) {
        list.remove(getStorageIndex);
    }

    @Override
    protected void updateResume(Resume resume, Object getStorageIndex) {
        list.set((Integer) getStorageIndex, resume);
    }

    @Override
    protected Resume getResume(Object getStorageIndex) {
        return list.get((Integer) getStorageIndex);
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
