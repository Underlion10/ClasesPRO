package modelo;

public class Datos {
	private  String[] diasSemana = { "lunes", "martes", "miercoles", "jueves", "viernes", "sábado", "domingo" };
    private Estudiante[] estudiantes;
    private   int numEstudiantes = 30;
    private String[] equipos = {"RMA", "BCN", "SEV", "VIL"};
    private String[][] resultados = {
			{null, "1-4", "4-8", "7-0"},
			{"2-0", null, "2-4", "1-0"},
			{"3-0", "2-6", null, "2-3"},
			{"4-6", "1-9", "3-1", null},
	};
    
    public static int[][] puntosJornada = {
    		{3,0,0,3},
    		{1,0,3,1},
    		{1,3,1,0},
    		{1,1,1,1},
    		{3,1,1,3},
    		{0,0,3,3},
    };
    
    Equipo RMA = new Equipo("Real Madrid");
	Equipo BCN = new Equipo("FC Barcelona");
	Equipo SEV = new Equipo("Sevilla FC");
	Equipo VIL = new Equipo("Villareal FC");
	
	private Equipo[] equiposLiga = {RMA,BCN,SEV,VIL};

	// Declarar propiedad private,un array  de Estudiantes
	// crea getter/setter
	// en el constructor de esta clase, INICIALIZAR dicho array 
	
	public Datos() {
		
	// INICIALIZA AQUI EL ARRAY estudiantes....
	estudiantes = new Estudiante[numEstudiantes];
	Estudiante est1 = new Estudiante(12);
	est1.setNombre("Pedro Perez");
	Estudiante est2 = new Estudiante(12);
	est2.setNombre("Maria Navarro");
	
	
	estudiantes[0]= est1;
	estudiantes[1]= est2;

	}

	public Estudiante[] getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(Estudiante[] estudiantes) {
		this.estudiantes = estudiantes;
	}

	public  String[] getDiasSemana() {
		return diasSemana;
	}

	public  void setDiasSemana(String[] diasSemana) {
		diasSemana = diasSemana;
	}

	public String[] getEquipos() {
		return equipos;
	}

	public void setEquipos(String[] equipos) {
		this.equipos = equipos;
	}

	public String[][] getResultados() {
		return resultados;
	}

	public void setResultados(String[][] resultados) {
		this.resultados = resultados;
	}

	public Equipo[] getEquiposLiga() {
		return equiposLiga;
	}
}
