package mini3;

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
                            SpecChecker.class,
                            "SUBMIT_THIS_mini3",
                            "mini3",
                            new String[]{"src/mini3/MazeExplorer.java", "src/mini3/TwentyFour.java"}
                    );
                }
            });
        }
    }
}
