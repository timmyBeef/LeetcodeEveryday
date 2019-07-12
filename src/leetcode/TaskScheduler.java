package leetcode;

// https://leetcode.com/problems/task-scheduler/




/*
因為 本題只想要知道最後的 intervals 總共多少, 所以其實本題是在算..."idles + number of tasks"

at least n = 2(slots) other tasks between two A
所以 A 和 A　之間塞　"2 個"  "JOB 或 idle"

A ? ? A ? ? A
所以可以得知 A 之間的間格數是: partCount = count(A) - 1;
每個間隔又要有 n 個 empty slots: emptySlots = partCount * n;

還剩多少工作 = 所有工作 - count(A)
availableTasks = tasks.length - count(A).

如果 emptySlots > availableTasks, 代表工作不夠去填滿, 所以需要 idle 去填滿
so..  idles = max(0, emptySlots - availableTasks)

但還有考慮到如果有多個頻率最高的一起出現 3 A 3 B 2 C 1 D, n = 3 (empty slots)

count of tasks with most frequency = 2

A ? ? ? A ? ? ? A
A B ? ? A B ? ? A B
所以其實可以視為
X ? ? X ? ? X
so n=3 => 2

so...
emptySlots = partCount * (n - (count of tasks with most frequency - 1))

availableTasks = tasks.length - count(A) * count of tasks with most frenquency

partCount(間個數) = count(A) - 1
emptySlots = partCount * (n - (count of tasks with most frequency - 1))
availableTasks = tasks.length - count(A) * count of tasks with most frenquency
idles = max(0, emptySlots - availableTasks)
result = tasks.length + idles

Now we have a way to arrange tasks. But the problem only asks for number of CPU intervals,
so we don't need actually arrange them. Instead we only need to get the total idles
we need and the answer to problem is just number of "idles + number of tasks".

Calculating this is not hard, we first get number of parts separated by
A: partCount = count(A) - 1;
then we can know number of empty slots: emptySlots = partCount * n;

we can also get how many tasks we have to put into those slots:
availableTasks = tasks.length - count(A).
Now if we have emptySlots > availableTasks which means we have not enough tasks
available to fill all empty slots, we must fill them with idles.
Thus we have idles = max(0, emptySlots - availableTasks);

*/

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int maxTask = 0;
        int sameMaxTaskCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (maxTask == counter[task - 'A']) {
                sameMaxTaskCount++;
            } else if (maxTask < counter[task - 'A']) {
                maxTask = counter[task - 'A'];
                sameMaxTaskCount = 1;
            }
        }


        int gaps = maxTask - 1;
        int emptySlots = gaps * (n - (sameMaxTaskCount -1));
        int availableTasks = tasks.length - maxTask*sameMaxTaskCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(new TaskScheduler().leastInterval(tasks, n));


    }
}
