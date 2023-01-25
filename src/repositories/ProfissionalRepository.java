package repositories;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import abstractions.ProfissionalRepositoryAbstract;
import entities.Profissional;
import entities.Servico;

public class ProfissionalRepository extends ProfissionalRepositoryAbstract{
	@Override
	public void exportar(Profissional profissional) throws Exception {
		// TODO Auto-generated method stub
		
		File directory = new File(PATH);
		
		//verificando se a pasta c://temp não existe
		if (!directory.exists()) {
			directory.mkdir(); //criar a pasta
		}
		
		//abrindo um arquivo em modo de escrita
		PrintWriter printWriter = new PrintWriter(new FileWriter(PATH + "profissionais.txt", true));
		
		//imprimindo as informações do profissional
		printWriter.write("\n\nDADOS DO PROFISSIONAL:");
		printWriter.write("\n\tID.......:" + profissional.getIdProfissional());
		printWriter.write("\n\tNOME.....:" + profissional.getNome());
		printWriter.write("\n\tTELEFONE.:" + profissional.getTelefone());
		
		printWriter.write("\nDADOS DO ESTABELECIMENTO:");
		printWriter.write("\n\tID.........:" + profissional.getEstabelecimento().getIdEstabelecimento());
		printWriter.write("\n\tNOME.......:" + profissional.getEstabelecimento().getNome());
		printWriter.write("\n\tCNPJ.......:" + profissional.getEstabelecimento().getCnpj());
		
		printWriter.write("\nDADOS DOS SERVIÇOS:");
		for(Servico servico : profissional.getServicos()) { //FOR EACH
			
			printWriter.write("\n\tID............: " + servico.getIdServico());
			printWriter.write("\n\tNOME..........: " + servico.getNome());
			printWriter.write("\n\tPRECO.........: " + servico.getPreco());
			printWriter.write("\n\tTEMPO EM MIN..: " + servico.getTempoEmMinutos());
			printWriter.write("\n\t....");
		}
		
		printWriter.flush(); //salvar o arquivo
		printWriter.close(); //fechar o arquivo
	}
}
