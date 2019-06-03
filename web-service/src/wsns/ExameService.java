package wsns;

import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;

public class ExameService {

	public Exame[] getExames() {
		
		// rodar query
		ResultSet r = SQL.runQuery("select * from exame");	
	 	
		// ArrayList pois o tamanho é dinâmico
		ArrayList<Exame> list = new ArrayList<Exame>();
		
		// try para tratar a exception do ResultSet
		try { 
			
			// iterando cada linha da tabela para serializar em objetos
			while(r.next()) { 
				
				// instanciar exame
				Exame e = new Exame();
				
				// pegando o valor de cada coluna da linha atual
				e.setId(r.getInt(1)); 
				e.setData(r.getDate(2));
				e.setMedico(r.getString(3));
				e.setPaciente(r.getString(4));
				e.setTipo(r.getString(5));
				e.setEndereco(r.getString(6));
				
				// adicionar na lista
				list.add(e); 
				
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// cast de List para Array
		return list.toArray(new Exame[0]);				
	
	}
	
	public int mergeExames(Exame[] exames) {
		
		ArrayList<String> values = new ArrayList<String>();
		
		for (int i = 0; i < exames.length; i++) {
			Exame e = exames[i];
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			String d = format.format(e.getData());
			values.add("SELECT " + 
				e.getId() + " AS id, " + 
				"'" + d + "' AS [data]" + ", " +
				"'" + e.getMedico() + "' AS medico" + ", " +
				"'" + e.getPaciente() + "' AS paciente" + ", " +
				"'" + e.getTipo() + "' AS tipo" + ", " +
				"'" + e.getEndereco() + "' AS endereco"
			);
		};
		
		String query = "\r\n" + 
				"MERGE INTO exame AS T USING (\r\n" + 
				String.join(" UNION ALL \r\n", values) +
				") AS V \r\n" + 
				"ON (V.id = T.id)\r\n" + 
				"WHEN MATCHED THEN \r\n" + 
				"	UPDATE SET T.[data] = V.[data], T.medico = V.medico, T.paciente = V.paciente, T.tipo = V.tipo, T.endereco = V.endereco\r\n" + 
				"WHEN NOT MATCHED THEN\r\n" + 
				"	INSERT ([data], medico, paciente, tipo, endereco) VALUES\r\n" + 
				"	(V.[data], V.medico, V.paciente, V.tipo, V.endereco);";
		
		return SQL.runCommand(query);
		
	}
		
	public int deleteExames(int[] idsExames) {
		
		ArrayList<String> ids = new ArrayList<String>();
		
		for (int i = 0; i < idsExames.length; i++) {
			ids.add(idsExames[i] + "");
		}
		
		String query = "DELETE FROM exame WHERE id IN (" + String.join(",", ids) + ")";
		
		return SQL.runCommand(query);
		
	}
	
}