package Main;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Reportes {

    public void hacerReporte() {
        Document documento = new Document();
        Paragraph nombreDocumento = new Paragraph("Reporte de tareas");
        Paragraph tituloDocumento = new Paragraph("Reporte tareas por realizar");
        Paragraph tituloDocumento2 = new Paragraph("Reporte tareas ya realizadas");

        try {
            FileOutputStream archivo = new FileOutputStream("Reporte inventario .pdf");
            PdfWriter.getInstance(documento, archivo);
            documento.open();

            nombreDocumento.setAlignment(1);
            documento.add(nombreDocumento);
            documento.add(Chunk.NEWLINE);
            documento.add(tituloDocumento);
            documento.add(Chunk.NEWLINE);
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            PdfPCell nombreTarea = new PdfPCell(new Paragraph("Nombre"));
            nombreTarea.setBackgroundColor(new BaseColor(253, 255, 215));

            PdfPCell encargado = new PdfPCell(new Paragraph("Encargado"));
            encargado.setBackgroundColor(new BaseColor(253, 255, 215));

            PdfPCell fecha = new PdfPCell(new Paragraph("Fecha"));
            fecha.setBackgroundColor(new BaseColor(253, 255, 215));

            tabla.addCell(nombreTarea);
            tabla.addCell(encargado);
            tabla.addCell(fecha);

            for (int i = 0; i < Tareas.tareas.size(); i++) {
                if (Tareas.tareas.get(i).isEstado() == true) {
                    PdfPCell NOMBRE = new PdfPCell(new Paragraph(String.valueOf(Tareas.tareas.get(i).getNombreTarea())));

                    PdfPCell ENCARGADO = new PdfPCell(new Paragraph(String.valueOf(Tareas.tareas.get(i).getEncargadoTarea())));

                    PdfPCell FECHA = new PdfPCell(new Paragraph(String.valueOf(Tareas.tareas.get(i).getFecha())));

                    tabla.addCell(NOMBRE);
                    tabla.addCell(ENCARGADO);
                    tabla.addCell(FECHA);
                }

            }
            /////////tabla2
            PdfPTable tabla2 = new PdfPTable(3);
            tabla2.setWidthPercentage(100);
            PdfPCell nombre = new PdfPCell(new Paragraph("Nombre"));
            nombre.setBackgroundColor(new BaseColor(253, 255, 215));

            PdfPCell Encargado = new PdfPCell(new Paragraph("Encargado"));
            Encargado.setBackgroundColor(new BaseColor(253, 255, 215));

            PdfPCell Fecha = new PdfPCell(new Paragraph("Fecha"));
            Fecha.setBackgroundColor(new BaseColor(253, 255, 215));

            tabla2.addCell(nombre);
            tabla2.addCell(Encargado);
            tabla2.addCell(Fecha);

            for (int i = 0; i < Tareas.tareas.size(); i++) {
                if (Tareas.tareas.get(i).isEstado() == false) {
                    PdfPCell NOMBRE = new PdfPCell(new Paragraph(String.valueOf(Tareas.tareas.get(i).getNombreTarea())));

                    PdfPCell ENCARGADO = new PdfPCell(new Paragraph(String.valueOf(Tareas.tareas.get(i).getEncargadoTarea())));

                    PdfPCell FECHA = new PdfPCell(new Paragraph(String.valueOf(Tareas.tareas.get(i).getFecha())));

                    tabla2.addCell(NOMBRE);
                    tabla2.addCell(ENCARGADO);
                    tabla2.addCell(FECHA);
                }

            }

            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(tituloDocumento2);
            documento.add(Chunk.NEWLINE);
            documento.add(tabla2);
            documento.close();

        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        }

    }

}
