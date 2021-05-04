package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    @Override
    protected void insert(Resume resume, int searchKey) {
        int insertIndex = -searchKey - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, count - insertIndex);
        storage[insertIndex] = resume;
    }
}
