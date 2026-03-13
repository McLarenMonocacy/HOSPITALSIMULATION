public class CacyLinkedList<T> implements CacyQueue<T> {
    private class Record{
        T t;
        Record nextRecord;

        Record(T t){
            this.t = t;
        }
    }

    private Record head;
    private Record iterator;

    public void add (T t){
        if (t == null) return;
        if (head == null) {
            head = new Record(t);
            return;
        }
        add(head,t);
    }
    private void add(Record record, T t) {
        if (record.nextRecord != null) add(record.nextRecord, t);
        else record.nextRecord = new Record(t);
    }

    public void addFirst(T t){
        //Adds the object at the beginning of the list
        Record record = new Record(t);
        record.nextRecord = head;
        head = record;
    }

    public void remove(T t) {
        //Removes the first object in the list that is equal, does nothing if no objects match
        head = remove(head, t);
    }
    private Record remove(Record record, T t){
        //Removes the record with a matching object by returning the next record in the list
        if (record == null) return null; //We are null, return self
        if (record.t.equals(t)) return record.nextRecord; //We are equal, return next record
        record.nextRecord = remove(record.nextRecord, t);//We aren't equal, check next record
        return record; //This record wasn't equal, return self
    }

    public T removeFirst(){
        //Removes the first object in the list and returns it
        if (head == null) return null;
        T output = head.t;
        head = head.nextRecord;
        return output;
    }

    public void removeLast(){
        //Removes the last object in the list and returns it
        if (head == null) return;
        head = removeLast(head);
    }
    private Record removeLast(Record record){
        if (record.nextRecord == null) return null; //We are last, return null to remove ourself as the next record
        record.nextRecord = removeLast(record.nextRecord); //We are not last, check the next record
        return record; //Return our self to stay as the next record
    }

    public T first(){
        //Returns the first object in the list
        if (head == null) return null;
        return head.t;
    }

    public T last(){
        //Returns the last object in the list
        if (head == null) return null;
        return last(head);
    }
    private T last(Record rootRecord){
        if (rootRecord.nextRecord == null) return rootRecord.t; //We are last record, return stored object
        return last(rootRecord.nextRecord); //We aren't last record, return the next record's result
    }

    public T index(int index){
        //Returns the object in the nth spot in the list, returns null if out of bounds
        if (index < 0) return null; //Negative index is out of bounds
        return index(head, index);
    }
    private T index(Record record, int index){
        if (record == null) return null; //We are null, return null
        if (index == 0) return record.t; //We are the index, return stored value
        return index(record.nextRecord, index-1); //We aren't the index, return the next record's result
    }

    public boolean contains(T t){
        //returns true if the object is in the list
        return contains(head, t);
    }
    private boolean contains(Record record, T t){
        if (record == null) return false; //We are null and thus don't contain
        if (record.t.equals(t)) return true; //We are equal and thus contain
        return contains(record.nextRecord, t); //We aren't equal, check next record
    }

    public int length(){
        //Returns the length of the list
        return length(head);
    }
    private int length(Record record){
        if (record == null) return 0; //We aren't a record and thus are zero
        return length(record.nextRecord) + 1;//We are a record, add ourselves to the count
    }

    public void initIterator(){
        //Sets the iterator to the start of the list
        iterator = head;
    }

    public T next(){
        //Returns the next item in the list, null if at the end
        if (iterator == null) return null;
        T output = iterator.t;
        iterator = iterator.nextRecord;
        return output;
    }

    public boolean hasNext(){
        //returns true if the iterator has more elements (i.e. next() != null)
        return iterator != null;
    }

    @Override
    public void offer(T t) {
        add(t);
    }

    @Override
    public T poll() {
        return removeFirst();
    }

    @Override
    public T peek() {
        return first();
    }
}
