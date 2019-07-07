public class OuterInner
{
    private int x;
//    public static class Inner
//    {
//        public class InnerInner1
//        {
//            private int x;
//        }
//    }

    public static void main(String[] args)
    {
        final OuterInner outerInner = new OuterInner();
        outerInner.x = 1;
    }
}
