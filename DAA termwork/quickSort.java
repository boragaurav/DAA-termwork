import java.util.Scanner;
public class quickSort {
	public static int[] insertArray() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = s.nextInt();
		System.out.println("Enter element in array: ");
		int arr[] = new int[n];
		for(int i = 0; i< n;i++) {
			arr[i] = s.nextInt();
		}
		
		return arr;
	}
	
	public static void quickSort(int arr[],int stI, int edI) {
		if(stI >= edI) {
			return;
		}
		
		int pos = position(arr,stI,edI);
		quickSort(arr,stI,pos-1);
		quickSort(arr,pos+1,edI);
	}
	
	public static int position(int []arr, int stI, int edI) {
		int cnt= 0;
		int pivEle = arr[stI];
		for(int k = stI+1; k<= edI; k++) {
			if(pivEle >=  arr[k]) {
				cnt++;
			}
		}
		int pI=cnt+ stI;
		arr[stI] = arr[pI];
		
		arr[pI] = pivEle;
		int i =stI, j =edI;
		while(i < j) {
			while(i <= edI && arr[i] <= pivEle) {
				i++;
			}
			while(arr[j] > pivEle) {
				j--;
			}
			if(i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			
		}
		
		return pI;
	}
				 


	public static void main(String[] args) {
		
		int arr[] = insertArray();
		quickSort(arr,0,arr.length-1);
		for(int i =0; i< arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}



}
