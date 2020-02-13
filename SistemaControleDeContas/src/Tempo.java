import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tempo { //armazena metodos relativos a manipulacao de datas e hashes

    private String formatoData = "dd/MM/yyyy";
    final private long numMilissegundosPorDia = 86400000; //24*60*60*1000

    //metodos

    public Date geraDataAtual() {

        Date date = new Date();
        return date;

    }

    public String converteDataEmString(Date date) {

        DateFormat dateFormat = new SimpleDateFormat(this.formatoData);
        String formattedDate = dateFormat.format(date);

        return formattedDate;

    }

    public long geraDiferencaEntreDuasDatasEmDias(Date date1, Date date2) {

        long diferencaDias = date2.getTime() - date1.getTime();

        return diferencaDias/this.numMilissegundosPorDia;

    }

    public Date converteStringEmData(String string) throws ParseException {

        Date data = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatoData);
        data = simpleDateFormat.parse(string);

        return data;

    }

    public Date adicionaDiasAUmaData(int numDias, Date data) {

        data.setTime(data.getTime() + numDias*numMilissegundosPorDia);
        return data;

    }


    public String geraHash(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String metodoHash = "SHA-256";
        String charset = "UTF-8";

        MessageDigest algorithm = MessageDigest.getInstance(metodoHash);
        byte messageDigest[] = algorithm.digest(senha.getBytes(charset));

        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {

            hexString.append(String.format("%02X", 0xFF & b));

        }
        String senhahex = hexString.toString();

        return senhahex;

    }

    public boolean comparaHashes(String hash1, String hash2) {

        return hash1.equals(hash2);

    }


}
