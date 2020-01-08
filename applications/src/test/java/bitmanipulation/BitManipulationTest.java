package bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

public class BitManipulationTest {

    @Test
    public void isPowerOf2() {
        Assert.assertTrue(BitManipulation.isPowerOf2(4));
        Assert.assertFalse(BitManipulation.isPowerOf2(3));
    }

    @Test
    public void isEven() {
        Assert.assertTrue(BitManipulation.isEven(4));
        Assert.assertFalse(BitManipulation.isEven(3));
    }

    @Test
    public void isOdd() {
        Assert.assertFalse(BitManipulation.isOdd(4));
        Assert.assertTrue(BitManipulation.isOdd(3));
    }

    @Test
    public void totalSetBits() {
        Assert.assertEquals(3, BitManipulation.totalSetBits(7));
    }

    @Test
    public void isBetSet() {
        Assert.assertTrue(BitManipulation.isBitSet(2, 5));
        Assert.assertFalse(BitManipulation.isBitSet(1, 5));
    }

    @Test
    public void setBit() {
        Assert.assertFalse(BitManipulation.isBitSet(1, 5));
        int actual = BitManipulation.setBit(1, 5);
        Assert.assertEquals(7, actual);
    }

    @Test
    public void unsetBit() {
        int actual = BitManipulation.unsetBit(1, 7);
        Assert.assertEquals(5, actual);
    }

    @Test
    public void flipBit() {
        int actual = BitManipulation.flipBit(1, 5);
        Assert.assertEquals(7, actual);
        actual = BitManipulation.flipBit(1, actual);
        Assert.assertEquals(5, actual);
    }
}