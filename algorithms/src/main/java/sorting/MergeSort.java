package sorting;

public class MergeSort {
    private int[] solve(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        breakArray(start, end, arr);
        return arr;
    }

    private void breakArray(int s, int e, int[] arr) {
        if (s < e) {
            int mid = (s + e) / 2;
            System.out.println("Breaking part 1....");
            breakArray(s, mid, arr);
            System.out.println("Breaking part 2....");
            breakArray(mid + 1, e, arr);
            System.out.println("Merging part 3.....");
            merge(arr, s, mid, e);
        }
    }

    // function to merge the subarrays
    void merge(int a[], int p, int q, int r)
    {
        System.out.println("Merging....");
        int b[] = new int[a.length];   //same size of a[]
        int i, j, k;
        k = 0;
        i = p;
        j = q + 1;
        while(i <= q && j <= r)
        {
            if(a[i] < a[j])
            {
                b[k++] = a[i++];    // same as b[k]=a[i]; k++; i++;
            }
            else
            {
                b[k++] = a[j++];
            }
        }

        while(i <= q)
        {
            b[k++] = a[i++];
        }

        while(j <= r)
        {
            b[k++] = a[j++];
        }

        for(i=r; i >= p; i--)
        {
            a[i] = b[--k];  // copying back the sorted list to a[]
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-1, 8, 2, 0, 1};
        Helpers.printArray(new MergeSort().solve(arr));
    }
}
