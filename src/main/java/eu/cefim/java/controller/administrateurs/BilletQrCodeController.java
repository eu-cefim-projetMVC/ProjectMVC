package eu.cefim.java.controller.administrateurs;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import eu.cefim.java.controller.AccueilController;
import eu.cefim.java.model.billets.Billet;
import eu.cefim.java.model.billets.BilletQrCodeQuery;
import eu.cefim.java.model.organisateurs.Organisateur;
import eu.cefim.java.model.organisateurs.OrganisateurQuery;
import eu.cefim.java.vue.administrateurs.WindowQrCodeBillet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public class BilletQrCodeController {
    public static void start() {
        SwingUtilities.invokeLater(() -> {
            WindowQrCodeBillet windowQrCodeBillet = new WindowQrCodeBillet();
            windowQrCodeBillet.setVisible(true);
            windowQrCodeBillet.validateButton.addActionListener(e -> {
                Thread monThread = new Thread(() -> {
                    String idBillet = windowQrCodeBillet.idTextField.getText();
                    try {
                        Billet billet = BilletQrCodeQuery.findOne(idBillet);
                        if (idBillet.equals(String.valueOf(billet.getId()))) {
                            JOptionPane.showMessageDialog(windowQrCodeBillet, "La génération du Qr code du billet avec l'id : " + idBillet + " à réussi");
                            BitMatrix bitMatrix = generateMatrix(billet.getCode(),400);
                            String imageFormat = "png";
                            String outputFileName = "src\\main\\java\\eu\\cefim\\java\\resources\\qrcode-" + idBillet + "." + imageFormat;
                            writeImage(outputFileName, imageFormat, bitMatrix);
                            BufferedImage myPicture = ImageIO.read(new File(outputFileName));
                            windowQrCodeBillet.qrCode.setIcon(new ImageIcon(myPicture));
                            windowQrCodeBillet.add(windowQrCodeBillet.qrCode);
                            windowQrCodeBillet.pack();
                        }
                        else {
                            JOptionPane.showMessageDialog(windowQrCodeBillet, "Oups... Le billet avec l'id : " + idBillet + " n'existe pas !");
                        }
                    } catch (SQLException | WriterException | IOException ex) {
                        ex.printStackTrace();
                    }
                });
                monThread.start();
            });
        });
    }

    public static BitMatrix generateMatrix(String data, int size) throws WriterException {
        BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
        return bitMatrix;
    }

    private static void writeImage(String outputFileName, String imageFormat, BitMatrix bitMatrix) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(outputFileName));
        MatrixToImageWriter.writeToStream(bitMatrix, imageFormat, fileOutputStream);
        fileOutputStream.close();
    }
}
