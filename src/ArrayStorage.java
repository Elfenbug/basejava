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
                storage[i] = r;
                positionInArray = i + 1;
                return;
            }
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("Резюме с " + storage[i].uuid + " уже существует!");
                return;
            }
        }
        System.out.println("Массив заполнен");
    }

    Resume get(String uuid) {
        for (int i = 0; i < positionInArray; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        Resume resume = new Resume();
        resume.uuid = "Резюме отсутствует";
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < positionInArray; i++) {
            if(storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                positionInArray--;
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
        int i = 0;
        int j = storage.length - 1;
        while (i <= j) {
            if (storage[j] == null) {
                j--;
            } else if (storage[i] != null) {
                i++;
            } else {
                storage[i] = storage[j];
                storage[j] = null;
                i++; j--;
            }
        }
        return Arrays.copyOfRange(storage, 0, i);
    }

    int size() {
        int count = 0;
        while (storage[count] != null) {
            count++;
        }
        return count;
    }
}
