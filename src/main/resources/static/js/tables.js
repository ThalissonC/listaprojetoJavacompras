var btAlterar = document.getElementById('btAdicionarPontoTabela');



// Variável Referência:
var alterTable = 0;

// ======================================================
//  FUNÇÃO EXECUTADA APÓS CLICAR NA SETA PARA A DIREITA
//       -- Adiciona um valor a variável referência
//               para que possa ser alterado
//                  o conteúdo da tabela.
//
//                        \  /
//                         \/
// =======================================================
function adicionarPontoTable(){
        alterTable ++
        console.log(alterTable)
}




// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//
//  FUNÇÃO EXECUTADA APÓS CLICAR NA SETA PARA A ESQUERDA
//       -- Diminui um valor a variável referência
//               para que possa ser alterado
//                  o conteúdo da tabela.
//
//                        \  /
//                         \/
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
function diminuirPontoTable(){
        if (alterTable > 0){
            alterTable --
            console.log(alterTable)
        }
}

function AlterarTable_e_Conteudo() {
    var alteraTitulo = document.getElementById('tituloPage');

    var tabelaAlterar = document.getElementById('tableValor');
    var alterarConteudoParaTabelaListaDeItens = document.getElementById('tabelaItensDaLista')
    var alterarConteudoParaTabelaItensJaComprados = document.getElementById('tabelaItensJaComprados')
    if(alterTable === 0){
//        tabelaAlterar.innerHTML = 'Lista de Itens'
//        alterarConteudoParaTabelaListaDeItens.style.display = '';
//        alterarConteudoParaTabelaItensJaComprados.style.display = 'none';
    } else {
        if(alterTable === 1){

//            alterarConteudoParaTabelaListaDeItens.style.display = 'none';
//            alterarConteudoParaTabelaItensJaComprados.style.display = '';
        } else {

        }
    }

}









//var itensJaComprados = true;
//function SetarTabelaDeItensJaComprados(){
//    itensJaComprados = true;
//console.log(itensJaComprados)
//}






