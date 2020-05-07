package LinkedList;
public class MergeTwoLL {
    public static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x,ListNode next) { this.val = x; this.next = next; }
  }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode =new ListNode(0,null);
        ListNode tail=dummyNode;
        while(true){
            if(l1==null){
                tail.next=l2;
                break;
            }
            if(l2==null){
                tail.next=l1;
                break;
            }
            if(l1.val<=l2.val){
                tail.next=l1;
                l1=l1.next;
            }
            else{
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        ListNode L1=new ListNode(1,new ListNode(2,new ListNode(4,null)));
        ListNode L2=new ListNode(1,new ListNode(3,new ListNode(4,null)));
        ListNode L=mergeTwoLists(L1,L2);
        while(L!=null){
            System.out.println(L.val);
            L=L.next;
        }

    }
}
