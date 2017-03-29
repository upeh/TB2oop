// File : FileReader.java
// PIC : Denita Hanna Widiasuti - 13514008

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.net.URL;

/**
 *
 * @author Denita Hanna Widiasuti - 13514008
 */
public class FileReader {
	private File file;
	private Scanner sc;
	//private String fileName;
	private int nBrs; 	/**< nBrs adalah jumlah baris area Zoo, */
	private int nKol;	/**	nKol adalah jumlah kolom area Zoo */
	private int nCellType; /**< nCellType adalah jumlah tipe Cell yang ada */
	private List<String> listCellType = new ArrayList<String>(); 
				/**< listCellType adalah list nama tipe Cell:
								airhabitat
								waterhabitat
								landhabitat
								road
								park
								restourant 
								entrance
								exit*/
	private List<Character> listCellSimbol = new ArrayList<Character>(); 
				/**< listCellSimbol adalah list karakter simbol Cell
								# airhabitat
								~ waterhabitat
								@ landhabitat
								- road
								* park
								$ restourant 
								\ entrance
								/ exit*/
	private List<List<Character>> maps = new ArrayList<List<Character>>(); /**< peta zoo */
	private int nCage; /**< jumlah Cage yang akan dibangun */
	private List<Character> listCageSimbol = new ArrayList<Character>(); /**< listCageSimbol adalah list karakter simbol Cage */
	private List<String> listCagetype = new ArrayList<String>();  /**< listCagetype adalah list tipe habitat Cage */
	private List<Integer> listNCageArea = new ArrayList<Integer>();  /**< listNCageArea adalah jumlah Cell yang akan dibangun pada masing2 Cage */
	private List<Integer> listNAnimal = new ArrayList<Integer>();  /**< listNAnimal adalah jumlah animal yang akan diciptakan pada masing2 Cage*/
	private List<List<Integer>> listPos = new ArrayList<List<Integer>>(); /**< listPos adalah list dari posisi Cage yang akan dibangun */

	/**
	* Membaca file eksternal 
	*
	* @param fileName Nama file eksternal yang akan dibaca
	*/
	public FileReader(String fileName) {
		// URL path = ClassLoader.getSystemResource(fileName);
		file = new File(fileName);
		try {
			sc = new Scanner(file);
			read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	* Membaca seluruh file 
	*/
	public void read() {		
		nBrs = sc.nextInt();
		nKol = sc.nextInt();
		sc.nextLine();

		nCellType = sc.nextInt();
		sc.nextLine();
		// String listCellType[] = new String[nCellType];
		// char listCellSimbol[] = new char[nCellType];
		for(int i=0; i<nCellType; i++) {
			listCellSimbol.add(i, sc.next().charAt(0));
			listCellType.add(i, sc.next());
			sc.nextLine();
		}

		// char maps[][] = new char[nBrs][nKol];
		for(int i=0; i<nBrs; i++) {
			maps.add(i, new ArrayList<Character>(nKol));
			String temp = sc.next();
			for (int j=0; j<nKol; j++) {
				maps.get(i).add(temp.charAt(j));
			}
			sc.nextLine();
		}

		nCage = sc.nextInt();
		// char listCageSimbol[] = new char[nCage];
		// String listCagetype[] = new String[nCage];
		// int listNCageArea[] = new int[nCage];
		for(int i=0; i<nCage; i++){
			listCageSimbol.add(sc.next().charAt(0));
			listCagetype.add(sc.next());
			listNCageArea.add(sc.nextInt());
			sc.nextLine();
		}

		// int listNAnimal[] = new int[nCage];
		// int listPos[][] = new int[getSumCageArea()][2];
		
		int c=0;
		int d=0;

		for(int i=0; i<nCage; i++) {
			for(int j=0; j<getNCageArea(i); j++) {
				listPos.add(new ArrayList<Integer>(2));
				listPos.get(c).add(sc.nextInt());
				listPos.get(c).add(sc.nextInt());
				sc.nextLine();
				c++;
			}
			listNAnimal.add(d,sc.nextInt());
			d++;
		}

		sc.close();
	}

	/**
	* getter. Mendapatkan total nilai cageArea
	*
	* @return sum
	*/
	public int getSumCageArea() {
		int sum=0;
		for (int i=0; i<listNCageArea.size(); i++){
			sum += listNCageArea.get(i);	
		}
		return sum;
	}

	/**
	* getter. Mendapatkan nilai baris area Zoo
	*
	* @return nBrs
	*/
	public int getNBrs() {
		return nBrs;
	}

	/**
	* getter. Mendapatkan nilai kolom area Zoo
	*
	* @return nKol
	*/
	public int getNKol() {
		return nKol;
	}

	/**
	* getter. Mendapatkan jumlah tipe Cell yang ada
	*
	* @return nCellType
	*/
	public int getNCellType() {
		return nCellType;
	}

	/**
	* getter. Mendapatkan jumlah Cage yang akan dibuat
	*
	* @return nCage
	*/
	public int getNCage() {
		return nCage;
	}


	/**
	* getter. Mendapatkan tipe Cell ke i
	*
	* @param i Index tipe Cell yang akan dikembalikan
	* @return listCellType[i]
	*/
	public String getCellType(int i) {
		return listCellType.get(i);
	}

	/**
	* getter. Mendapatkan simbol Cell ke i
	* 
	* @param i Index simbol Cell yang akan dikembalikan
	* @return listCellSimbol[i]
	*/
	public char getCellSimbol(int i) {
		return listCellSimbol.get(i);
	}

	/**
	* getter. Mendapatkan simbol Cell pada maps[i][j]
	*
	* @param i Index baris maps
	* @param j Indeks kolom maps
	* @return maps[i][j]
	*/
	public char getMaps(int i, int j) {
		return maps.get(i).get(j);
	}

	/**
	* getter. Mendapatkan tipe Cage ke i
	*
	* @param i Index tipe Cage yang akan dikembalikan
	* @return listCagetype[i]
	*/
	public String getCageType(int i) {
		return listCagetype.get(i);
	}

	/**
	* @brief getter. Mendapatkan simbol Cage ke i
	* @param i Index simbol Cage yang akan dikembalikan
	* @return listCageSimbol[i]
	*/
	public char getCageSimbol(int i) {
		return listCageSimbol.get(i);
	}

	/**
	* @brief getter. Mendapatkan area Cage ke i
	* @param i Index area Cage yang akan dikembalikan
	* @return listNCageArea[i]
	*/
	public int getNCageArea(int i) {
		return listNCageArea.get(i);
	}

	/**
	* @brief getter. Mendapatkan jumlah Animal ke i
	* @param i Index jumlah Animal yang akan dikembalikan
	* @return listNAnimal[i]
	*/
	public int getNAnimal(int i) {
		return listNAnimal.get(i);
	}

	/**
	* @brief getter. Mendapatkan posisi X Cell Cage ke i
	* @param i Index posisi X Cell Cage yang akan dikembalikan
	* @return listPos[i][0]
	*/
	public int getPosX(int i) {
		return listPos.get(i).get(0);
	}

	/**
	* @brief getter. Mendapatkan posisi Y Cell Cage ke i
	* @param i Index posisi Y Cell Cage yang akan dikembalikan
	* @return listPos[i][1]
	*/
	public int getPosY(int i) {
		return listPos.get(i).get(1);
	}
}