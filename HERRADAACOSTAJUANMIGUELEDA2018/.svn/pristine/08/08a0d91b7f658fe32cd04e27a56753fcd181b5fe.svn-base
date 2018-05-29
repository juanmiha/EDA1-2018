package org.eda1.actividad03.ejercicio02;

import static org.junit.Assert.*;

import java.io.File;

import org.eda1.actividad03.ejercicio02.Thesaurus;
import org.junit.Test;

public class ThesaurusTestJUnit4 {

	String inputDirectory = System.getProperty("user.dir") + File.separator +
							"src" + File.separator +
							"org" + File.separator +
							"eda1"+ File.separator +
							"actividad03" + File.separator +
							"ejercicio02" + File.separator;


	@Test
	public void testThesaurus()  {

		Thesaurus thesaurus = new Thesaurus();

		thesaurus.loadThesaurus(inputDirectory + "thesaurus.txt");

		assertTrue(thesaurus.size() == 12);

    	assertTrue(thesaurus.isSynonymousOf("limpio", "aseado"));

    	assertFalse(thesaurus.isSynonymous("aseados"));

    	assertTrue(thesaurus.hasSynonymous("verdadero"));
    	assertEquals(thesaurus.getSynonymous("verdadero"), "[autentico, exacto, fiable, probado, real, serio, veraz, veridico]");

    	assertFalse(thesaurus.hasSynonymous("Berdadero"));
    	assertEquals(thesaurus.getSynonymous("Berdadero"), null);


    	assertTrue(thesaurus.size("trabajador") == 7);

    	assertEquals(thesaurus.getSynonymous("limpio"), "[acicalado, arreglado, aseado, atildado, compuesto, engalanado, pulcro]");


    	thesaurus.add("acabado", "consumido", "concluido", "terminado", "rematado");
    	assertTrue(thesaurus.size() == 13);
    	assertFalse(thesaurus.isSynonymousOf("acabado", "remartado"));
    	assertTrue(thesaurus.size("acabado") == 4);

    	thesaurus.add("acabado", "consumido", "concluido", "terminado", "rematado");
		assertTrue(thesaurus.size() == 13);


    	thesaurus.add("acabado", "completado");
    	assertTrue(thesaurus.size("acabado") == 5);


    	assertFalse(thesaurus.remove("acabado", "complertado"));
    	assertTrue(thesaurus.size("acabado") == 5);

     	assertTrue(thesaurus.remove("acabado", "completado"));
    	assertTrue(thesaurus.size("acabado") == 4);

    	assertTrue(thesaurus.remove("ganador", "triunfador"));
    	assertTrue(thesaurus.size("ganador") == 6);

    	assertEquals(thesaurus.remove("acabado"), "[concluido, consumido, rematado, terminado]");
		assertTrue(thesaurus.size() == 12);

		assertEquals(thesaurus.remove("acabado"), null);
		
    	assertTrue(thesaurus.isSynonymousOf("falso", "embustero"));
    	assertTrue(thesaurus.size("falso") == 4);

    	thesaurus.update("falso", "erroneo", "inexacto", "infundado");

		assertFalse(thesaurus.isSynonymousOf("falso", "embustero"));
    	assertTrue(thesaurus.size("falso") == 3);

    	thesaurus.update("falso", "inexacto", "infundado");
    	assertTrue(thesaurus.size("falso") == 2);
	}
}