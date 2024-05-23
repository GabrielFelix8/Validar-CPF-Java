import java.util.Scanner;

public class ValidarCPF_String
{
	public static void main(String[] args)
	{
		Scanner teclado = new Scanner(System.in);
		int i; 
		int DV1i, DV2i, DV1c, DV2c;
		int peso, soma, resto;
		String CPF = new String();
		char digito_CHAR;
		int digito_INT;
		StringBuffer cpf = new StringBuffer();
		int estado;

		while (CPF.length() != 11)
		{
			System.out.print("Informe seu CPF (apenas d�gitos): ");
			CPF = teclado.next();
		}

		// obt�m o 1� d�gito verificador informado (DV1i)
		DV1i = Character.digit(CPF.charAt(9), 10);

		// obt�m o 2� d�gito verificador informado (DV2i)
		DV2i = Character.digit(CPF.charAt(10), 10);

		// calcula o 1� d�gito verificador (DV1c)
		soma = 0;
		peso = 10;
		for (i = 0; i < 9; i++)
		{
			digito_CHAR = CPF.charAt(i);
			digito_INT = Character.digit(digito_CHAR, 10);
			soma = soma + peso * digito_INT;
			peso--;
		}

		// se resto da divis�o (DV1c/11) < 2, 
		// ent�o DV1c = 0; sen�o DV1c = 11 - DV1c
		resto = soma % 11;
		if (resto < 2)
			DV1c = 0;
		else
			DV1c = 11 - resto;

		// calcula o 2� d�gito verificador (DV2c)
		soma = 0;
		peso = 11;
		for (i = 0; i < 10; i++)
		{
			digito_CHAR = CPF.charAt(i);
			digito_INT = Character.digit(digito_CHAR, 10);
			soma = soma + peso * digito_INT;
			peso--;
		}

		// se resto da divis�o (DV2c/11) < 2,
		// ent�o DV2c = 0; sen�o DV2c = 11 - dv2c
		resto = soma % 11;
		if (resto < 2)
			DV2c = 0;
		else
			DV2c = 11 - resto;

		cpf.append(CPF);
		cpf.insert(3, '.');
		cpf.insert(7, '.');
		cpf.insert(11, '-');

		if ((DV1c == DV1i) && (DV2c == DV2i))
		{
			System.out.print("\nCPF " +  cpf.toString() + " V�LIDO");
			System.out.print(" - ");
			estado = Character.digit(CPF.charAt(8), 10);
	        switch (estado)
	        {
		        case 0:
		            System.out.println("Rio Grande do Sul");
		            break;
		        case 1:
		            System.out.println("Centro-Oeste (MS+DF+GO+TO+MT)");
		            break;
		        case 2:
		            System.out.println("Norte (AC+AM+PA+RR+RO+AP)");
		            break;
		        case 3:
		            System.out.println("Nordeste-Norte (CE+PI+MA)");
		            break;
		        case 4:
		            System.out.println("Nordeste-Leste (AL+PE+PB+RN)");
		            break;
		        case 5:
		            System.out.println("Nordeste-Sul (BA+SE)");
		            break;
		        case 6:
		            System.out.println("Minas Gerais");
		            break;
		        case 7:
		            System.out.println("Leste (RJ+ES)");
		            break;
		        case 8:
		            System.out.println("S�o Paulo");
		            break;
		        case 9:
		            System.out.println("Sul (PR+SC)");
		            break;
	            default:
	            	System.out.println("CPF INV�LIDO!");	
	        }
		}
		else
			System.out.println("\nCPF " +  cpf.toString() + " INV�LIDO");

		teclado.close();
	}
}
