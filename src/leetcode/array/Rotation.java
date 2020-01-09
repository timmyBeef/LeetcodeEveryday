package leetcode.array;

public class Rotation {

    public static void main(String[] args) {
        int[] a = {-4, -1, 0, 3, 10};

//        System.arraycopy(a, a.length - 4, a, 0, 4);
//        for (int s : a) {
//            System.out.print(s + " ");
//        }
        //new Rotation().sum(a, 4);

        //new Rotation().rightRotaion(a, 4);

        new Rotation().leftRotaion(a, 4);

    }

    public void sum(int a[], int k) {
        for (int i = 0; i < k; i++)
            new Rotation().rightRotaion(a, k);

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < k; i++) {
            sum1 += a[i];
            sum2 += a[a.length - 1 - i];

        }

        for (int s : a) {
            System.out.print(s + " ");
        }
        System.out.println("");

        System.out.println(sum1);
        System.out.println(sum2);
    }

    public void rightRotaion(int a[], int d) {

        leftRotaion(a, a.length - d);
    }

    public void leftRotaion(int a[], int d) {

        int size = a.length;
        int rs[] = new int[size];
        for (int i = 0; i < size; i++) {
            int newIndex = (i + d) % size;
            rs[i] = a[newIndex];
        }

        for (int s : rs) {
            System.out.print(s + " ");
        }
    }

    public void leftRotaionOneAry(int a[], int d) {
        // one array method
        int first = a[0];

        for (int i = 0; i < a.length - 1; i++) {
            a[i] = a[i + 1]; //這樣跑到最後, 最後一個不會更新到...所以要先暫存起來第一個的值
        }

        a[a.length - 1] = first;
    }

    public void rightRotaionOneAry(int a[], int d) {

        // one array method
        int last = a[a.length - 1]; //right shift
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = last;
    }

    public int[] rightRotationUseArraycopy(int nums[], int k) {
        int[] result = new int[nums.length];
        //src ary, src要copy的起始index, target ary, target要copy到的起始index, 要從src copy多長
        System.arraycopy(nums, k + 1, result, 0, k); //右移
        System.arraycopy(nums, 0, result, k + 1, nums.length - 1);
        return result;
    }
}
