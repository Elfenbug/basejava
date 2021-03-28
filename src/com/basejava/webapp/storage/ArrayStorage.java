package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    public void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    public void update(Resume r) {
        boolean isFind = false;
        for(int i = 0; i < count; i++) {
            if(storage[i].equals(r)) {
                storage[i] = r;
                isFind = true;
            }
        }
        if(!isFind) {
            System.out.println("ERROR: Резюме не найдено!");
        }
    }

    public void save(Resume r) {
        if(count == storage.length) {
            System.out.println("ERROR: Хранилище переполнено!");
            return;
        }

        for(int i = 0; i < count; i++) {
            if(storage[i].toString().equals((r.toString()))) {
                System.out.println("ERROR: Резюме с " + storage[i].getUuid() + " уже существует!");
                return;
            }
        }
        storage[count] = r;
        count++;
    }

    public Resume get(String uuid) {
        for(int i = 0; i < count; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("ERROR: Резюме не найдено!");
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
            System.out.println("ERROR: Резюме не найдено!");
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
