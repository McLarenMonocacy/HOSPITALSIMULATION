public interface CacyQueue<T> {
    void offer(T t); // Add the object to the queue
    T poll(); // Remove the next object from the queue
    T peek(); // Get the next object from the queue without removing it
}
