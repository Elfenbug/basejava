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
        storage[positionInArray] = r;
        positionInArray++;
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
        for(Resume r : storage) {
            System.out.print(r + " ");
        }
        return new Resume[0];
    }

    int size() {
        return storage.length;
    }
}
