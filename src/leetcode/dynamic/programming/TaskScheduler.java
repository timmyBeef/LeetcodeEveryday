package leetcode.dynamic.programming;

// https://leetcode.com/problems/task-scheduler/

/*
因為 本題只想要知道最後的 intervals 總共多少, 所以其實本題是在算...'idles + number of tasks'

at least n = 2(slots) other tasks between two A
所以 A 和 A　之間塞　'2 個'  'JOB 或 idle'

A ? ? A ? ? A
所以可以得知 A 之間的間格數是: partCount = count(A) - 1;
每個間隔又要有 n 個 empty slots: emptySlots = partCount * n;

還剩多少工作 = 所有工作 - count(A)
availableTasks = tasks.length - count(A).

如果 emptySlots > availableTasks, 代表工作不夠去填滿, 所以需要 idle 去填滿
so..  idles = max(0, emptySlots - availableTasks)

但還有考慮到如果有多個頻率最高的一起出現 3 A 3 B 2 C 1 D, n = 3 (empty slots)

count of tasks with most frequency = 2

A ? ? ? A ? ? ? A   (n = 3 (? is empty slots))
A B ? ? A B ? ? A B  => ? 變2
所以其實可以視為
X ? ? X ? ? X
so n=3 => 變2

so...
emptySlots = partCount * (n - (count of tasks with most frequency - 1))

availableTasks = tasks.length - count(A) * count of tasks with most frenquency

partCount(間格數) = count(A) - 1
emptySlots = partCount * (n - (count of tasks with most frequency - 1))
availableTasks = tasks.length - count(A) * count of tasks with most frenquency
idles = max(0, emptySlots - availableTasks)
result = tasks.length + idles

Now we have a way to arrange tasks. But the problem only asks for number of CPU intervals,
so we don't need actually arrange them. Instead we only need to get the total idles
we need and the answer to problem is just number of 'idles + number of tasks'.

Calculating this is not hard, we first get number of parts separated by
A: partCount = count(A) - 1;
then we can know number of empty slots: emptySlots = partCount * n;

we can also get how many tasks we have to put into those slots:
availableTasks = tasks.length - count(A).
Now if we have emptySlots > availableTasks which means we have not enough tasks
available to fill all empty slots, we must fill them with idles.
Thus we have idles = max(0, emptySlots - availableTasks);

emptySlots < 0 means you have already got enough tasks to fill in each part to make arranged tasks
valid. But as I said you can always put more tasks in each part once you met the "minimum" requirement.


O(n) and space O(1)
*/

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int maxTask = 0;
        int sameMaxTaskCount = 0;

        for (char task : tasks) {
            counter[task - 'A']++;
            if (maxTask == counter[task - 'A']) {
                sameMaxTaskCount++;

            // accumulate and update max, otherwise others have max, or maxTask will not update
            // {'A', 'A', 'A', 'B', 'B'}, maxTask is still lower than counter['A'-'A']
            //  so the result is maxTask = 3, sameMaxTaskCount = 1
            } else if (maxTask < counter[task - 'A']) {
                maxTask = counter[task - 'A'];
                sameMaxTaskCount = 1;
            }
        }

        // A  gap  A  gap  A
        int gaps = maxTask - 1;
        int emptySlots = gaps * (n - (sameMaxTaskCount -1));
        int availableTasks = tasks.length - maxTask*sameMaxTaskCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles; // totol intervals
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        
        char[] task2 = {'G','C','A','H','A','G','G','F','G','J','H','C','A','G','E','A','H','E','F','D','B','D','H','H','E','G','F','B','C','G','F','H','J','F','A','C','G','D','I','J','A','G','D','F','B','F','H','I','G','J','G','H','F','E','H','J','C','E','H','F','C','E','F','H','H','I','G','A','G','D','C','B','I','D','B','C','J','I','B','G','C','H','D','I','A','B','A','J','C','E','B','F','B','J','J','D','D','H','I','I','B','A','E','H','J','J','A','J','E','H','G','B','F','C','H','C','B','J','B','A','H','B','D','I','F','A','E','J','H','C','E','G','F','G','B','G','C','G','A','H','E','F','H','F','C','G','B','I','E','B','J','D','B','B','G','C','A','J','B','J','J','F','J','C','A','G','J','E','G','J','C','D','D','A','I','A','J','F','H','J','D','D','D','C','E','D','D','F','B','A','J','D','I','H','B','A','F','E','B','J','A','H','D','E','I','B','H','C','C','C','G','C','B','E','A','G','H','H','A','I','A','B','A','D','A','I','E','C','C','D','A','B','H','D','E','C','A','H','B','I','A','B','E','H','C','B','A','D','H','E','J','B','J','A','B','G','J','J','F','F','H','I','A','H','F','C','H','D','H','C','C','E','I','G','J','H','D','E','I','J','C','C','H','J','C','G','I','E','D','E','H','J','A','H','D','A','B','F','I','F','J','J','H','D','I','C','G','J','C','C','D','B','E','B','E','B','G','B','A','C','F','E','H','B','D','C','H','F','A','I','A','E','J','F','A','E','B','I','G','H','D','B','F','D','B','I','B','E','D','I','D','F','A','E','H','B','I','G','F','D','E','B','E','C','C','C','J','J','C','H','I','B','H','F','H','F','D','J','D','D','H','H','C','D','A','J','D','F','D','G','B','I','F','J','J','C','C','I','F','G','F','C','E','G','E','F','D','A','I','I','H','G','H','H','A','J','D','J','G','F','G','E','E','A','H','B','G','A','J','J','E','I','H','A','G','E','C','D','I','B','E','A','G','A','C','E','B','J','C','B','A','D','J','E','J','I','F','F','C','B','I','H','C','F','B','C','G','D','A','A','B','F','C','D','B','I','I','H','H','J','A','F','J','F','J','F','H','G','F','D','J','G','I','E','B','C','G','I','F','F','J','H','H','G','A','A','J','C','G','F','B','A','A','E','E','A','E','I','G','F','D','B','I','F','A','B','J','F','F','J','B','F','J','F','J','F','I','E','J','H','D','G','G','D','F','G','B','J','F','J','A','J','E','G','H','I','E','G','D','I','B','D','J','A','A','G','A','I','I','A','A','I','I','H','E','C','A','G','I','F','F','C','D','J','J','I','A','A','F','C','J','G','C','C','H','E','A','H','F','B','J','G','I','A','A','H','G','B','E','G','D','I','C','G','J','C','C','I','H','B','D','J','H','B','J','H','B','F','J','E','J','A','G','H','B','E','H','B','F','F','H','E','B','E','G','H','J','G','J','B','H','C','H','A','A','B','E','I','H','B','I','D','J','J','C','D','G','I','J','G','J','D','F','J','E','F','D','E','B','D','B','C','B','B','C','C','I','F','D','E','I','G','G','I','B','H','G','J','A','A','H','I','I','H','A','I','F','C','D','A','C','G','E','G','E','E','H','D','C','G','D','I','A','G','G','D','A','H','H','I','F','E','I','A','D','H','B','B','G','I','C','G','B','I','I','D','F','F','C','C','A','I','E','A','E','J','A','H','C','D','A','C','B','G','H','G','J','G','I','H','B','A','C','H','I','D','D','C','F','G','B','H','E','B','B','H','C','B','G','G','C','F','B','E','J','B','B','I','D','H','D','I','I','A','A','H','G','F','B','J','F','D','E','G','F','A','G','G','D','A','B','B','B','J','A','F','H','H','D','C','J','I','A','H','G','C','J','I','F','J','C','A','E','C','H','J','H','H','F','G','E','A','C','F','J','H','D','G','G','D','D','C','B','H','B','C','E','F','B','D','J','H','J','J','J','A','F','F','D','E','F','C','I','B','H','H','D','E','A','I','A','B','F','G','F','F','I','E','E','G','A','I','D','F','C','H','E','C','G','H','F','F','H','J','H','G','A','E','H','B','G','G','D','D','D','F','I','A','F','F','D','E','H','J','E','D','D','A','J','F','E','E','E','F','I','D','A','F','F','J','E','I','J','D','D','G','A','C','G','G','I','E','G','E','H','E','D','E','J','B','G','I','J','C','H','C','C','A','A','B','C','G','B','D','I','D','E','H','J','J','B','F','E','J','H','H','I','G','B','D'};
        
        int n = 1;
        System.out.println(new TaskScheduler().leastInterval(task2, n));


    }
}
