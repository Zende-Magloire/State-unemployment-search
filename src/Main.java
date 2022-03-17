import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.*;

public class Main extends JFrame implements ActionListener
{
    private JTextField TFinput;
    private JButton BTNgo;
    private JLabel LBLresult;

    Load load = new Load();

    public static void main (String[] args)
    {
        EventQueue.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new Main();
                    }
                }
        );
    }

    public Main()
    {
        initGUI();
        load.loadState();
    }

    private void initGUI()
    {
        setTitle("State Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(512, 256);

        JPanel pnlTop = new JPanel();
        pnlTop.setBackground(Color.pink);

        TFinput = new JTextField(10);
        TFinput.addActionListener(this);

        BTNgo = new JButton("Search");
        BTNgo.addActionListener(this);

        LBLresult = new JLabel("STATE UNEMPLOYMENT SEARCH");
        LBLresult.setHorizontalAlignment(JLabel.CENTER);

        pnlTop.add(new JLabel("Enter state abbreviation:"));
        pnlTop.add(TFinput);
        pnlTop.add(BTNgo);

        this.add(pnlTop, BorderLayout.PAGE_START);
        this.add(LBLresult, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String abb = TFinput.getText();
        String ab = abb.toUpperCase(Locale.ROOT);
        State state = load.getMapState().get(ab);

        if (!load.getMapState().containsKey(ab))
        {
            LBLresult.setOpaque(true);
            LBLresult.setBackground(Color.RED);
            LBLresult.setText(ab + " is not a state abbreviation! Try again.");
        }
         else
        {
            LBLresult.setOpaque(true);
            LBLresult.setBackground(Color.YELLOW);
            state = load.getMapState().get(ab);
            LBLresult.setText(String.valueOf(state));
         }
        TFinput.setText("");
    }
}
