package com.projeto.redes2client.Cripto;

public class Criptografar {
    static private char Matriz_Vinegere[][] = new char[27][27];

    static private char vetor[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    static public String Vigenere(String texto, String Chave){
        String TextoCriptografado = "";
        texto = texto.toUpperCase();
        Chave = Chave.toUpperCase();
        String[] textoSeparado = texto.split(" ");
        String NovoTexto = "";
        String NovaChave = "";

        //Criar a tabela
        for(int i = 1; i < 27; i++){
            Matriz_Vinegere[i][0] = vetor[i-1];
            Matriz_Vinegere[0][i] = vetor[i-1];
        }

        int cont = -1;
        int cont2 = 0;
        for(int i = 1; i < 27; i++){
            for(int j = 1; j < 27; j++){
                if(j + cont >= vetor.length){
                    Matriz_Vinegere[i][j] = vetor[cont2];
                    cont2+=1;
                }else
                    Matriz_Vinegere[i][j] = vetor[j + cont];

            }
            cont+=1;
            cont2 = 0;
        }
        //////////////////

        for(int palavras = 0; palavras < textoSeparado.length; palavras++){
            //Verificar tamanho da chave
            if(Chave.length() != textoSeparado[palavras].length()){
                cont = 0;
                while(true){
                    NovaChave = NovaChave + Chave.charAt(cont);
                    cont+=1;

                    if(Chave.length() == cont)
                        cont = 0;

                    if(NovaChave.length() == textoSeparado[palavras].length())
                        break;

                }
            }

            //Criptografar
            for(int i = 0; i < textoSeparado[palavras].length(); i++){
                //System.out.println(textoSeparado[palavras].charAt(i) + " : " + NovaChave.charAt(i) + " -> " + Matriz_Vinegere[textoSeparado[palavras].charAt(i) - 64][NovaChave.charAt(i) - 64]);
                if((textoSeparado[palavras].charAt(i)) - 64 >= 1 && (textoSeparado[palavras].charAt(i) - 64) <= 26){
                    NovoTexto = NovoTexto + Matriz_Vinegere[textoSeparado[palavras].charAt(i) - 64][NovaChave.charAt(i) - 64];
                }
                else{
                    NovoTexto = NovoTexto + textoSeparado[palavras].charAt(i);
                }

            }
            if(TextoCriptografado == "")
                TextoCriptografado = NovoTexto;
            else
                TextoCriptografado = TextoCriptografado + " " + NovoTexto;
            NovoTexto = "";
            NovaChave = "";
        }
        System.out.println(TextoCriptografado);
        return TextoCriptografado;
    }
}
