package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume resume) {
        int index = getStorageIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
            return;
        }
        System.out.println("ERROR: Резюме " + resume.getUuid() + " не найдено!");
    }

    private int getStorageIndex(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume resume) {
        if (count == storage.length) {
            System.out.println("ERROR: Хранилище переполнено!");
            return;
        }
        int index = getStorageIndex(resume.getUuid());
        if (index != -1) {
            System.out.println("ERROR: Резюме с uuid " + resume.getUuid() + " уже существует!");
            return;
        }
        storage[count] = resume;
        count++;
    }

    public Resume get(String uuid) {
        int index = getStorageIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getStorageIndex(uuid);
        if (index == -1) {
            System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
        } else {
            count--;
        }
        if (count - index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, count - index);
        }
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