import java.io.*;
import java.util.*;
public class Main {
//     Hash Table + Linked List + Merge Sort
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int index;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        HashSet<String> hs = new HashSet<>();
        
        String[] arr = new String[500000];
        		
        for(int i=0; i<n; i++) hs.add(br.readLine());
        index = 0;
        for(int j=0; j<m; j++) {
        	String s=br.readLine();
            if(!hs.contains(s)) {
                continue;
            }else {
                arr[index++]=s;
            }
        }
        // 이제 arr배열에 들어있는 듣도보도 못한 사람을 사전순으로 정렬한다. 
        // 머지 소트 사용 
        mergeSort(arr,0,index-1);
        System.out.println(index);
        for(int i=0; i<index; i++) {
        	System.out.println(arr[i]);
        }
        
        br.close();
    }

    static void mergeSort(String[] arr, int left, int right) {
    	if(left>=right) return;
    	
    	int mid = (left+right)/2;
    	mergeSort(arr,left,mid);
    	mergeSort(arr,mid+1,right);
    	
    	//합치기
    	merge(arr,mid,left,right);
    }

	static void merge(String[] arr, int mid, int left, int right) {
//		System.out.println("merge => left : " + left+ ", mid : " + mid + ", right : " +right);
		int nl = left;
		int nr = mid+1;
		
		String[] temp = new String[right-left+1];
		
		for(int idx = 0; idx < right-left+1; idx++) {
			if(nl > mid) temp[idx] = arr[nr++];
			else if(nr > right) temp[idx] = arr[nl++];
			else temp[idx] = (arr[nr].compareTo(arr[nl]) < 0) ? arr[nr++] : arr[nl++];
		}
		
		for(int i = 0; i < right-left+1; i++) {
			arr[i+left] = temp[i];
		}

//		System.out.println("merge 결과 : " + Arrays.toString(temp));
//		System.out.println();
	}

}