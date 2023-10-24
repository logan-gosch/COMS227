//package mini1;
//
//import javax.swing.SwingUtilities;
//import speccheck.SpecCheck;
//
//public class Runner {
//    public static void main(String args[])
//    {
//        {
//            // GUI dialogs are used, so we need to run on the event thread.
//            SwingUtilities.invokeLater( new Runnable()
//            {
//                public void run()
//                {
//                    SpecCheck.testAndZip(
//                            SpecChecker.class,
//                            "SUBMIT_THIS_mini1",
//                            "mini1",
//                            new String[]{"src/mini1/AcrossTheLooperverse.java"});
//                }
//            });
//        }
//    }
//}
