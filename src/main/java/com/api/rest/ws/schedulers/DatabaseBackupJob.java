package com.api.rest.ws.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DatabaseBackupJob {

    // Se ejecuta todos los días a medianoche
	@Scheduled(cron = "0 0 0 * * ?")
    public void backupDatabase() {
        String fecha = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String nombreArchivo = "backup_" + fecha + ".sql";

        String comando = "\"C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump.exe\" -u root -p1234 --databases bd_ingles -r \"C:\\Users\\Giam\\Music\\" + nombreArchivo + "\"";


        try {
            Process runtimeProcess = Runtime.getRuntime().exec(comando);
            
            // Leer errores del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(runtimeProcess.getErrorStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.err.println("ERROR >> " + linea);
            }

            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup exitoso: " + nombreArchivo);
            } else {
                System.out.println("Backup fallido.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}