package runner;

import java.io.File;

import baseClasses.Song;
import computation.FinalComputation;
import computation.SongByArtist;
import tools.Utility;
import tools.Writer;

/**
 * the {@link Runner} class has a single main method, which initialize the
 * necessary folders and opens the "src/testicanzoni" folder, looking for the
 * songs which must be analyzed.
 * 
 * @author Andrea Righi
 *
 */
public class Runner {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Utility.initialize();

		File all = new File("src/testicanzoni");

		Song a;

		for (File f : all.listFiles()) {

			a = new Song(f);

			Writer.saveSingleSong(a);

		}

		SongByArtist b = new SongByArtist();
		FinalComputation c = new FinalComputation();

	}

}
