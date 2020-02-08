import javax.swing.*;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Oct 31 19:02:35 CST 2019
 */



/**
 * @author unknown
 */
public class s extends JPanel {
    public s() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        comboBox1 = new JComboBox();
        comboBox2 = new JComboBox();
        scrollPane2 = new JScrollPane();
        textPane1 = new JTextPane();
        radioButton1 = new JRadioButton();
        panel1 = new JPanel();
        progressBar1 = new JProgressBar();
        scrollPane1 = new JScrollPane();
        list1 = new JList();

        //======== this ========
        setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));
        add(comboBox1, "cell 6 2");
        add(comboBox2, "cell 1 4");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(textPane1);
        }
        add(scrollPane2, "cell 6 8");

        //---- radioButton1 ----
        radioButton1.setText("text");
        add(radioButton1, "cell 3 10");

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]" +
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]" +
                "[]"));
            panel1.add(progressBar1, "cell 1 2 1 3");

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(list1);
            }
            panel1.add(scrollPane1, "cell 1 6");
        }
        add(panel1, "cell 6 12");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JScrollPane scrollPane2;
    private JTextPane textPane1;
    private JRadioButton radioButton1;
    private JPanel panel1;
    private JProgressBar progressBar1;
    private JScrollPane scrollPane1;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
