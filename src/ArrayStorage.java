import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int positionInArray = 0;

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                // good result: found an empty slot
                storage[i] = r;
                positionInArray = i + 1;
                return;
            }
            if (storage[i].uuid.equals(r.uuid)) {
                // bad result: found a duplicate
                System.out.println("ERROR: Resume with " + storage[i].uuid + " is already exist!");
                return;
            }
        }
        // bad result: storage full
        System.out.println("ERROR: Storage full");
    }

    Resume get(String uuid) {
        Resume resume = new Resume();
        for (int i = 0; i < positionInArray; i++) {
            if (storage[i].uuid.equals(uuid)) {
                resume = storage[i];
            }
        }
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < positionInArray; i++) {
            if(storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }
        }
        for (int i = 1; i < storage.length-1; i++) {
            storage[i-1] = storage[i];
            storage[i] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        int count = 0;
        for (int i = 0; i < storage.length; i++) {
            count++;
        }
        return count;
    }
}
