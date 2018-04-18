package Task1;

public class Pyramid {
    private int[] level;

    public void cratePyramid(int size) {
        level = new int[size * 2 - 1];
        for (int i = 1; i <= size; i++) {
            drawNewLevel(createLine(i));
        }
    }

    private void drawNewLevel(int[] numbers) {
        for (int num : numbers) {
            if (num == 0) {
                System.out.print(" ");
            } else {
                System.out.print(num);
            }
        }
        System.out.print("\n");
    }

    private int[] createLine(int sizeNumber) {
        int middle = level.length / 2;
        int number = sizeNumber;
        for (int i = middle; number > 0; i--) {
            level[i] = number;
            number--;
        }
        for (int i = middle; sizeNumber > 0; i++) {
            level[i] = sizeNumber;
            sizeNumber--;
        }
        return level;
    }
}
