package auxiliar;

import java.util.Random;

import modelo.Datos;
import modelo.Estudiante;

public class Practicas {
	// private static String[] diasSemana = { "lunes", "martes", "miercoles",
	// "jueves", "viernes", "sábado", "domingo" };

	// ORDENACION

	public int[] obtenerClasificacion(String[][] resultados, String[] equipos) {
		int[] puntos = new int[equipos.length];
		for (int i = 0; i < resultados.length; i++) 
			for (int j = 0; j < resultados[i].length; j++) 
				if (i != j) {
					String[] resultado = resultados[i][j].split("-");
					int golesLocal = Integer.parseInt(resultado[0]);
					int golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						puntos[i] += 3;

					if (golesLocal < golesVisitante)
						puntos[j] += 3;

					if (golesLocal == golesVisitante) {
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		
		ordenarEquipos(puntos, equipos);
		
		for (int i = 0; i < puntos.length; i++) 
			System.out.println(i + 1 + "º " + equipos[i] + " " + puntos[i]);
		
		return puntos;
	}
	
	private void ordenarEquipos(int[] puntos, String[] equipos) {
		for (int i = 0; i < puntos.length; i++)
			for (int j = i + 1; j < puntos.length - 1; j++)
				if (puntos[i] < puntos[j]) {
					int aux = puntos[i];
					String aux1 = equipos[i];
					puntos[i] = puntos[j];
					puntos[j] = aux;
					equipos[i] = equipos[j];
					equipos[j] = aux1;
				}
	}
	
	

	public char obtenerLetra(String dni) {
		char[] letra = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };
		int numeroDNI = 0;
		try {
			numeroDNI = Integer.parseInt(dni);
		} catch (NumberFormatException e) { 
			System.out.println("Numero Incorecto");
			return ' ';
		}
		
		int letraN = numeroDNI % 23;
		if(dni.length() == 8)
			for (int i = 0; i < letra.length; i++)
				if (letraN == i) {
					System.out.println(letra[i]);
					return letra[i];
				}

		return ' ';
	}

	public void mezclaArrays(int[] numero1, int[] numero2) {
		ordenaEnteros(numero1);
		ordenaEnteros(numero2);

		int[] resultado = new int[numero1.length + numero2.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i != numero1.length && j != numero2.length) {
			if (j == numero2.length - 1) {
				resultado[k++] = numero1[i++];
				continue;
			}
			if (i == numero1.length - 1) {
				resultado[k++] = numero2[j++];
				continue;
			}

			if (numero1[i] < numero2[j])
				resultado[k] = numero1[i++];
			else
				resultado[k] = numero2[j++];
			k++;

		}

		for (int k2 = 0; k2 < resultado.length; k2++) {
			System.out.println(resultado[k2]);
		}

	}

	public void ordenaEnteros(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] > numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
	}

	public void ordenaCadenas(String[] cadenas) {
		for (int i = 0; i < cadenas.length - 1; i++)
			for (int j = i + 1; j < cadenas.length; j++)
				if (cadenas[i].compareTo(cadenas[j]) > 0) {
					String aux = cadenas[i];
					cadenas[i] = cadenas[j];
					cadenas[j] = aux;
				}

	}

	public void ordenaEstudiantes(Estudiante[] estudiantes) {
		// Ejemplo uso interface comparable, debe implementarse el metodo compareTo
		for (int i = 0; i < estudiantes.length - 1; i++)
			for (int j = i + 1; j < estudiantes.length; j++)
				if (estudiantes[i].compareTo(estudiantes[j]) > 0) {
					Estudiante aux = estudiantes[i];
					estudiantes[i] = estudiantes[j];
					estudiantes[j] = aux;
				}

	}

	// FIN ORDENACION

	public float calculaSaldo(float saldoInicial, float[] movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.length; i++)
			saldoFinal += movimientos[i];
		return saldoFinal;
	}

	public int[] convierteCadenasANumeros(String[] cadenas) {
		int[] resultado = new int[cadenas.length];
		for (int i = 0; i < resultado.length; i++) {

			try {

				resultado[i] = Integer.parseInt(cadenas[i]);
			} catch (NumberFormatException e) {

				resultado[i] = -1;
			}
		}
		return resultado;
	}

	public void muestraNumeros() {

		int x = 0;
		while (x <= 1000) {
			System.out.println("x: " + x);
			x++;
		}
	}

	public void muestraNumeros(int min, int max) {

		if (min <= max) {
			int x = min;
			while (x <= max) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros2(int min, int max) {

		if (min <= max) {
			int x = min;
			do {
				System.out.println("x: " + x);
				x++;
			} while (x <= max);
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros3(int min, int max) {
		int x = min;
		if (min <= max) {
			// for (int x = min; x < max; x++) {
			// for (;;) {
			while (true) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void generaAleatorios(int cuantos, int inferior, int superior) // max 30, min 10
	{

		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + (int) (Math.random() * (superior - inferior + 1)));

	}

	public void generaAleatorios2(int cuantos, int inferior, int superior) // max 30, min 10
	{

		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
	}

	public int[] generaAleatorios3(int cuantos, int inferior, int superior) // max 30, min 10
	{
		int[] resultado = new int[cuantos];
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			// System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
			resultado[i] = inferior + rnd.nextInt(superior - inferior + 1);
		return resultado;
	}

	public int[] frecuenciaAparicion(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		int[] lanzamientos = this.generaAleatorios3(cuantos, inferior, superior);
		for (int i = 0; i < lanzamientos.length; i++) {
			resultado[lanzamientos[i] - 1]++;
		}
		return resultado;

	}

	public void estadisticaCadena(String cadena) {
		int contadorVocales = 0;
		int contadorMayusculas = 0;
		int contadorEspeciales = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o'
					|| cadena.charAt(i) == 'u' || cadena.charAt(i) == 'A' || cadena.charAt(i) == 'E'
					|| cadena.charAt(i) == 'I' || cadena.charAt(i) == 'O' || cadena.charAt(i) == 'U')
				contadorVocales++;
			if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z')
				contadorMayusculas++;
			int caracterAscii = cadena.charAt(i);
			if ((caracterAscii >= 0 && caracterAscii <= 47) || (caracterAscii >= 58 && caracterAscii <= 64) ||

					(caracterAscii >= 91) && (caracterAscii <= 96))

				contadorEspeciales++;
		}
		// System.out.println("Hay " + contadorVocales + " vocales en " + cadena);
		System.out.println("Hay " + contadorEspeciales + " caracteres especiales en " + cadena);

	}

	public void listaDiasSemana() {
		Datos datos = new Datos();
		// String[] diasSemana = { "lunes", "martes", "miercoles", "jueves", "viernes",
		// "sábado", "domingo" };
		// for (int i = 0; i < datos.getDiasSemana().length; i++)
		for (String dia : datos.getDiasSemana())
			// System.out.println(datos.getDiasSemana()[i]);
			System.out.println(dia);
	}

	public void listaEstudiantes(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public int visitantesIslaYear(int isla, int[][] v) {
		int acu = 0;
		for (int j = 0; j < v[0].length; j++)
			acu += v[isla][j];
		return acu;
	}

	public int visitantesMesYear(int mes, int[][] v) {
		int acu = 0;
		for (int i = 0; i < v.length; i++)
			acu += v[i][mes];
		return acu;
	}
}
