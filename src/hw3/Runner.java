package hw3;

import speccheck.SpecCheck;

import javax.swing.*;

public class Runner {
    public static void main(String args[])
    {
        {
            // GUI dialogs are used, so we need to run on the event thread.
            SwingUtilities.invokeLater( new Runnable()
            {
                public void run()
                {
                    SpecCheck.testAndZip(
                            hw3.SpecChecker.class,
                            "SUBMIT_THIS_hw3",
                            "hw3",
                            new String[]{"src/hw3/AlphabetSoup.java", "src/hw3/AlphabetUtil.java"}
                    );
                }
            });
        }
    }
}
