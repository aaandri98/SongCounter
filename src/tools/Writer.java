package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import baseClasses.Song;

/**
 * the {@link Writer} class is used to output the result of computations: it
 * contains three methods, each to write a different kind of .csv file,
 * depending on its characteristics.
 * 
 * @author Andrea Righi
 *
 */
public class Writer {

	private static File file;

	/**
	 * this method is used to write the output of a single song: it creates a
	 * specific file, and write in it.
	 * 
	 * @param one
	 *            the {@link Song} object to be written.
	 */
	public static void saveSingleSong(Song one) {

		file = new File("src/output/canzoniprocessate/" + one.getAuthor() + " - " + one.getTitle() + ".csv");

		try {

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath())));

			writer.write(one.toString());

			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * this method is used to write the output of multiple songs, written by the
	 * same artist: it creates a specific file, and write in it.
	 * 
	 * @param one
	 *            the {@link Song} object to be written.
	 * @param author
	 *            the author of the songs, necessary for the file name.
	 */
	public static void saveMultipleSong(String one, String author) {

		file = new File("src/output/canzoniperautore/" + author + ".csv");

		try {

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath())));

			writer.write(one);

			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	/**
	 * this method is used to write the output of all the songs: it creates a
	 * specific file, and write in it.
	 * 
	 * @param one
	 *            the {@link Song} object to be written.
	 */
	public static void saveFinal(String one) {

		file = new File("src/output/finale.csv");

		try {

			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getPath())));

			writer.write(one);

			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
