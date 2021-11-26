package carFactory;s

public class Capacity {
	private int storageCapacity;
    private int[] workersCapacity;

    public Capacity(int storageCapacity, int[] workersCapacity) {
        this.storageCapacity = storageCapacity;
        this.workersCapacity = workersCapacity;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public int[] getWorkersCapacity() {
        return workersCapacity;
    }
}
