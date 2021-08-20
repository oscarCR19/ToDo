package Main;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Tarea {

    String nombreTarea;
    String fecha;
    String encargadoTarea;
    boolean estado;

    public Tarea(String nombreTarea, String fecha, String encargadoTarea, boolean estado) {
        this.nombreTarea = nombreTarea;
        this.fecha = fecha;
        this.encargadoTarea = encargadoTarea;
        this.estado = estado;
    }

    public Tarea() {

    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEncargadoTarea() {
        return encargadoTarea;
    }

    public void setEncargadoTarea(String encargadoTarea) {
        this.encargadoTarea = encargadoTarea;
    }

}
