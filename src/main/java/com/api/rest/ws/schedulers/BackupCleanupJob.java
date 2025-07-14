package com.api.rest.ws.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class BackupCleanupJob {

    private final String backupFolderPath = "C:\\Users\\Giam\\Music"; // Ajusta según tu carpeta real

    // Ejecuta todos los días a las 2:00 AM
    @Scheduled(cron = "0 0 2 * * ?")
    public void limpiarBackupsAntiguos() {
        File carpeta = new File(backupFolderPath);
        File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".sql"));

        if (archivos != null) {
            for (File archivo : archivos) {
                long diasDiferencia = ChronoUnit.DAYS.between(
                    Instant.ofEpochMilli(archivo.lastModified()),
                    Instant.now()
                );

                if (diasDiferencia > 7) {
                    if (archivo.delete()) {
                        System.out.println("Archivo eliminado: " + archivo.getName());
                    } else {
                        System.out.println("No se pudo eliminar: " + archivo.getName());
                    }
                }
            }
        }
    }
}