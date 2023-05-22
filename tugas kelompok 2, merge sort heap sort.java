public class App {
	public static void main(String args[]) {
		int arr[] = {20, 15, 30, 5, 10};

		System.out.print("Sebelum Diurutkan : ");
		printArray(arr);

		System.out.print("Sesudah Diurutkan : ");
        sort(arr);
		printArray(arr);
	}

	static void sort(int arr[]) {
		int n = arr.length;
        
		// Membangun heap (menyusun ulang array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapShort(arr, n, i);
        }

		// Satu per satu ekstrak elemen dari heap
		for (int i = n - 1; i >= 0; i--) {
			// Pindahkan root saat ini ke akhir
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// panggil max heapShort pada heap yang dikurangi
			heapShort(arr, i, 0);
		}
	}

	static void heapShort(int arr[], int n, int i) {
		int largest = i; // Inisialisasi terbesar sebagai root
		int l = i; // kiri = i
		int r = i + 1; // kanan = i + 1

		// Jika leftc child lebih besar dari root
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
        }

		// Jika right child lebih besar dari root
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
        }

		// Jika terbesar bukan root
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			heapShort(arr, n, largest);
		}

	}

	// Fungsi untuk mencetak array
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
        }
		System.out.println();
	}
}
