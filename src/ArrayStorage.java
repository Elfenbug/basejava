import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int count = 0;

    void clear() {
        Arrays.fill(storage, 0, count, null);
        count = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < count; i++) {
            if (storage[i].toString().equals((r.toString()))) {
                System.out.println("Резюме с " + storage[i].uuid + " уже существует!");
                return;
            }
        }
        storage[count] = r;
        count++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < count; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int deletePosition = 0;
        for (int i = 0; i < count + 1; i++) {
            if(storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                deletePosition = i;
                count--;
            }
        }
        for (int i = deletePosition + 1; i <= count; i++) {
            storage[i - 1] = storage[i];
            storage[i] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, count);
    }

    int size() {
        return count;
    }
}
