package baseClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import tools.Utility;

/**
 * the {@link Song} class is one of the two basic classes of the whole project:
 * it contains all the {@link Word} objects contained in a specific Song, and
 * provides tools to modify and utilize them.
 * 
 * @author Andrea Righi
 *
 */
public class Song {

	private File input;
	private String author = "", title = "";
	private ArrayList<Word> song = new ArrayList<Word>();
	public static ArrayList<Song> all = new ArrayList<Song>();

	public Song(File input) {

		all.add(this);

		this.input = input;

		String[] needed = input.getName().replaceAll(".txt", "").split("-");

		author = needed[0].trim();
		title = needed[1].trim();

		this.read();

	}

	public String getAuthor() {

		return author;

	}

	public String getTitle() {

		return title;

	}

	public void setAuthor(String author) {

		this.author = author;

	}

	public void setTitle(String title) {

		this.title = title;

	}

	/**
	 * this is the method used to read an entire song, and store it into the
	 * {@link Song} object.
	 */
	public void read() {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-8"))) {

			String line = br.readLine();

			while (line != null) {

				String[] words = line.split("[^a-zA-Zàèéìòù]+");

				for (String analyzeWord : words) {

					analyzeWord = analyzeWord.toLowerCase();

					if (!analyzeWord.isEmpty()) {

						Word toAdd = new Word(analyzeWord, title, author);
						song.add(toAdd);

					}

				}

				line = br.readLine();

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		song = Utility.songList(song);

	}

	public ArrayList<Word> getSong() {

		return song;

	}

	public String toString() {

		String result = "N, Parola, Canzone, Canzoni sul totale, Autore, Apparizioni Tot,\n";

		for (Word toPrint : song) {

			result += toPrint + "\n";

		}

		return result;

	}

}
