package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position(), is(Cell.C1));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.copy(Cell.E3);
        assertThat(new BishopBlack(Cell.E3), is(bishopBlack.copy(Cell.E3)));
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.G5);
        assertThat(bishopBlack.way(Cell.G5), is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void testWay2() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G1);
        bishopBlack.way(Cell.A7);
        assertThat(bishopBlack.way(Cell.A7), is(new Cell[]{Cell.F2, Cell.E3, Cell.D4, Cell.C5, Cell.B6, Cell.A7}));
    }
}