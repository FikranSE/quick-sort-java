
    
    class Main{
        
    // Fungsi utilitas untuk menukar dua elemen
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /*Fungsi ini mengambil elemen terakhir sebagai pivot, menempatkan
    elemen pivot pada posisi yang benar dalam urutan
    array, dan menempatkan semua angka yang lebih kecil (lebih kecil dari pivot)
    ke kiri pivot dan semua elemen yang lebih besar ke kanan
    dari pivot */
    static int partition(int[] arr, int low, int high)
    {
        // pivot
        int pivot = arr[high];
        
        // Indeks elemen yang lebih kecil dan
        // menunjukkan posisi yang tepat
        // dari pivot yang ditemukan sejauh ini
        int i = (low - 1);
        
        for(int j = low; j <= high - 1; j++)
        {
            // Jika elemen saat ini lebih kecil
            // dari pada pivot
            if (arr[j] < pivot)
            {
                //saat arr[j] < pivot i yg di increment akan mmpengaruhi
                //parameter function swap sehingga terjadi pertukaran
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    /* Fungsi utama yang mengimplementasikan QuickSort
            arr[] --> Array yang akan sorting,
            low -> Indeks awal,
            high -> Indeks akhir
    */
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            // pi adalah indeks partisi, arr[p]
            // sekarang di tempat yang tepat
            int pi = partition(arr, low, high);
    
            // Urutkan elemen secara terpisah sebelum
            // partisi dan setelah partisi
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    // Fungsi untuk mencetak array
    static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");//
            
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        
        quickSort(arr, 0, n - 1);
        System.out.println("array yang di sorting : ");
        printArray(arr, n);
    }
}