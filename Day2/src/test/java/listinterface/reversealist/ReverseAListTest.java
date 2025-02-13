package listinterface.reversealist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class ReverseAListTest {
    @Test
    void testReverseAList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        ReverseAList rl = new ReverseAList();
        rl.reverse(list);
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(3);
        expected.add(2);
        expected.add(1);
        assertEquals(expected, list); 
    }
}