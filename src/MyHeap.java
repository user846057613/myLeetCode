import org.junit.Test;

public class MyHeap {
    int[] value;
    int[] heap;
    int size;
    public MyHeap(int[] value) {
        heap = new int[value.length];
        size = 0;
        this.value = value;
        buildHeap();
    }

    public MyHeap() {}

    public void shiftDown(int index) {
        int leftChild = index*2 + 1;
        int rightChild = index*2 + 2;
        int nextIndex = leftChild;
        if(leftChild >= size) return;
        if(rightChild < size) {
            if(heap[index] >= heap[leftChild] && heap[index] >= heap[rightChild]) return;
            else if(heap[rightChild] > heap[leftChild]) nextIndex = rightChild;
        }
        swap(index,nextIndex);
        shiftDown(nextIndex);
    }

    private void swap(int index, int nextIndex) {
        int temp = heap[index];
        heap[index] = heap[nextIndex];
        heap[nextIndex] = temp;
    }

    public void shiftUp(int index) {
        int parent = (index - 1) / 2;
        if(parent < 0) return;
        if(heap[parent] >= heap[index]) return;
        swap(index,parent);
        shiftUp(parent);
    }

    public void buildHeap() {
        for (int i = 0; i < value.length; i++) {
            insert(value[i]);
        }
    }

    public void insert(int num) {
        if(size < heap.length) {
            heap[size++] = num;
            int parent = (size-1-1) / 2;
            if(parent < 0 || heap[parent] >= num) return;
            shiftUp(size-1);
        }
    }

    public void removeFirst() {
        if(size > 0) {
            swap(0,size-1);
            size--;
            shiftDown(0);
        }
    }

    public int peekFirst(){
        if(size > 0) return heap[0];
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9,10};
        MyHeap heap = new MyHeap(num);
        System.out.println(heap.peekFirst());
    }
}
