class MergeTwoSortedLists {

    public static void main(String[] args) {

        ListNode node3 = new ListNode(4, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node4 = new ListNode(4 ,null);
        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(1, node5);

        mergeTwoLists(node1, node6);
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}





