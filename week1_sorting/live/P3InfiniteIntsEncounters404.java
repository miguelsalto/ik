package week1_sorting.live;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P3InfiniteIntsEncounters404 {
    List<List<Integer>> findTopEnconters404(int[] arr, int k) {
        List<List<Integer>> result = new ArrayList<>();
        HeapList hl = new HeapList(k);
        for (int x : arr) {
            if (x == 404) {
                result.add(hl.getTopList());
            } else {
                hl.add(x);
            }
        }
        return result;
    }

    private static class HeapList {
        final int k;
        Node head = new Node(0);
        Node tail = head;
        PriorityQueue<Node> minHeap;

        private HeapList(int k) {
            this.k = k;
            minHeap = new PriorityQueue<>(k + 1, Comparator.comparingInt(a -> a.value));
        }

        void add(int x) {
            if (minHeap.size() < k || minHeap.peek().value < x) {
                appendToTail(x);
                minHeap.offer(tail);
            }
            if (minHeap.size() > k) {
                removeFromList(minHeap.poll());
            }
        }

        private void appendToTail(int x) {
            Node newNode = new Node(x);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        private void removeFromList(Node removed) {
            removed.prev.next = removed.next;
            if (tail == removed) {
                tail = tail.prev;
            } else {
                removed.next.prev = removed.prev;
            }
        }

        private List<Integer> getTopList() {
            List<Integer> list = new ArrayList<>(minHeap.size());
            Node current = head.next;
            while (current != null) {
                list.add(current.value);
                current = current.next;
            }
            return list;
        }
    }

    private static class Node {
        final int value;
        Node next;
        Node prev;

        private Node(int value) {
            this.value = value;
        }
    }
}
