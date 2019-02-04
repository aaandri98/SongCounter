package computation;

import java.util.ArrayList;

import baseClasses.Song;
import baseClasses.Word;
import tools.Utility;
import tools.Writer;

/**
 * the {@link SongByArtist} class is used to gather all the {@link Song} objects
 * which have the same author.
 * 
 * @author Andrea Righi
 *
 */
public class SongByArtist {

	private ArrayList<Song> allSongs = Song.all;
	static ArrayList<Word> byArtist = new ArrayList<Word>();
	private ArrayList<String> artists = new ArrayList<String>();

	public SongByArtist() {

		this.getArtists();
		this.songSameArtist();

	}

	/**
	 * this method is used to get the name of all the artists contained into the
	 * files which have to be analyzed during the execution of the program.
	 */
	public void getArtists() {

		for (Song f : allSongs) {

			String name = f.getAuthor();

			boolean added = false;

			if (artists.isEmpty()) {

				artists.add(name);

			} else {

				for (String alreadyAdded : artists) {

					if (alreadyAdded.equals(name)) {

						added = true;

					}

				}

				if (!added) {

					artists.add(name);

				}

			}

		}

	}

	public void songSameArtist() {

		for (int i = 0; i < artists.size(); i++) {

			ArrayList<Word> songList = new ArrayList<Word>();

			ArrayList<Word> chosenSong = new ArrayList<Word>();

			String artistToFind = artists.get(i);

			for (Song a : allSongs) {

				if (a.getAuthor().equals(artistToFind)) {

					chosenSong.addAll(a.getSong());

				}
			}

			songList = Utility.songList(chosenSong);

			byArtist.addAll(songList);

			String result = "N, Parola, Canzone, Canzoni sul totale, Autore, Apparizioni Tot\n";

			for (Word toPrint : songList) {

				result += toPrint + "\n";

			}

			Writer.saveMultipleSong(result, artistToFind);

		}

	}

}
