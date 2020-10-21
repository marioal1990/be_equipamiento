package cl.gob.chinchorro.be.equipamiento.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase de métodos utiles de Fechas (parseos, operaciones, etc.)
 * @author Vanessa Alejandra Duque Pereira
 */
@Slf4j
public class DateUtil {
    
    private DateUtil(){
    }
    
    /**
     * Método que parsea una fecha tipo java.util.Date a String
     * @param date Fecha obtenida de tipo java.util.Date
     * @return Fecha transformada a String
     */
    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(ConstantsUtil.DATETIME_FORMAT_DMY_HMS);
        return sdf.format(date);
    }
    
    /**
     * Método que parsea una fecha tipo string a java.util.Date
     * @param date Fecha obtenida de tipo String
     * @return Fecha transformada a java.util.Date
     */
    public static Date stringTimeToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(ConstantsUtil.DATETIME_FORMAT_DMY_HMS);
        Date dateDate = null;
        try {
            dateDate = sdf.parse(date);
        } catch (ParseException ex) {
            log.error("stringTimeToDate - Parseo de fecha", ex);
        }
        return dateDate;
    }
}
