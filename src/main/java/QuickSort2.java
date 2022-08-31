public class QuickSort2 {

    static int[] arr = {6, 8, 5, 2, 1, 9, 17, 42, 3, 7};
    static int num = 1;

    public static void main(String[] args) {
//        quickSort(arr, 0, 9);

//        char letter  = 'a';
//        int num = letter;
//        System.out.println(num);

        int summe = 0;
        int i = 1;
        while (i<1){
            summe += i;
            i++;
        }
        System.out.println(summe);
    }

    public static void quickSort(int[] arr, int low, int high) {
        int temp = arr[high];
        int i = low, j = low;
        int ex;

        while (j < high) {
            //找到大于temp的数
            while (arr[i] <= temp) {
                i++;
                /*
                 * 实在找不到，说明low到high之间没有比arr[high]更大的数了
                 * 也就是说此时temp左边的数都小于等于temp
                 * 此时，本次排序结束，退出循环
                 */
                if (i >= high) {
                    break;
                }
            }
            //找到小于或等于temp的数
            while (arr[j] > temp || j < i) {
                j++;
                /*
                 * 为了防止i=high时，根据j<i就可以继续循环这一条件，j可能大于high，导致溢出
                 * 所以必须加上下面的条件
                 */
                if (j >= high) {
                    break;
                }

            }
            //执行数值交换
            ex = arr[i];
            arr[i] = arr[j];
            arr[j] = ex;
        }

        System.out.println("第" + num++ + "次排序，i在" + arr[i] + "的位置，可见" + arr[i] + "左边的数(有数的情况下)全部小于" + arr[i] + "，而其右边的数(有数的情况下)全部大于" + arr[i]);
        //遍历输出
        each(arr);
        //根据条件执行递归调用
        if (i - 1 > low) {
            quickSort(arr, low, i - 1);
        }
        if (i + 1 < high) {
            quickSort(arr, i + 1, high);
        }

    }

    public static void each(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "    ");
        }
        System.out.println();
    }
}