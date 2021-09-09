function exibirCamposDeAdicao(){
    var inputNomeVisivel = document.getElementById("inputNome").style.visibility = 'visible';
    var inputQtdVisivel = document.getElementById("inputQtd").style.visibility = 'visible';
    var inputValorVisivel = document.getElementById("inputValorUnitario").style.visibility = 'visible';
    var botaoDeAdicaoVisivel = document.getElementById("botaoAdd").classList.remove("hidden");
    var btEsconderCamposDeAdicao = document.getElementById('cancelarAdicao').classList.remove("hidden");

    var ativarMargemDeAdicao = document.getElementById("margemDeAdicao").classList.add("sp-20b");

}

function btDelRedirect(){
//    var DelRedirect = document.getElementById("btDeletarRedirect")
    window.location = "/localhost:8080/"
}

function esconderCamposDeAdicao() {
    var inputNomeVisivel = document.getElementById("inputNome").style.visibility = 'hidden';
    var inputQtdVisivel = document.getElementById("inputQtd").style.visibility = 'hidden';
    var inputValorVisivel = document.getElementById("inputValorUnitario").style.visibility = 'hidden';
    var botaoDeAdicaoVisivel = document.getElementById("botaoAdd").classList.add("hidden");
    var btEsconderCamposDeAdicao = document.getElementById('cancelarAdicao').classList.add("hidden");

}

//formatarValorEmReal