import java.util.Arrays;
public class SubArray{
    public static int[] find(int[] array){
        int maxIndex = 0;
        int maxLength = 0;
        int currentLength = 1;
        int start = 0;
        for (int i = 0; i < array.length - 1; i++) {
            start = i;
            currentLength = 1;
            for (int j = i; j < array.length - 1; j++) {

                if (array[j] < array[j + 1]) {
                    currentLength++;
                    if (currentLength > maxLength) {
                        maxIndex = start;
                        maxLength = currentLength;
                        //i++;
                    }
                }
                else
                    break;
            }
        }

        int[] subArray = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            subArray[i] = array[maxIndex+i];
        }
        return subArray;
    }

    public static void main(String[] args) {
        int[] a1 = {0, 1, 2, 3, -1, 1, 4, 5, 6, 7, 10, 11, 6, 4, 75};
        int[] a2 ={5, 3, 1, 2, 3, 4, 5, 6, 9, 2, 1, 2, 1, 2};
        int[] a3 = {-1, 2, 5, 1, 2, 1, 2};
        int[] s1 = find(a1);
        int[] s2 = find(a2);
        int[] s3 = find(a3);

        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
        System.out.println(Arrays.toString(s3));

    }
}
