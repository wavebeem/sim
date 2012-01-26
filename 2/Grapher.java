import java.awt.*;
import javax.swing.*;

public class Grapher extends JFrame {
    private final Canvas canvas;
    private final Color bgColor = new Color( 17,  17,  17);
    private final Color fgColor = new Color(224, 224, 224);

    public Grapher(DataList dl) {
        canvas = new Canvas(dl);
        canvas.setPreferredSize(new Dimension(800, 480));
        setBackground(bgColor);
        setForeground(fgColor);
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(new YAxis(dl),   BorderLayout.WEST);
        add(new XAxis(dl), BorderLayout.SOUTH);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}