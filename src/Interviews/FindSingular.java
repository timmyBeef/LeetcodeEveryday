//package Interviews;
//
//import java.util.*;
//import java.util.stream.*;
//
///*
//https://www.geeksforgeeks.org/find-element-appears-array-every-element-appears-twice/
//
// */
///**
// input = "1,1,2,2,4,4,5,6,6,7,7"
// output = 5
// */
//
//class Solution {
//    public static void main(String[] args) {
//        // test cases
//        String test1 = "1,1,2,2,4,4,5,6,6,7,7";
//
//        System.out.println(Solution1.findSingular3(test1) == 5);
//
//
//        String test2 = "1,2,5,6";
//
//        System.out.println(Solution1.findSingular3(test2) == 1);
//
//
//        String test3 = "";
//
//        try {
//            Solution1.findSingular(test3);
//        } catch (IllegalArgumentException e) {
//            System.out.println("pleaze input".equals(e.getMessage()));
//        }
//
//
//        String test4 = null;
//
//        try {
//            Solution1.findSingular(test4);
//        } catch (IllegalArgumentException e) {
//            System.out.println("pleaze input".equals(e.getMessage()));
//        }
//
//
//    }
//
//    public static int findSingular(String input) {
//
//        if ("".equals(input) || input == null) throw new IllegalArgumentException("pleaze input");
//
//        String inputAry[] = input.split(",");
//
//
//        List<String> inputList = Arrays.asList(inputAry);
//
//        // o(n^2)
//        List<String> result = inputList.stream()
//                .filter(i -> Collections.frequency(inputList, i) < 2).collect(Collectors.toList());
//
//        return Integer.parseInt(result.get(0));
//    }
//
//    /*
//        A better solution is to use hashing.
//        1) Traverse all elements and put them in a hash table. Element is used as key and count of occurrences is used as value in hash table.
//        2) Traverse the array again and print the element with count 1 in hash table.
//        This solution works in O(n) time, but requires extra space.
//     */
//
//    public static int findSingular2(String input) {
//        if ("".equals(input) || input == null) throw new IllegalArgumentException("pleaze input");
//
//        String inputAry[] = input.split(",");
//        Map<String, Integer> map = new HashMap<>();
//        for (String str : inputAry) {
//            map.put(str, map.getOrDefault(str, 0)+1);
//        }
////        List<Integer> list = map.entrySet()
////                .stream()
////                .filter(m -> m.getValue() < 2)
////                .map(v -> Integer.parseInt(v.getKey()))
////                .collect(Collectors.toList());
////        if(list.size() > 0) {
////            return list.get(0);
////        } else {
////            throw new IllegalArgumentException("no ans");
////        }
//
//        for(Map.Entry<String, Integer> m : map.entrySet()) {
//            if(m.getValue() < 2) {
//                return Integer.parseInt(m.getKey());
//            }
//        }
//        throw new IllegalArgumentException("no ans");
//
//    }
//
//
///*
//The best solution is to use XOR.
//XOR of all array elements gives us the number with single occurrence.
//
//The idea is based on following two facts.
//a) XOR of a number with itself is 0.
//b) XOR of a number with 0 is number itself.
// */
//
//    public static int findSingular3(String input) {
//        if ("".equals(input) || input == null) throw new IllegalArgumentException("pleaze input");
//
//        String inputAry[] = input.split(",");
//
//
//        int res = Integer.parseInt(inputAry[0]);
//        for (String in : inputAry) {
//            res = res ^ Integer.parseInt(in);
//            System.out.println(res);
//        }
//
//        return res;
//    }
//}
