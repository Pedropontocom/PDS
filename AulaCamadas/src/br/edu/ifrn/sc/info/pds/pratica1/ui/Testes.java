
package br.edu.ifrn.sc.info.pds.pratica1.ui;

import br.edu.ifrn.sc.info.pds.pratica1.dao.AlunoDAO;
import br.edu.ifrn.sc.info.pds.pratica1.domain.Aluno;
import java.util.List;

/**
 *
 * @author 2112605
 */
public class Testes {
    
    public static void main(String[] args) {
        
        Aluno objAluno1 = new Aluno("123456", "Fulano Silva", 100);
        
        AlunoDAO dao = new AlunoDAO();
       boolean resultado = dao.inserir(objAluno1);
       
       if (resultado == true){
           System.out.println("Aluno inserido com sucesso");
       }
       else{
           System.out.println("Falha na inserção");
       }
    }
}
