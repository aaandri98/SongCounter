package computation;

import java.util.ArrayList;

import baseClasses.Word;
import tools.Utility;
import tools.Writer;

/**
 * the {@link FinalComputation} class has a unique method, which gather all the
 * songs and create a unique record, which will be written thanks to the
 * {@link Writer} class' method.
 * 
 * @author Andrea Righi
 *
 */
public class FinalComputation {

	public FinalComputation() {

		this.songSameArtist();

	}

	/**
	 * this method gathers all the song analyzed during the program's execution, and
	 * writes a unique record.
	 */
	public void songSameArtist() {

		ArrayList<Word> songList = new ArrayList<Word>();

		songList = Utility.songList(SongByArtist.byArtist);

		String result = "N, Parola, Canzone, Canzoni sul totale, Autore, Apparizioni Tot\n";

		for (Word toPrint : songList) {

			result += toPrint + "\n";

		}

		Writer.saveFinal(result);

	}

}
