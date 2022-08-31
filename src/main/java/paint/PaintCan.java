package paint;

import cn.hutool.core.util.StrUtil;
import org.ujmp.core.util.StringUtil;
import paint.*;

import java.util.Arrays;

/**
 * @author linxi
 */
public class PaintCan extends Paint {

    public static void main(String[] args) {
        PaintCan p = new PaintCan();
    }

    public void fillBob(int x, int y) {
        while (!isFilled(x, y - 1)) {
            y = y - 1;
        }

        while (!isFilled(x, y)) {
            int x2 = x;
            while (!isFilled(x2, y)) {
                fillPixel(x2, y);
                x2++;
            }
            x2 = x - 1;

            while (!isFilled(x2, y)) {
                fillPixel(x2, y);
                x2--;
            }
            y++;
        }

        // Warum funktioniert dieser Code nicht? (2 Punkte)
    }

    public void fillRec(int x, int y) {
        // Wie wuerden Sie dieses Problem angehen? (2 Punkte)
        if (!isFilled(x, y)) {
            fillPixel(x, y);
            fillRec(x + 1, y);
            fillRec(x - 1, y);
            fillRec(x, y + 1);
            fillRec(x, y - 1);
        } else {
            return;
        }
        // Rekursive Loesung (3 Punkte)
    }

    // Zusammenhang zwischen Traversierung von Graphen und dem Fuellen von Flaechen? (keine Punkte, aber interessant)
}
