package bitmanipulation;

public class BitManipulation {

    private BitManipulation(){
        // to avoid instantiation
    }

    public static boolean isBitSet(int pos, int num) {
        // 101 -> 001 -> 0 0 1 -> 0Th bit set
        return ((1 << pos) & num) != 0;
    }

    public static int flipBit(int pos, int num) {
        int flag = 1 << pos;
        num ^= flag;
        return num;
    }

    public static int setBit(int pos, int num) {
        // this will put 1 at the pos and zeros in other places
        int flag = 1 << pos;
        num |= flag;
        return num;
    }

    public static int unsetBit(int pos, int num) {
        int flag = ~(1 << pos);
        num &= flag;
        return num;
    }

    public static boolean isPowerOf2(int num) {
        // 2,4,8,16 .... all have just one bit set at these positions
        return (num != 0 && (num & (num - 1)) == 0);
    }

    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }

    public static boolean isOdd(int num) {
        return (num & 1) != 0;
    }

    public static int totalSetBits(int num) {
        int total = 0;
        while (num != 0) {
            num &= num - 1;
            ++total;
        }
        return total;
    }
}
