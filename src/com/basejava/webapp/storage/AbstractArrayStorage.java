package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int count = 0;

    protected abstract int getStorageIndex(String uuid);

    protected abstract void insert(Resume resume, int index);

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void save(Resume resume) {
        int index = getStorageIndex(resume.getUuid());
        if (count >= STORAGE_LIMIT) {
            System.out.println("ERROR: Хранилище переполнено!");
        } else if (index < 0) {
            insert(resume, count);
            count++;
        } else {
            System.out.println("ERROR: Резюме с uuid " + resume.getUuid() + " уже существует!");
        }
    }

    public void delete(String uuid) {
        int index = getStorageIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
        }
        if (count - index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, count - index);
            count--;
        }
    }

    public void update(Resume resume) {
        int index = getStorageIndex(resume.getUuid());
        if (index <= 0) {
            storage[index] = resume;
        } else {
            System.out.println("ERROR: Резюме " + resume.getUuid() + " не найдено!");
        }

    }

    public Resume get(String uuid) {
        int index = getStorageIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
            return null;
        }
        return storage[index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, count);
    }

    public int size() {
        return count;
    }
}