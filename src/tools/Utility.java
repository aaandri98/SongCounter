package tools;

import java.io.File;
import java.util.ArrayList;

import baseClasses.Word;

/**
 * the {@link Utility} class contains useful methods to initialize the folders
 * and to modify the {@link Word} {@link ArrayList}, in order to modify them
 * recycling the appropriate code.
 * 
 * @author Andrea Righi
 *
 */
public class Utility {

	static File init = new File("src/output");

	/**
	 * this method takes the <i>init</i> folder ("src/output") and creates it; then
	 * it creates the necessary folders to contain all the output files.
	 */
	public static void initialize() {

		clearDirectory();

		init.mkdir();

		File author = new File("src/output/canzoniperautore");
		File song = new File("src/output/canzoniprocessate");

		author.mkdir();
		song.mkdir();

	}

	/**
	 * this method checks the <i>init</i> folder and deletes everything is contained
	 * by it, making sure that no result will be overwritten or modified by mistake.
	 */
	public static void clearDirectory() {

		for (File clear : init.listFiles()) {

			if (clear.isDirectory()) {

				for (File clear2 : clear.listFiles()) {

					clear2.delete();

				}

				clear.delete();

			} else {

				clear.delete();

			}

		}

	}

	/**
	 * this method is used to sort every {@link Word} {@link ArrayList}: it checks
	 * all the objects and orders them by their counter, in descending order.
	 * 
	 * @param a
	 *            the {@link ArrayList} which needs to be checked
	 * @return the sorted {@link ArrayList}
	 */
	public static ArrayList<Word> sort(ArrayList<Word> a) {

		for (int i = 0; i < a.size() - 1; i++) {

			for (int n = i + 1; n < a.size(); n++) {

				Word p = a.get(i);
				Word next = a.get(n);

				if (p.getCounter() < next.getCounter()) {

					a.set(i, next);
					a.set(n, p);

				}

			}

		}

		return a;

	}

	/**
	 * this method establishes an unique ID to every {@link Word} object to
	 * highlight it and differentiates from each other.
	 * 
	 * @param a
	 *            the {@link ArrayList} which needs to be checked.
	 * @return the {@link ArrayList} with the right IDs.
	 */
	public static ArrayList<Word> setID(ArrayList<Word> a) {

		for (int l = 0; l < a.size(); l++) {

			a.get(l).setID(l + 1);

		}

		return a;

	}

	/**
	 * this method is used to compute every {@link Word} {@link ArrayList}: it
	 * checks all the objects and modify the equal ones, by increasing their
	 * counter, modifying the title and the author fields.
	 * 
	 * @param raw
	 *            the {@link ArrayList} which needs to be checked.
	 * @return the computed {@link ArrayList}.
	 */
	public static ArrayList<Word> compute(ArrayList<Word> raw) {

		ArrayList<Word> result = new ArrayList<Word>();

		boolean added = false;

		for (Word toAdd : raw) {

			added = false;

			if (result.isEmpty()) {

				result.add(toAdd);
				added = true;

			} else {

				for (Word alreadyAdded : result) {

					if (alreadyAdded.equals(toAdd)) {

						alreadyAdded.setCounter(alreadyAdded.getCounter() + toAdd.getCounter());

						alreadyAdded.addTitle(toAdd.getTitle());

						alreadyAdded.addAuthor(toAdd.getAuthor());

						added = true;

					}
				}

				if (!added)

					result.add(toAdd);

			}

		}

		return result;

	}

	/**
	 * a Facade method, used to perform all the necessary operations to a
	 * {@link Word} {@link ArrayList}
	 * 
	 * @param raw
	 *            the {@link ArrayList} which needs to be checked.
	 * 
	 * @return the final {@link ArrayList}.
	 */
	public static ArrayList<Word> songList(ArrayList<Word> raw) {

		raw = compute(raw);
		raw = sort(raw);
		raw = setID(raw);

		return raw;

	}

}
