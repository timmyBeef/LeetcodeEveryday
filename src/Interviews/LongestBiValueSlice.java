package Interviews;

public class LongestBiValueSlice {
    public int getLongestSlice(int[] arr) {
        int lastSeen = -1;
        int secondLastSeen = -1;
        int lbs = 0;
        int tempCount = 0;
        int lastSeenNumberRepeatedCount = 0;

        for (int current : arr) {
            if (current == lastSeen || current == secondLastSeen) {
                tempCount++;
            } else {
                // if the current number is not in our read list it means new series has started, tempCounter value in this case will be
                // how many times lastSeen number repeated before this new number encountered + 1 for current number.
                tempCount = lastSeenNumberRepeatedCount + 1;
            }
            // record repeated num (last)
            // record lastNum, and secondLastNum
            // if curr == last or secondlast => it's ok! bi-value, so count++
            // or start new count, count = repeated num + 1
            if (current == lastSeen) {
                lastSeenNumberRepeatedCount++;
            } else {
                lastSeenNumberRepeatedCount = 1;

                secondLastSeen = lastSeen;
                lastSeen = current;
            }

            lbs = Math.max(tempCount, lbs);
        }
        return lbs;
    }

    public static void main(String[] args) {
        System.out.println(new LongestBiValueSlice().getLongestSlice(new int[]{1, 2, 1, 2, 2, 3, 3, 2, 3}));
    }
}
