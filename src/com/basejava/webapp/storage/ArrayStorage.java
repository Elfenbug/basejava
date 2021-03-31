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
        for (int i = 0; i <= count; i++) {
            if (storage[i].equals(resume)) {
                storage[i] = resume;
                return;
            }
        }
        System.out.println("ERROR: Резюме " + resume.getUuid() + " не найдено!");
    }

    public void save(Resume resume) {
        if(count == storage.length) {
            System.out.println("ERROR: Хранилище переполнено!");
            return;
        }
        for(int i = 0; i < count; i++) {
            if(storage[i].getUuid().equals((resume.getUuid()))) {
                System.out.println("ERROR: Резюме с " + storage[i].getUuid() + " уже существует!");
                return;
            }
        }
        storage[count] = resume;
        count++;
    }

    public Resume get(String uuid) {
        if(getStorageIndex(uuid) == -1) {
            System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
            return null;
        }
        return storage[getStorageIndex(uuid)];
    }

    private int getStorageIndex(String uuid) {
        for(int i = 0; i < count; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String uuid) {
        int deletePosition = 0;
        if(getStorageIndex(uuid) == -1) {
            System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
        } else {
            deletePosition = getStorageIndex(uuid);
            storage[getStorageIndex(uuid)] = null;
            count--;
        }
        for(int i = deletePosition; i <= count; i++) {
            storage[i] = storage[i + 1];
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
