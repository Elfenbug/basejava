import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    //переделать
    void save(Resume r) {
        for(int i = 0; i <=storage.length - 1; i++) {
            storage[i] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length - 1; i++) {
            if(storage[i].uuid.equals(uuid)) {
                storage[i] = null;
            }
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
