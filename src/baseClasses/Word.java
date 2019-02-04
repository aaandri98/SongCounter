package baseClasses;

import java.util.ArrayList;

/**
 * the {@link Word} class is one of the two basic classes of the whole project:
 * it is the smallest part of the project, and provides useful tools to manage
 * the words contained in a song.
 * 
 * @author Andrea Righi
 *
 */
public class Word {

	private String word;
	private ArrayList<String> title, author;
	private int counter, ID;

	public Word(String word, String title, String author) {

		this.title = new ArrayList<String>();
		this.author = new ArrayList<String>();

		this.word = word;

		this.title.add(title);
		this.author.add(author);

		counter = 1;

	}

	public ArrayList<String> getAuthor() {

		return author;

	}

	public ArrayList<String> getTitle() {

		return title;

	}

	public int getCounter() {

		return counter;

	}

	public void addAuthor(ArrayList<String> a) {

		for (String toCheck : a) {

			if (!author.contains(toCheck)) {

				author.add(toCheck);

			}

		}

	}

	public void addTitle(ArrayList<String> t) {

		for (String toCheck : t) {

			if (!title.contains(toCheck)) {

				title.add(toCheck);

			}

		}

	}

	public void setCounter(int num) {

		counter = num;

	}

	/**
	 * this method provides the equal method for the {@link Word} class: it compares
	 * the literal word contained into the object.
	 * 
	 * @param a
	 *            the {@link Word} object which must be analyzed.
	 * @return true if the two objects are equal, false otherwise.
	 */
	public boolean equals(Word a) {

		boolean flag = false;

		if (this.word.equals(a.word))
			flag = true;
		else
			flag = false;

		return flag;

	}

	public void setID(int num) {

		ID = num;

	}

	public String toString() {

		String totalTitle = "", totalAuthor = "";

		for (int i = 0; i < title.size(); i++) {

			if (i == 0) {

				totalTitle += title.get(i);

			} else {

				totalTitle += " & " + title.get(i);

			}

		}

		for (int i = 0; i < author.size(); i++) {

			if (i == 0) {

				totalAuthor += author.get(i);

			} else {

				totalAuthor += " & " + author.get(i);

			}

		}

		return ID + "," + word + "," + totalTitle + "," + title.size() + " \\ " + Song.all.size() + "," + totalAuthor
				+ "," + counter;

	}

}
