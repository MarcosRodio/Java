package MapaProgramacao2.src.br.unicesumar.aula;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class ProjetoImpl implements ProjetoDAO{
     //Collection que irá armazenar todos os projetos
    private static Set<Projeto> projetos = new HashSet<>();
 
 
    @Override
    public void adicionar(Projeto projeto) {
        if(projeto.getDataInicio().compareTo(projeto.getDataFinal()) == 1){
            System.out.println("Data de Inicio Maior que Data final");
        }else{
            projetos.add(projeto);
        }
        
        
    }
 
    @Override
    public List<Projeto> listar() {
        List<Projeto> listaProjeto = new ArrayList<Projeto>();
        int temp = 0;
        for(Projeto projeto : projetos){
            listaProjeto.add(projeto);
            temp = 1;
        }
        if(temp == 0){
            System.out.println("Nenhum Projeto Cadastrado: ");
        }
        return listaProjeto;
    }
 
    @Override
    public Projeto consultarPorNome(String nome) throws DadoConsultadoException {
        Projeto temp =  new Projeto();
        temp = null;
        for(Projeto p : projetos){    
                
            if(nome.equals(p.getNome()) == true){
                temp =  p;
            }
        }
        return temp;
    }
 
    @Override
    public Projeto alterar(String nome, Projeto projeto) throws DadoConsultadoException {
        int temp = 0;
        for(Projeto p : projetos){                   
            if(nome.equals(p.getNome()) == true){
                temp = 1;
                p.substituir(projeto);
                System.out.println("Alterado com Sucesso: "+p.getNome());
            }
        }
        if(temp == 0){
            System.out.println("Projeto Não Encontrado");
        }
        return null;
    }
 
    @Override
    public void excluir(Projeto projeto) throws DadoConsultadoException, UnsupportedOperationException {
        
    }
 
    @Override
    public void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException {
        Projeto temp =  new Projeto();
        temp = null;
        for(Projeto p : projetos){    
                
            if(nome.equals(p.getNome()) == true){
                temp =  p;
                System.out.println(p.toString());
                System.out.println("Excluido com sucesso");
            }
        }
        if(temp == null){
            System.out.println("Projeto Não Encontrado");
        }else{
            projetos.remove(temp);
        }
        
    }
}