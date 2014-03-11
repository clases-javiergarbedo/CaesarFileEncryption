/*
 * Copyright (C) 2014 Javier García Escobedo (javiergarbedo.es)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package es.javiergarbedo.caesarcipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Javier García Escobedo (javiergarbedo.es)
 * @version 0.0.1
 * @date 2014-03-10
 */
public class CaesarCipher {

    //Desplazamiento que se aplicará a cada caracter
    private int offset;

    /**
     * Permite codificar y decodificar caracteres y archivos de texto utilizando
     * el cifrado César.
     *
     * @param offset Desplazamiento que se aplicará a cada caracter
     */
    public CaesarCipher(int offset) {
        this.offset = offset;
    }

    /**
     * Encripta un carácter
     *
     * @param decodedChar Carácter a encriptar
     * @return Carácter encriptado
     */
    public char encode(char decodedChar) {
        char encodedChar = (char) (decodedChar + offset);
        return encodedChar;
    }

    /**
     * Desencripta un carácter
     *
     * @param codedChar Carácter encriptado
     * @return Carácter desencriptado
     */
    public char decode(char codedChar) {
        char decodedChar = (char) (codedChar - offset);
        return decodedChar;
    }

    /**
     * Encripta el contenido de un archivo
     * 
     * @param decodedFile Archivo original
     * @param encodedFile Archivo encriptado
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void encodeFile(File decodedFile, File encodedFile)
            throws FileNotFoundException, IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(decodedFile));
        BufferedWriter ouputFile = new BufferedWriter(new FileWriter(encodedFile));
        int characterRead = inputFile.read();
        while (characterRead != -1) {
            char charToWrite = encode((char) characterRead);
            ouputFile.write(charToWrite);
            characterRead = inputFile.read();
        }
        inputFile.close();
        ouputFile.close();
    }

    /**
     * Desencripta el contenido de un archivo
     * 
     * @param encodedFile Archivo encriptado
     * @param decodedFile Archivo desencriptado
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void decodeFile(File encodedFile, File decodedFile)
            throws FileNotFoundException, IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(encodedFile));
        BufferedWriter ouputFile = new BufferedWriter(new FileWriter(decodedFile));
        int characterRead = inputFile.read();
        while (characterRead != -1) {
            char charToWrite = decode((char) characterRead);
            ouputFile.write(charToWrite);
            characterRead = inputFile.read();
        }
        inputFile.close();
        ouputFile.close();
    }

}
