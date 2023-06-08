import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    static Table table = new Table();


    public Window(int width, int height) throws HeadlessException {
        init(width, height);

    }

    private void init(int width, int height) {
        // Inicializace okna
        setTitle("Závěrečná Zkouška");
        setVisible(true);
        setBackground(Color.white);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Load");
        panel.add(button);

        panel.add(new JScrollPane(table));

        add(panel);
    }
}
