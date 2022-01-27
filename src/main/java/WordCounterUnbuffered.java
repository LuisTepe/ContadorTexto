import java.io.*;

public class WordCounterUnbuffered {

    public WordCounterUnbuffered(){

    }

    public void counterTokenizerUnbuffered(){
        String fileName = "divina_comedia.txt";

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("El nombre del archivo no se encuentra");
            System.exit(2);
        }

        StreamTokenizer st = new StreamTokenizer(fileReader);

        String textLine = null;
        int contadorPalabras = 0;
        int tipoToken = 0;

        // tiempo al inicio
        long start = System.currentTimeMillis();
        try {
            while ((tipoToken = st.nextToken()) != StreamTokenizer.TT_EOF) {
                if( tipoToken == StreamTokenizer.TT_WORD) {
                    contadorPalabras++;
                    //System.out.println(st.sval);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de entrada");
            System.exit(3);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // tiempo de procesamiento
        long time = System.currentTimeMillis() - start;
        System.out.println("");
        System.out.println("Tokenizer Unbuffered");
        System.out.printf("El archivo %s tiene %,7d palabras. " , fileName, contadorPalabras );
        System.out.printf(" Numero de lineas: %,6d%n", st.lineno() );
        System.out.printf("Tiempo procesamiento (milisegundos): %d %n" , time);
    }
}