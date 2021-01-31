package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rsl = false;
            try {
                int index = findBy(source);
                if (index != -1) {
                    Cell[] steps = figures[index].way(dest);
                    for (int i = 0; i < steps.length; i++) {
                        if(findBy(steps[i]) == -1 && steps[steps.length - 1].equals(dest)) {
                            rsl = true;
                            figures[index] = figures[index].copy(dest);
                        } else break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rsl;
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
            for (int i = 0; i < figures.length; i++) {
                if ((figures[i].equals(steps[i]))) {
                    return true;
                }
            }
            throw new OccupiedCellException();
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
