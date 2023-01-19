package cotuba.cli;

import java.nio.file.Path;

import cotuba.application.Cotuba;

public class Main {

	public static void main(String[] args) {

		Path diretorioDosMD;
		String formato = null;
		Path arquivoDeSaida = null;
		boolean modoVerboso = false;

		try {

			var opcoesCLI = new LeitorOpcoesCLI(args);

			diretorioDosMD = opcoesCLI.getDiretorioDosMD();
			formato = opcoesCLI.getFormato();
			arquivoDeSaida = opcoesCLI.getArquivoDeSaida();
			modoVerboso = opcoesCLI.modoVerboso;
			
			var cotuba = new Cotuba();
			cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);

			System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			if (modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

}
