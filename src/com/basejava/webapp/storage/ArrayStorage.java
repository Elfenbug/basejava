package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10_000];
    int count = 0;

    public boolean printError(Resume resume) {
        boolean isFindDublicate = false;
        for(int i = 0; i < count; i++) {
            if (storage[i].equals(resume)) {
                return true;
            }
        }
        System.out.println("ERROR: Резюме " + resume.toString() + " не найдено!");
        return false;
    }

    public boolean printError(String uuid) {
        boolean isFindDublicate = false;
        for(int i = 0; i < count; i++) {
            if (storage[i].equals(uuid)) {
                return true;
            }
        }
        System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
        return false;
    }

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume resume) {
        if (printError(resume)) {
            for (int i = 0; i < count; i++) {
                if (storage[i].equals(resume)) {
                    storage[i] = resume;
                }
            }
        }
    }

    public void save(Resume resume) {
        if(count == storage.length) {
            System.out.println("ERROR: Хранилище переполнено!");
            return;
        }

        for(int i = 0; i < count; i++) {
            if(storage[i].toString().equals((resume.toString()))) {
                System.out.println("ERROR: Резюме с " + storage[i].getUuid() + " уже существует!");
                return;
            }
        }
        storage[count] = resume;
        count++;
    }

    public Resume get(String uuid) {
        for(int i = 0; i < count; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
        return null;
    }

    public void delete(String uuid) {
        boolean isFind = false;
        int deletePosition = 0;
        for(int i = 0; i < count; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                storage[i] = null;
                deletePosition = i;
                count--;
                isFind = true;
            }
        }
        if(!isFind) {
            System.out.println("ERROR: Резюме c uuid " + uuid + " не найдено!");
            return;
        }

        for(int i = deletePosition; i <= count; i++) {
            storage[i] = storage[i + 1];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, count);
    }

    public int size() {
        return count;
    }
}
