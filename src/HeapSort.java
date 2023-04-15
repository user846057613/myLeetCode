import org.junit.Test;

import java.util.Arrays;

public class HeapSort {

    public void swap(int[] A, int i, int j) {
        int tmp = A[j];
        A[j] = A[i];
        A[i] = tmp;
    }

    public void heapify(int A[], int i, int size) {
        int leftChild = 2*i+1;
        int rightChild = 2*i + 2;
        int max = i;
        if(leftChild < size && A[leftChild] > A[max]) {
            max = leftChild;
        }
        if(rightChild < size && A[rightChild] > A[max]) {
            max = rightChild;
        }
        if(max != i) {
            swap(A, i, max);
            heapify(A, max, size);
        }
    }

    public int buildHeap(int[] A, int n) {
        int heap_size = n;
        for (int i = heap_size/2 - 1; i >= 0; i--) {
            heapify(A, i, heap_size);
        }
        return heap_size;
    }

    public void heapSort(int[] A, int n) {
        int heap_size = buildHeap(A, n);
        while (heap_size > 1) {
            swap(A, 0, --heap_size);
            heapify(A, 0, heap_size);
        }
    }


    @Test
    public void mySort() {
        int[] A = {5,2,9,4,7,6,1,3,8};
        int n = A.length;
        heapSort(A,n);
        System.out.println(Arrays.toString(A));
    }
}
