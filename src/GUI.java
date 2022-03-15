import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener
{
    private JTextField TFinput;
    private JButton BTNgo;
    private JLabel LBLresult;

    public static void main (String[] args)
    {
        EventQueue.invokeLater(
                new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new GUI();
                    }
                }
        );
    }

    public GUI()
    {
        initGUI();
    }

    private void initGUI()
    {
        setTitle("State Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(512, 256);

        JPanel pnlTop = new JPanel();

        TFinput = new JTextField(10);
        TFinput.addActionListener(this);

        BTNgo = new JButton("Search");
        BTNgo.addActionListener(this);

        LBLresult = new JLabel("STATE SEARCH");
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

    }
}
