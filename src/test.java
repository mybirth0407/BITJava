import java.util.ArrayList;
import java.util.Collections;

public class test {
    public static void main(String args[]) {
        int arr[] = {2, 5, 3, 4, 3, 9, 3, 2, 5, 4, 1, 3};
        int gap = (arr.length / 3) + 1;

        ArrayList<Integer> arrayList[] = new ArrayList[gap];
        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < arr.length; i++) {
            int j = i % gap;
            arrayList[j].add(arr[i]);
        }

        for (int i = 0; i < gap; i++) {
            Collections.sort(arrayList[i]);
        }


        for (int i = 0; i < gap; i++) {
            int gapTmp = 0;
            for (int j = 0; j < arrayList[i].size(); j++) {
                arr[i + gapTmp] = arrayList[i].get(j);
                gapTmp += gap;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}