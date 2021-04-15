package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getStorageIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, count, searchKey);
    }

    @Override
    protected void insert(Resume resume, int index) {
        int insertIndex = - index - 1;
        System.arraycopy(storage, index, storage, insertIndex + 1, count - insertIndex);
        storage[-1 * insertIndex] = resume;
    }
}
