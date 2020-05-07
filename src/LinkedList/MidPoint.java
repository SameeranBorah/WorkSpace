package LinkedList;

public class MidPoint {
    public static void main(String[] args) {
        MergeTwoLL.ListNode L1=new MergeTwoLL.ListNode(-10,new MergeTwoLL.ListNode(3,new MergeTwoLL.ListNode(0,new MergeTwoLL.ListNode(5,new MergeTwoLL.ListNode(9,null)))));
        midPoint(L1);
    }
    private static void midPoint(MergeTwoLL.ListNode head){
        if(head==null||head.next==null)
            return ;
        MergeTwoLL.ListNode slow=head;
        MergeTwoLL.ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
//            System.out.println(slow.val);
//            System.out.println(fast.val);
            fast=fast.next.next;
            slow=slow.next;
//            System.out.println(slow.val);
//            System.out.println(fast.val);
        }
        System.out.println(slow.val);

    }
}
