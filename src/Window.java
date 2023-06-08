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

        panel.add(new JScrollPane(table));
        table.loadData();

        add(panel);
    }
}
