package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(33.1); // 33.1 null null  null
        arb.enqueue(44.8); // 33.1 44.8 null  null
        arb.enqueue(62.3); // 33.1 44.8 62.3  null
        arb.enqueue(-3.4); // 33.1 44.8 62.3 -3.4
        assertEquals(33.1, arb.dequeue().doubleValue(), 0.01);    // 44.8 62.3 -3.4  null (returns 33.1)
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(22.5);
        arb.enqueue(33.1);
        assertEquals(2, arb.fillCount());
        assertEquals(22.5, arb.peek().doubleValue(), 0.01);
        Iterator<Double> it = arb.iterator();
        while (it.hasNext()) {
            Double v = it.next();
            System.out.println(v);
        }
        for (Double elem : arb) {
            Double v = elem;
            System.out.println(v);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
