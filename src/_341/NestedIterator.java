//package _341;
// TODO
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//
//// This is the interface that allows for creating nested lists.
//// You should not implement it, or speculate about its implementation
//interface NestedInteger {
//
//    // @return true if this NestedInteger holds a single integer, rather than a nested list.
//    public boolean isInteger();
//
//    // @return the single integer that this NestedInteger holds, if it holds a single integer
//    // Return null if this NestedInteger holds a nested list
//    public Integer getInteger();
//
//    // @return the nested list that this NestedInteger holds, if it holds a nested list
//    // Return null if this NestedInteger holds a single integer
//    public List<NestedInteger> getList();
//}
//
//public class NestedIterator implements Iterator<Integer> {
//
//    List<Integer> flatList = new ArrayList<>();
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        buildList(nestedList, flatList);
//    }
//
//    private void buildList(List<NestedInteger> nestedList, ArrayList<Integer> flatList){
//        Iterator itr = nestedList.iterator();
//        while (itr.hasNext()) {
//            if (itr.next().isInteger()) {
//                flatList.add((Integer) itr.next().getInteger());
//            } else {
//                buildList(itr.next().getList(), flatList);
//            }
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return flatList.get(0);
//    }
//
//    @Override
//    public boolean hasNext() {
//        return flatList.size() > 0;
//    }
//}
//
///**
// * Your NestedIterator object will be instantiated and called as such:
// * NestedIterator i = new NestedIterator(nestedList);
// * while (i.hasNext()) v[f()] = i.next();
// */